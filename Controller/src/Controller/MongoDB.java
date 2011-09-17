package Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDB {
	static Mongo m;

	DB AdressDB;
	DB SendMailDB;
	DB UserDB;

	String UserName;
	String SendDBName;
	String GroupName;
	String SendMailList;

	DBCollection GroupColl;
	DBCollection SendMailColl;
	DBCollection UserColl;

	public MongoDB()
	{
		this.DBStart();
	}
	
	boolean DBStart()
	{
		try {
			m = new Mongo(Controller.MongoDB_IP);
			SendDBName = "SendMail";
			SendMailDB = m.getDB(SendDBName);
			SendMailDB.authenticate("owl", "70210".toCharArray());
			
			UserDB = m.getDB("User");
			UserDB.authenticate("owl", "70210".toCharArray());
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	// 디비 시작 (클라에서 로그온 했을때 무조건 이 메소드는 실행 해야함!)
	boolean LogIn(String User) {
		try {
			UserName = User;
			AdressDB = m.getDB(UserName);
			AdressDB.authenticate("owl", "70210".toCharArray());

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	boolean SenderDBStart() {
		try {
			m = new Mongo(Controller.MongoDB_IP);

			SendDBName = "SendMail";
			SendMailDB = m.getDB(SendDBName);
			SendMailDB.authenticate("owl", "70210".toCharArray());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	Boolean Add_User(String Id, String Pw)
	{
		try
		{
			UserColl = UserDB.getCollection("User");
			UserColl.insert(MakeUserDocument(Id, Pw));
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	ArrayList<User> Load_UserList()
	{
		ArrayList<User> User_List = new ArrayList<User>();
		UserColl = UserDB.getCollection("User");

		if (UserColl.getCount() != 0) {
			DBCursor cur;

			cur = UserColl.find();

			while (cur.hasNext()) {
				User U_Temp = new User();

				U_Temp.ID = cur.next().get("id").toString();
				U_Temp.PW = cur.curr().get("password").toString();
				U_Temp.Key = null;

				User_List.add(U_Temp);
			}
		}		
		return User_List;
	}
	
	boolean Update_User(String Id, String NewPw)
	{
		try
		{
			UserColl = UserDB.getCollection("User");
			BasicDBObject doc;
			doc = MakeUserDocument(Id,NewPw);
			UserColl.update(new BasicDBObject().append("id", Id), doc);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	Boolean Del_User(String Id, String Pw) {
		try
		{
			m.dropDatabase(Id);
			UserColl = UserDB.getCollection("User");
			BasicDBObject doc;
			doc = MakeUserDocument(Id,Pw);
			UserColl.remove(doc);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	// 그룹 추가
	boolean Add_Group(String G_Name) {
		try {
			GroupName = G_Name;

			Set<String> colls = AdressDB.getCollectionNames();

			if (!colls.isEmpty()) {
				if (AdressDB.collectionExists(GroupName)) {
					//같은 그룹명 있을시 펄스
					return false;
				} else {
					GroupColl = AdressDB.createCollection(GroupName, null);
					return true;
				}
			} else {
				GroupColl = AdressDB.createCollection(GroupName, null);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// 사람 추가
	Boolean Add_Person(String G_Name, String P_Name, String Mail_Address, String Phone) {
		try
		{
			GroupColl = AdressDB.getCollection(G_Name);
			GroupColl.insert(MakePersonDocument(P_Name, Mail_Address, Phone));

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// 그룹 리스트 로드
	Set<String> Load_Group() {
		Set<String> ad = AdressDB.getCollectionNames();
		
		for (String string : ad) {
			System.out.println(string);
		}
		
		return ad;
	}

	ArrayList<Person> Load_GroupList(String G_Name) {
		ArrayList<Person> PersonList = new ArrayList<Person>();

		GroupColl = AdressDB.getCollection(G_Name);

		if (GroupColl.getCount() != 0) {
			DBCursor cur;

			cur = GroupColl.find();

			while (cur.hasNext()) {
				Person P_Temp = new Person();

				P_Temp.ObjectID = cur.next().get("_id").toString();
				P_Temp.Name = cur.curr().get("name").toString();
				P_Temp.Mail_Address = cur.curr().get("mail").toString();
				P_Temp.Phone = cur.curr().get("phone").toString();

				PersonList.add(P_Temp);
			}
		} else {
			System.out.println("그룹에 사람 없음");
		}
		return PersonList;
	}

	//그룹
	Boolean Update_Group(String GroupName, String Re_GroupName)
	{
		try
		{
			GroupColl = AdressDB.getCollection(GroupName);
			GroupColl.rename(Re_GroupName);
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//그룹멤버
	Boolean Update_Person(String GroupName, ArrayList<Person> P1)
	{
		try
		{
			GroupColl = AdressDB.getCollection(GroupName);
			
			for (Person person : P1)
			{
				BasicDBObject doc;
				doc = MakePersonDocument(person.Name, person.Mail_Address, person.Phone);
				GroupColl.update(new BasicDBObject().append("_id", person.ObjectID), doc);
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	Boolean Del_Group(String G_Name)
	{
		try
		{
			GroupColl = AdressDB.getCollection(G_Name);
			GroupColl.drop();
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	// 메일 내용부분 추가
	Boolean Add_Mail_Content(Boolean Sending, long Send_Time, int Send_Num, String From_Adress, String Mail_Title, String Mail_Content, String UserName)
	{
		try
		{
			SendMailColl = SendMailDB.getCollection("Mail_Content");

			SendMailColl.insert(MakeSendMailDocument(Sending, Send_Time, Send_Num, From_Adress, Mail_Title, Mail_Content, UserName));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 받는 사람 정보 추가
	Boolean Add_To_Person(long Send_Time, String To_Adress, String Group_Name)
	{
		try
		{
			Boolean Sending = false;
			long Check_Time = 0;
			String Cord = null;
			int Key = (int) (Math.random()*1000000000);		
			String String_Send_Time = Long.toString(Send_Time);
			SendMailColl = SendMailDB.getCollection(String_Send_Time);

			SendMailColl.insert(MakeToPersonDocument(Sending, Check_Time, To_Adress, Cord, Group_Name, Key));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 0이 이하 1이 이상 두개다 날짜면 사이
	ArrayList<Send_Mail> Load_Mail_List(long day, long checkday)
	{
		DBCursor cur;
		SendMailColl = SendMailDB.getCollection("Mail_Content");

		System.out.println(SendMailColl.getCount());
		// 이하
		// cur = SendMailColl.find(new BasicDBObject().append("id", new
		// BasicDBObject((checkday == 0 ? "$lte" : "$gte"), day)));// <= 상혁이꺼
		if (checkday == 0) {
			cur = SendMailColl.find(new BasicDBObject().append("time", new BasicDBObject("$lte", day)));// <=
			return Add_Mail_List(cur);
		}
		// 이상
		else if (checkday == 1) {
			cur = SendMailColl.find(new BasicDBObject().append("time", new BasicDBObject("$gte", day)));// >=
			return Add_Mail_List(cur);
		}
		// 사이값
		else {
			BasicDBObject query = new BasicDBObject();
			query.append("time", new BasicDBObject("$gte", day));
			query.append("time", new BasicDBObject("$lte", checkday));
			cur = SendMailColl.find(query);
			return Add_Mail_List(cur);
		}
	}

	ArrayList<Send_Mail> Add_Mail_List(DBCursor cur)
	{
		ArrayList<Send_Mail> Mail = new ArrayList<Send_Mail>();
		
		while (cur.hasNext()) {
			Send_Mail Mail_Temp = new Send_Mail();
			
			Mail_Temp.From_Adress = cur.next().get("from_adress").toString();
			Mail_Temp.Mail_Content = cur.curr().get("content").toString();
			Mail_Temp.Mail_Title = cur.curr().get("title").toString();
			Mail_Temp.Send_Num = Integer.parseInt(cur.curr().get("num").toString());
			Mail_Temp.Send_Time = Long.parseLong(cur.curr().get("time").toString());
			Mail_Temp.UserName = cur.curr().get("username").toString();
			Mail.add(Mail_Temp);
		}
		return Mail;
	}
	

	ArrayList<To_Sender_Person> Load_Sender_Person(Long Time, int num)
	{
		ArrayList<To_Sender_Person> Sender_Person_List = new ArrayList<To_Sender_Person>();
		DBCursor Personcur;

		SendMailColl = SendMailDB.getCollection(Time.toString());
		
		Personcur = SendMailColl.find(new BasicDBObject("sending", false));
		if(Personcur.count() != 0)
		{
			for(int i=0;i<num;i++)
			{
				if(!Personcur.hasNext())
					break;
				To_Sender_Person Temp_Person = new To_Sender_Person();
				Temp_Person.ObjectID = Personcur.next().get("_id").toString();
				Temp_Person.To_Adress = Personcur.curr().get("toaddress").toString();
				Temp_Person.Key = Integer.parseInt(Personcur.curr().get("key").toString());
				Sender_Person_List.add(Temp_Person);
			}
		}
		
		Boolean True;
		True = true;
		for (To_Sender_Person person : Sender_Person_List) {
			BasicDBObject newDocument3 = new BasicDBObject().append("$set", new BasicDBObject().append("sending", True));
			ObjectId id = new ObjectId(person.ObjectID);
			SendMailColl.update(new BasicDBObject().append("_id", id), newDocument3);
		}
		return Sender_Person_List;
	}
	
	ArrayList<To_Person> Load_Client_person(Long Time)
	{
		ArrayList<To_Person> Client_Person_List = new ArrayList<To_Person>();
		DBCursor Personcur;

		SendMailColl = SendMailDB.getCollection(Time.toString());
		
		Personcur = SendMailColl.find();

		while (Personcur.hasNext()) {
			To_Person P_Temp = new To_Person();
			P_Temp.ObjectID = Personcur.next().get("_id").toString();
			P_Temp.Sending = Boolean.valueOf(Personcur.curr().get("sending").toString());
			P_Temp.Check_Time = Long.parseLong(Personcur.curr().get("checktime").toString());
			P_Temp.To_Adress = Personcur.curr().get("toaddress").toString();
			P_Temp.Cord = Personcur.curr().get("cord").toString();
			P_Temp.Group_Name = Personcur.curr().get("group_name").toString();
			P_Temp.Key = Integer.parseInt(Personcur.curr().get("key").toString());
	
			Client_Person_List.add(P_Temp);
		}
		return Client_Person_List;
	}
	
	Boolean Update_MailList(Send_Mail send)
	{
		try
		{
			SendMailColl = AdressDB.getCollection("Mail_Content");
			BasicDBObject doc;
			doc = MakeSendMailDocument(send.Sending, send.Send_Time, send.Send_Num, send.From_Adress, send.Mail_Title, send.Mail_Content, send.UserName);
			SendMailColl.update(new BasicDBObject().append("time", send.Send_Time), doc);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	Boolean Update_MailList_User(ArrayList<To_Person> person, String SendTime)
	{
		try
		{
			SendMailColl = SendMailDB.getCollection(SendTime);
			BasicDBObject doc;
			
			for (To_Person Person : person) {
				doc = MakeToPersonDocument(Person.Sending, Person.Check_Time, Person.To_Adress, Person.Cord, Person.Group_Name, Person.Key);
				ObjectId id = new ObjectId(Person.ObjectID);
				SendMailColl.update(new BasicDBObject().append("_id", id), doc);
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	Boolean Del_MailList(String Time)
	{
		try
		{
			SendMailColl = SendMailDB.getCollection("Mail_Content");
			SendMailColl.remove(new BasicDBObject().append("time", Time));
			SendMailColl = SendMailDB.getCollection(Time);
			SendMailColl.drop();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	Boolean Update_Cord(long Send_Time, String ObjectID, String Cord)
	{
		try
		{
			SendMailColl = SendMailDB.getCollection(Long.toString(Send_Time));
			ObjectId id = new ObjectId(ObjectID);

			BasicDBObject newDocument3 = new BasicDBObject().append("$set", new BasicDBObject().append("cord", Cord));
			SendMailColl.update(new BasicDBObject().append("_id", id), newDocument3);
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	Boolean Update_CheckTime(long Send_Time, String ObjectID, int key)
	{
		try
		{
			long Check_Time;
			Check_Time = System.currentTimeMillis();
			
			SendMailColl = SendMailDB.getCollection(Long.toString(Send_Time));
			ObjectId id = new ObjectId(ObjectID);

			BasicDBObject newDocument3 = new BasicDBObject().append("$set", new BasicDBObject().append("checktime", Check_Time));
			SendMailColl.update(new BasicDBObject().append("_id", id).append("key", key), newDocument3);
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	void printResults() {
		DBCursor cur;

		cur = GroupColl.find();

		while (cur.hasNext()) {
			System.out.println(cur.next().get("index") + ","
					+ cur.curr().get("name") + "," + cur.curr().get("mail")
					+ "," + cur.curr().get("phone"));
		}
	}

	private static BasicDBObject MakeUserDocument(String Id, String Pw) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("id", Id);
		doc.put("password", Pw);
		return doc;
	}

	private static BasicDBObject MakePersonDocument(String P_Name, String Mail_Address, String Phone) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("name", P_Name);
		doc.put("mail", Mail_Address);
		doc.put("phone", Phone);
		return doc;
	}

	private static BasicDBObject MakeSendMailDocument(Boolean Sending, long Send_Time, int Send_Num, String From_Adress, String Mail_Title, String Mail_Content, String UserName) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("sending", Sending);
		doc.put("time", Send_Time);
		doc.put("num", Send_Num);
		doc.put("from_adress", From_Adress);
		doc.put("title", Mail_Title);
		doc.put("content", Mail_Content);
		doc.put("username", UserName);
		return doc;
	}

	private static BasicDBObject MakeToPersonDocument(Boolean Sending, long Check_Time, String To_Adress, String Cord, String Group_Name, int Key) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("sending", Sending);
		doc.put("checktime", Check_Time);
		doc.put("toaddress", To_Adress);
		doc.put("cord", Cord);
		doc.put("group_name", Group_Name);
		doc.put("key", Key);
		return doc;
	}
}

class Person {
	public String ObjectID;
	public String Name;
	public String Mail_Address;
	public String Phone;
}

class Send_Mail {
	public Boolean Sending;
	
	public String ObjectID;
	public long Send_Time;
	public int Send_Num;

	public String From_Adress;
	public String Mail_Title;
	public String Mail_Content;
	public String UserName;

	public ArrayList<To_Person> person = new ArrayList<To_Person>();
}

class To_Person {
	public String ObjectID;
	public Boolean Sending;

	public long Check_Time;

	public String To_Adress;
	public String Cord;
	public String Group_Name;
	public int Key;
}

class To_Sender_Person
{
	public String ObjectID;
	public int Key;
	public String To_Adress;
}

class User {
	String ID;
	String PW;
	String Key;
}
