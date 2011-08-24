package apiServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.thrift.TException;

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
		String serverStatus = null;
		return serverStatus;
	}

	@Override
	public boolean logIn(String key) throws TException {
		logging.logging.debug("debug");
		if (key.equals(key)) {
			// db에 id 읽어와서 집어 넣기//
			usrData.id = "poweroyh";
			mdb.LogIn(usrData.id);
			return true;
		} else
			return false;
	}

	@Override
	public List<String> queryToControl(String key, String query,
			String lookUpKey) throws TException {
		logging.logging.debug("debug");

		int lookKeyParsing = 0;
		String userName = "", groupName = "",timeName="";
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
			} else if(lookKeyParsing == 2) {
				StringTokenizer st = new StringTokenizer(lookUpKey,"@",false);
				userName = st.nextToken();
				groupName = st.nextToken();
				timeName = st.nextToken();
				
				ArrayList<Send_Mail> temp = new ArrayList<Send_Mail>();
				temp = mdb.Load_Mail_List(System.currentTimeMillis(), 0);
				List<String> mailByTime = new ArrayList<String>();
				for(int i=0;i<temp.size();i++)
				{
					mailByTime.add(temp.get(i).From_Adress+temp.get(i).Mail_Title+temp.get(i).Send_Time +temp.get(i).UserName);
				}
				return mailByTime;
			}
			else{
				
			}

		} else if (query.equals("two")) {
			;
		} else {

		}
		return null;
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
		if (mail.creatAddress) {
			// create new table in db
		} else {
			mdb.Add_Mail_Content(false, mail.whenToSend, 0, mail.senderAddress, "니마 제발", mail.mailContent,"poweroyh");
		}
		// do send;

	}

	@Override
	public boolean userFix(String key, String changePasswd) throws TException {
		logging.logging.debug("debug");
		// access to user DB
		// change passwd
		boolean success = true;
		if (success) {
			return true;
		} else
			return false;
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