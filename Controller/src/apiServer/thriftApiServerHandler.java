package apiServer;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.thrift.TException;

import Controller.Controller;

import common.ServiceStatus;

import mailClient.api.java.*;

public class thriftApiServerHandler implements
		mailClient.api.java.controlApi.Iface {

	userInfo usrData = new userInfo();
	static MongoDB mdb = new MongoDB();

	private thriftApiServer apiserver;

	public thriftApiServerHandler(thriftApiServer thriftApiServer) {
		this.apiserver = thriftApiServer;
	}

	@Override
	public String getServerStatus(String key) throws TException {
		logging.logging.debug("debug");
		String serverStatus = "";
		for(int i=0; i<Controller.Senders.length; i++)
			serverStatus = String.format("%s%f,%d,%d,%d,%d@", serverStatus, Controller.Senders[i].Monitoring.CPU, Controller.Senders[i].Monitoring.Memory, Controller.Senders[i].Monitoring.NetworkOut_Byte, Controller.Senders[i].Monitoring.SendCount, Controller.Senders[i].Monitoring.Thread);//serverStatus + "50,500,777,8,125@";
		return serverStatus;
	}

	@Override
	public boolean logIn(String key) throws TException {
		logging.logging.debug("debug");
		StringTokenizer st = new StringTokenizer(key, "@", false);
		String id = st.nextToken();
		String passwd = st.nextToken();
		ArrayList<User> users = new ArrayList<User>();
		users = mdb.Load_UserList();
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).ID);
			if ( (users.get(i).ID.equals(id)) && (users.get(i).PW.equals(passwd))  ) {
				usrData.id = id;
				//이 부분 문제 잇음 아이디별 데이터베이스 필요
				mdb.LogIn(usrData.id);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> queryToControl(String key, String query,
			String lookUpKey) throws TException {

		logging.logging.debug("debug");

		int lookKeyParsing = 0;
		String userName = "", groupName = "", timeName = "";

		if (query.equals("read")) {

			
			for (int i = 0; i < lookUpKey.length(); i++) {
				if (lookUpKey.toCharArray()[i] == '@') {
					lookKeyParsing++;
				}
			}

			if (lookKeyParsing == 0) {
				Set<String> temp = mdb.Load_Group();
				List<String> group = new ArrayList<String>();
				for (int j = 0; j < temp.size(); j++) {
					group.add(temp.toArray()[j].toString());
				}
				return group;
			} else if (lookKeyParsing == 1) {
				StringTokenizer st = new StringTokenizer(lookUpKey, "@", false);
				userName = st.nextToken();
				groupName = st.nextToken();
				List<Person> temp = new ArrayList<Person>();
				temp = mdb.Load_GroupList(groupName);
				List<String> person = new ArrayList<String>();
				for (int j = 0; j < temp.size(); j++) {
					String line = temp.get(j).Name + ","
							+ temp.get(j).Mail_Address;
					person.add(line);
				}
				return person;
			} else if (lookKeyParsing == 2) {
				StringTokenizer st = new StringTokenizer(lookUpKey, "@", false);
				userName = st.nextToken();
				groupName = st.nextToken();
				timeName = st.nextToken();

				ArrayList<Send_Mail> temp = new ArrayList<Send_Mail>();
				ArrayList<Send_Mail> temp2 = new ArrayList<Send_Mail>();
				temp = mdb.Load_Mail_List(System.currentTimeMillis(), 0);
				temp2 = mdb.Load_Mail_List(System.currentTimeMillis(), 1);
				for(int i=0;i<temp2.size();i++){
					temp.add(temp2.get(i));
				}
				List<String> mailByTime = new ArrayList<String>();
				SimpleDateFormat sdfNow = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String now = new String();
				for (int i = 0; i < temp.size(); i++) {
					now = sdfNow.format(temp.get(i).Send_Time);
					mailByTime.add(temp.get(i).UserName + " 님이  "
							+ temp.get(i).From_Adress + " 주소로 보낸 \""
							+ temp.get(i).Mail_Title + " \" 메일.  전송시간 : " + now
							+ ",  " + temp.get(i).Send_Time);
				}
				return mailByTime;
			} else if (lookKeyParsing == 3) {
				StringTokenizer st = new StringTokenizer(lookUpKey, "@", false);
				long time = Long.parseLong(st.nextToken().trim());
				List<To_Person> temp = new ArrayList<To_Person>();
				temp = mdb.Load_Client_person(time);
				List<String> mailStat = new ArrayList<String>();
				SimpleDateFormat sdfNow = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String now = new String();
				for (int i = 0; i < temp.size(); i++) {
					now = sdfNow.format(temp.get(i).Check_Time);
					if (temp.get(i).Check_Time != 0)
						mailStat.add(temp.get(i).Group_Name + " 에 속하는 "
								+ temp.get(i).To_Adress + " 메일로 전송하였습니다." + now
								+ " 에 확인했습니다."+"*"+temp.get(i).Cord );
					else
						mailStat.add(temp.get(i).Group_Name + " 에 속하는 "
								+ temp.get(i).To_Adress + " 메일로 전송하였습니다."
								+ " 확인하지 않았습니다." + "*"+temp.get(i).Cord);
				}
				return mailStat;
			} else
				return null;

		} else if (query.equals("delete")) {
			StringTokenizer st = new StringTokenizer(lookUpKey, "@", false);

			String what = st.nextToken();
			String thing = st.nextToken();
			List<String> temp = new ArrayList<String>();
			if (what.equals("group")) {
				mdb.Del_Group(thing);
				return temp;
			} else {
				boolean b = mdb.Del_MailList(thing.trim());
				System.out.println(thing);
				System.out.println(b);
				temp = new ArrayList<String>();
				return temp;
			}

		} else {
			return null;
		}
	}

	@Override
	public boolean removeGroup(String key, String groupName) throws TException {
		logging.logging.debug("debug");
		// lookupDb(groupName);
		if ("find".equals(groupName)) {
			;// remove
			return true;
		} else
			return false;
	}

	@Override
	public void sendMailSet(String key, mailSet mail) throws TException {
		logging.logging.debug("debug");

		String addressBook = new String(mail.getAddressBook());
		StringTokenizer st = new StringTokenizer(mail.mailContent, "@");
		String title = st.nextToken();
		String content = st.nextToken();

		int howmany = 0;
		String tickle = null;
		StringTokenizer address = new StringTokenizer(addressBook);
		while (address.hasMoreTokens()) {
			howmany++;
			tickle = address.nextToken();
		}
		StringTokenizer getGroup = new StringTokenizer(tickle, ",", false);
		String groupName = getGroup.nextToken();

		if (mail.creatAddress) {
			mdb.Add_Mail_Content(false, mail.whenToSend, howmany,
					mail.senderAddress, title, content, usrData.id);
			mdb.Add_Group(groupName);
			address = new StringTokenizer(addressBook);
			while (address.hasMoreTokens()) {
				StringTokenizer group = new StringTokenizer(
						address.nextToken(), ",", false);
				mdb.Add_Person(groupName, group.nextToken(), group.nextToken(),
						group.nextToken());
			}

			List<Person> temp = mdb.Load_GroupList(groupName);

			for (int i = 0; i < temp.size(); i++) {
				mdb.Add_To_Person(mail.whenToSend, temp.get(i).Mail_Address,
						groupName);
			}

		} else {
			List<Person> temp = new ArrayList<Person>();
			temp = mdb.Load_GroupList(addressBook);

			mdb.Add_Mail_Content(false, mail.whenToSend, temp.size(),
					mail.senderAddress, title, content, usrData.id);
			for (int i = 0; i < temp.size(); i++) {
				boolean b = mdb.Add_To_Person(mail.whenToSend,
						temp.get(i).Mail_Address, addressBook);
			}

		}

	}

	@Override
	public boolean userFix(String key, String changePasswd) throws TException {
		logging.logging.debug("debug");
		// access to user DB
		// change passwd
		String Id,Pw;
		StringTokenizer st = new StringTokenizer(changePasswd,"@",false);
		Id = st.nextToken();
		Pw = st.nextToken();
		boolean t = true;
		t = mdb.Add_User(Id,Pw);
		return true;
	}

	@Override
	public ServiceStatus getServiceStatus() throws TException {

		logging.logging.debug("debug");
		ServiceStatus serviceStatus = new ServiceStatus();

		serviceStatus.setHostName(apiserver.getHostName());
		serviceStatus.setPort(apiserver.getPort());
		serviceStatus.setStatus("OK");

		return null;
	}
}
