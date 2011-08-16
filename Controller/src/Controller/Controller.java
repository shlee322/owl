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
	{
		Controller.Sender_Server = new NettyRpcServer(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
		
		Controller.Sender_Server.registerService(Protocol.SenderController.SenderHandler.newReflectiveService(new SenderHandler()));
		Controller.Sender_Server.serve(new InetSocketAddress(7004));

		/*
		final TNonblockingServerSocket socket = new TNonblockingServerSocket(9099);
		final controlApi.controlApi.Processor processor = new controlApi.controlApi.Processor(new ClientHandler());
		Controller.Client_Server = new THsHaServer(processor, socket, new TFramedTransport.Factory(), new TBinaryProtocol.Factory());
		Controller.Client_Server.serve();
		*/
		//일단은 대충대충 만듬
		/*
		MongoDB MongoDB = new MongoDB();
		MongoDB.DBStart("poweroyh");
		MongoDB.Del_User("poweroyh");
		
		MongoDB.Add_Group("SWmaestro");
		MongoDB.Add_Person("SWmaestro", "오유환", "poweroyh@naver.com", "010-2563-7816");
		MongoDB.Add_Person("SWmaestro", "이성민", "poweroyh@naver.com", "010-1111-2222");
		MongoDB.Add_Person("SWmaestro", "이상혁", "poweroyh@naver.com", "010-3333-4444");
		MongoDB.Add_Person("SWmaestro", "임성은", "ㅁㅁㄴㅇㅁㄴㅇ@naver.c.om", "010-2563-7816");
		MongoDB.Add_Person("SWmaestro", "전수열", "poweroyh@naver.com", "1111-2222-7816");
		MongoDB.Add_Person("SWmaestro", "김종헌", "poweroyh@naver.com", "010-2563-3333");
	//	MongoDB.printResults();
		MongoDB.Add_Group("SWmaestro");
		ArrayList<Person> PersonList = new ArrayList<Person>();
		PersonList = MongoDB.Load_Group("SWmaestro");
		
		for (Person person : PersonList) {
			System.out.println(person.Name);
			
		}
		*/
		
	}
}

class MongoDB
{
	static Mongo m;
	
	static DB AdressDB;
	static DB SendMailDB;
	
	static String UserName;
	static String SendDBName;
	static String GroupName;
	static String SendMailList;
	
	DBCollection GroupColl;
	DBCollection SendMailColl;
	
	void Del_User(String User)
	{	
		UserName = User;
		m.dropDatabase(UserName);
	}

