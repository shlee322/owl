package apiServer;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.thrift.TException;
import common.ServiceStatus;
import controlApi.controlApi;
import controlApi.mailSet;

;

public class apiServerHandler implements controlApi.Iface {

	private apiServer server;

	public apiServerHandler(apiServer server) {
		this.server = server;
	}

	String endBit = "@_@";

	@Override
	public String getStatic(String sendDate) throws TException {
		/* before package we have to get data through sql data base. */
		// At this time we make random number and return to client //
		// 실제 패키징하기 전까지 sql 데이터 베이스를 이용함 //
		/* 지금은 그냥 랜덤 숫자로 리턴. */
		// sucess- fail- node status- server name- server port//

		// db에서 읽어올 부분//
		String nState = "111111";
		String host = server.getHostName();
		String port = String.valueOf(server.getPort());
		int sucMail = (int) (Math.random() * 1000);
		int failMail = (int) (Math.random() * 100);

		// read from database, return result string//
		// db에서 데이터를 읽어오 결과를 스트링으로 리턴//
		try {
			BufferedReader br = new BufferedReader(new FileReader(sendDate));
			return String.valueOf(sucMail) + endBit + String.valueOf(failMail)
					+ endBit + nState + endBit + host + endBit + port + endBit
					+ br.readLine();
		} catch (FileNotFoundException e) {
			return "fail";
		} catch (IOException e) {
			e.printStackTrace();
			return "fail";
		}

	}

	@Override
	public void sendMailSet(mailSet mailset) throws TException {
		// instead database, use text file to contain status//
		// 데이터베이스 대신 텍스트 파일을 이용해서 상태 저장//
		String _group = null;
		boolean isGroupOpen = false;
		MongoDB mdb = new MongoDB();
		mdb.DBStart("poweroyh");
		StringTokenizer st = new StringTokenizer(new String(mailset
				.getAddressBook()),"\n",false );
		while (st.hasMoreTokens()) {
			String line = st.nextToken();
			StringTokenizer token = new StringTokenizer(line, ",", false);
			if (!isGroupOpen) {
				_group = token.nextToken();
				mdb.Add_Group(_group);
				isGroupOpen = true;
			} 
			{
				token = new StringTokenizer(line, ",", false);
				//System.out.println(token.nextToken()+ token.nextToken()+ token.nextToken() );//+ token.nextToken());
				mdb.Add_Person(token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken());
			}
		}
		ArrayList<Person> PersonList = new ArrayList<Person>();
		PersonList = MongoDB.Load_Group(_group);
		for (Person person : PersonList) {
			System.out.println(person.Name);
		}
	}

	@Override
	public ServiceStatus getServiceStatus() throws TException {
		ServiceStatus servicestatus = new ServiceStatus();
		servicestatus.setHostName(server.getHostName());
		servicestatus.setPort(server.getPort());
		servicestatus.setStatus("ok");
		return servicestatus;
	}
}
