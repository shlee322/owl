package Controller;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.mongodb.*;

import com.googlecode.protobuf.netty.*;

public class Controller {
	static NettyRpcServer Sender_Server;
	static TServer Client_Server;
	public static void main(String ar[]) throws TTransportException
	{/*
		Controller.Sender_Server = new NettyRpcServer(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
		
		Controller.Sender_Server.registerService(Protocol.SenderController.SenderHandler.newReflectiveService(new SenderHandler()));
		Controller.Sender_Server.serve(new InetSocketAddress(7004));

		final TNonblockingServerSocket socket = new TNonblockingServerSocket(9099);
		final controlApi.controlApi.Processor processor = new controlApi.controlApi.Processor(new ClientHandler());
		Controller.Client_Server = new THsHaServer(processor, socket, new TFramedTransport.Factory(), new TBinaryProtocol.Factory());
		Controller.Client_Server.serve();*/
		
		//일단은 대충대충 만듬
		MongoDB MongoDB = new MongoDB();
		MongoDB.DBStart("jin7h");
		//MongoDB.Del_User("poweroyh");
		MongoDB.Add_Group("SWmaestro");
		MongoDB.Add_Person("SWmaestro", "오유환", "poweroyh@naver.com", "010-2563-7816");
		MongoDB.Add_Person("SWmaestro", "이성민", "poweroyh@naver.com", "010-1111-2222");
		MongoDB.Add_Person("SWmaestro", "이상혁", "poweroyh@naver.com", "010-3333-4444");
		MongoDB.Add_Person("SWmaestro", "임성은", "ㅁㅁㄴㅇㅁㄴㅇ@naver.com", "010-2563-7816");
		MongoDB.Add_Person("SWmaestro", "전수열", "poweroyh@naver.com", "1111-2222-7816");
		MongoDB.Add_Person("SWmaestro", "김종헌", "poweroyh@naver.com", "010-2563-3333");
		MongoDB.printResults();
		MongoDB.Add_Group("SWmaestro");
		
	}
}

class MongoDB
{
	static Mongo m;
	static DB db;
	static String UserName;
	static String GroupName;
	static String SendMailList;
	
	DBCollection GroupColl;
	
	void Del_User(String User)
	{	
		UserName = User;
		m.dropDatabase(UserName);
	}

	//디비 시작
	void DBStart(String User)
	{
		try{
			m = new Mongo("controller.owl.or.kr");
			
			UserName = User;
			db = m.getDB(UserName);
	
			boolean auth = db.authenticate("owl","70210".toCharArray());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//그룹 추가
	void Add_Group(String G_Name)
	{
		GroupName = UserName + "_" + G_Name;
		
		Set<String> colls = db.getCollectionNames();
		
		if(!colls.isEmpty())
		{
			if(db.collectionExists(GroupName))
			{
				System.out.println("같은 그룹명 있음");
			}
			else
			{
				GroupColl = db.createCollection(GroupName, null);
			}
		}
		else
		{
			GroupColl = db.createCollection(GroupName, null);
		}
	}
	
	//그룹 리스트 로드
	ArrayList<Person> Load_Group(String G_Name)
	{
		ArrayList<Person> PersonList = new ArrayList<Person>();
		GroupName = UserName + "_" + G_Name;
		
		GroupColl = db.getCollection(GroupName);
		
		if(GroupColl.getCount() != 0)
		{
			DBCursor cur;
			
			cur = GroupColl.find();

			while (cur.hasNext())
			{
				Person P_Temp = new Person();
				P_Temp.Name = (String) cur.curr().get("name");
				P_Temp.Mail_Address = (String) cur.curr().get("mail");
				P_Temp.Phone = (String) cur.curr().get("phone");
				
				PersonList.add(P_Temp);
			}		
		}
		else
		{
			System.out.println("그룹에 사람 없음");
		}
		return PersonList;
	}
	
	//사람 추가
	void Add_Person(String G_Name, String P_Name, String Mail_Address, String Phone)
	{
		GroupName = UserName + "_" + G_Name;
		GroupColl = db.getCollection(GroupName);
		int num = (int) GroupColl.getCount();
		GroupColl.insert(MakePersonDocument(num+1, P_Name, Mail_Address, Phone));		
	}
	
	void printResults()
	{
		DBCursor cur;
		
		cur = GroupColl.find();

		while (cur.hasNext())
		{
			System.out.println(cur.next().get("index") + "," + cur.curr().get("name") + "," + cur.curr().get("mail") + "," + cur.curr().get("phone"));
		}
	}

	private static BasicDBObject MakePersonDocument(int id, String P_Name, String Mail_Address, String Phone)
	{
		BasicDBObject doc = new BasicDBObject();
		doc.put("id", id);
		doc.put("name", P_Name);
		doc.put("mail", Mail_Address);
		doc.put("phone", Phone);
		return doc;
	}
}

class Person
{
	public int index;
	public String Name;
	public String Mail_Address;
	public String Phone;
}