	//디비 시작 (클라에서 로그온 했을때 무조건 이 메소드는 실행 해야함!)
	boolean DBStart(String User)
	{
		try{
			m = new Mongo("controller.owl.or.kr");
			
			UserName = User;
			AdressDB = m.getDB(UserName);	
			AdressDB.authenticate("owl","70210".toCharArray());
			
			SendDBName = User + "_SendMail";
			SendMailDB = m.getDB(SendDBName);
			SendMailDB.authenticate("owl","70210".toCharArray());
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//그룹 추가
	boolean Add_Group(String G_Name)
	{
		try
		{
			GroupName = UserName + "_" + G_Name;
			
			Set<String> colls = AdressDB.getCollectionNames();
			
			if(!colls.isEmpty())
			{
				if(AdressDB.collectionExists(GroupName))
				{
					System.out.println("같은 그룹명 있음");
					return true;
				}
				else
				{
					GroupColl = AdressDB.createCollection(GroupName, null);
					return true;
				}
			}
			else
			{
				GroupColl = AdressDB.createCollection(GroupName, null);
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
		
	}
	
	//그룹 리스트 로드
	ArrayList<Person> Load_Group(String G_Name)
	{
		ArrayList<Person> PersonList = new ArrayList<Person>();
		GroupName = UserName + "_" + G_Name;
		
		GroupColl = AdressDB.getCollection(GroupName);
		
		if(GroupColl.getCount() != 0)
		{
			DBCursor cur;
			
			cur = GroupColl.find();

			while (cur.hasNext())
			{
				Person P_Temp = new Person();
				
				P_Temp.Index = Integer.parseInt(cur.next().get("index").toString());
				P_Temp.Name = cur.curr().get("name").toString();
				P_Temp.Mail_Address = cur.curr().get("mail").toString();
				P_Temp.Phone = cur.curr().get("phone").toString();
				
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
	Boolean Add_Person(String G_Name, String P_Name, String Mail_Address, String Phone)
	{
		try
		{
			GroupName = UserName + "_" + G_Name;
			GroupColl = AdressDB.getCollection(GroupName);
			int num = (int) GroupColl.getCount();
			GroupColl.insert(MakePersonDocument(num+1, P_Name, Mail_Address, Phone));
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//메일 내용부분 추가
	Boolean Add_Mail_Content(long Send_Time, int Send_Num, String From_Adress, String Mail_Title, String Mail_Content)
	{
		try
		{
			SendMailColl = AdressDB.getCollection("Mail_Content");
			
			GroupColl.insert(MakeSendMailDocument(1, Send_Time, Send_Num, From_Adress, Mail_Title, Mail_Content));
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//받는 사람 정보 추가
	Boolean Add_To_Person(long Send_Time, int index, Boolean Sending, int Check_Time, String To_Adress, String Cord)
	{
		try
		{
			String String_Send_Time = Long.toString(Send_Time);
			SendMailColl = AdressDB.getCollection(String_Send_Time);
			
			GroupColl.insert(MakeToPersonDocument(index, Sending, Check_Time, To_Adress, Cord));
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//0이 이하 1이 이상 두개다 날짜면 사이
	ArrayList<Send_Mail> Load_Mail_List(long day, long checkday)
	{
		DBCursor cur;
		SendMailColl = AdressDB.getCollection("Mail_Content");
		ArrayList<Send_Mail> Mail = new ArrayList<Send_Mail>();
		//이하
		//cur = SendMailColl.find(new BasicDBObject().append("id", new BasicDBObject((checkday == 0 ? "$lte" : "$gte"), day)));// <= 상혁이꺼
		if(checkday == 0)
		{
			cur = SendMailColl.find(new BasicDBObject().append("id", new BasicDBObject("$lte", day)));// <=
		}
		//이상
		else if(checkday == 1)
		{
			cur = SendMailColl.find(new BasicDBObject().append("id", new BasicDBObject("$gte", day)));// >=
		}
		//사이값
		else
		{
			cur = SendMailColl.find(new BasicDBObject().append("id", new BasicDBObject("$gte", day)).append("id", new BasicDBObject("$lte", checkday)));
		}
		
		return Mail;
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

	private static BasicDBObject MakePersonDocument(int index, String P_Name, String Mail_Address, String Phone)
	{
		BasicDBObject doc = new BasicDBObject();
		doc.put("index", index);
		doc.put("name", P_Name);
		doc.put("mail", Mail_Address);
		doc.put("phone", Phone);
		return doc;
	}
	
	private static BasicDBObject MakeSendMailDocument(int index, long Send_Time, int Send_Num, String From_Adress, String Mail_Title, String Mail_Content)
	{
		BasicDBObject doc = new BasicDBObject();
		doc.put("index", index);
		doc.put("time", Send_Time);
		doc.put("num", Send_Num);
		doc.put("from_adress", From_Adress);
		doc.put("title", Mail_Title);
		doc.put("content", Mail_Content);
		return doc;
	}
	
	private static BasicDBObject MakeToPersonDocument(int index, Boolean Sending, int Check_Time, String To_Adress, String Cord)
	{
		BasicDBObject doc = new BasicDBObject();
		doc.put("index", index);
		doc.put("num", Sending);
		doc.put("to_adress", Check_Time);
		doc.put("title", To_Adress);
		doc.put("content", Cord);
		return doc;
	}
}

class Person
{
	public int Index;
	public String Name;
	public String Mail_Address;
	public String Phone;
}

class Send_Mail
{
	public long Send_Time;
	public int Send_Num;
	
	public String From_Adress;
	public String Mail_Title;
	public String Mail_Content;
	
	public ArrayList<To_Person> person;
}

class To_Person
{
	public Boolean Sending;
	
	public int Check_Time;	
	
	public String To_Adress;
	public String Cord;	
}
