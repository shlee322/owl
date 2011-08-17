package Controller;

import java.util.ArrayList;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDB {
	static Mongo m;

	static DB AdressDB;
	static DB SendMailDB;

	static String UserName;
	static String SendDBName;
	static String GroupName;
	static String SendMailList;

	DBCollection GroupColl;
	DBCollection SendMailColl;

	void Del_User(String User) {
		UserName = User;
		m.dropDatabase(UserName);
		m.dropDatabase(UserName + "_SendMail");
	}

	// 디비 시작 (클라에서 로그온 했을때 무조건 이 메소드는 실행 해야함!)
	boolean DBStart(String User) {
		try {
			m = new Mongo("controller.owl.or.kr");

			UserName = User;
			AdressDB = m.getDB(UserName);
			AdressDB.authenticate("owl", "70210".toCharArray());

			SendDBName = User + "_SendMail";
			SendMailDB = m.getDB(SendDBName);
			SendMailDB.authenticate("owl", "70210".toCharArray());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 그룹 추가
	boolean Add_Group(String G_Name) {
		try {
			GroupName = UserName + "_" + G_Name;

			Set<String> colls = AdressDB.getCollectionNames();

			if (!colls.isEmpty()) {
				if (AdressDB.collectionExists(GroupName)) {
					System.out.println("같은 그룹명 있음");
					return true;
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

	// 그룹 리스트 로드
	ArrayList<Person> Load_Group(String G_Name) {
		ArrayList<Person> PersonList = new ArrayList<Person>();
		GroupName = UserName + "_" + G_Name;

		GroupColl = AdressDB.getCollection(GroupName);

		if (GroupColl.getCount() != 0) {
			DBCursor cur;

			cur = GroupColl.find();

			while (cur.hasNext()) {
				Person P_Temp = new Person();

				P_Temp.Index = Integer.parseInt(cur.next().get("index")
						.toString());
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

	// 사람 추가
	Boolean Add_Person(String G_Name, String P_Name, String Mail_Address,
			String Phone) {
		try {
			GroupName = UserName + "_" + G_Name;
			GroupColl = AdressDB.getCollection(GroupName);
			int num = (int) GroupColl.getCount();
			GroupColl.insert(MakePersonDocument(num + 1, P_Name, Mail_Address,
					Phone));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 메일 내용부분 추가
	Boolean Add_Mail_Content(long Send_Time, int Send_Num, String From_Adress, String Mail_Title, String Mail_Content)
	{
		try
		{
			SendMailColl = AdressDB.getCollection("Mail_Content");

			GroupColl.insert(MakeSendMailDocument(1, Send_Time, Send_Num,
					From_Adress, Mail_Title, Mail_Content));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 받는 사람 정보 추가
	Boolean Add_To_Person(long Send_Time, Boolean Sending, int Check_Time, String To_Adress, String Cord, String Group_Name, String Key)
	{
		try
		{
			String String_Send_Time = Long.toString(Send_Time);
			SendMailColl = AdressDB.getCollection(String_Send_Time);

			int index = (int) SendMailColl.getCount();

			GroupColl.insert(MakeToPersonDocument(index, Sending, Check_Time, To_Adress, Cord, Group_Name, Key));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 0이 이하 1이 이상 두개다 날짜면 사이
	void Load_Mail_List(long day, long checkday)
	{
		DBCursor cur;
		SendMailColl = AdressDB.getCollection("Mail_Content");

		// 이하
		// cur = SendMailColl.find(new BasicDBObject().append("id", new
		// BasicDBObject((checkday == 0 ? "$lte" : "$gte"), day)));// <= 상혁이꺼
		if (checkday == 0) {
			cur = SendMailColl.find(new BasicDBObject().append("time", new BasicDBObject("$lte", day)));// <=
			Add_Mail_List(cur);
		}
		// 이상
		else if (checkday == 1) {
			cur = SendMailColl.find(new BasicDBObject().append("time", new BasicDBObject("$gte", day)));// >=
			Add_Mail_List(cur);
		}
		// 사이값
		else {
			cur = SendMailColl.find(new BasicDBObject().append("time", new BasicDBObject("$gte", day)).append("time", new BasicDBObject("$lte", checkday)));
			Add_Mail_List(cur);
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
			
			DBCursor Personcur;

			SendMailColl = AdressDB.getCollection(Long.toString(Mail_Temp.Send_Time));
			Personcur = GroupColl.find();

			while (Personcur.hasNext()) {
				To_Person Temp_Person = new To_Person();
				Temp_Person.index = Integer.parseInt(cur.next().get("index").toString());
				Temp_Person.Check_Time = Long.parseLong(cur.curr().get("checktime").toString());
				Temp_Person.Cord = cur.curr().get("cord").toString();
				Temp_Person.Sending = Boolean.valueOf(cur.curr().get("sending").toString());
				Temp_Person.To_Adress = cur.curr().get("toaddress").toString();
				Temp_Person.Group_Name = cur.curr().get("group_name").toString();
				Temp_Person.Key = cur.curr().get("key").toString();
				Mail_Temp.person.add(Temp_Person);
			}
		}
		return Mail;
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

	private static BasicDBObject MakePersonDocument(int index, String P_Name,
			String Mail_Address, String Phone) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("index", index);
		doc.put("name", P_Name);
		doc.put("mail", Mail_Address);
		doc.put("phone", Phone);
		return doc;
	}

	private static BasicDBObject MakeSendMailDocument(int index,
			long Send_Time, int Send_Num, String From_Adress,
			String Mail_Title, String Mail_Content) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("index", index);
		doc.put("time", Send_Time);
		doc.put("num", Send_Num);
		doc.put("from_adress", From_Adress);
		doc.put("title", Mail_Title);
		doc.put("content", Mail_Content);
		return doc;
	}

	private static BasicDBObject MakeToPersonDocument(int index,
			Boolean Sending, int Check_Time, String To_Adress, String Cord, String Group_Name, String Key) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("index", index);
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
	public int Index;
	public String Name;
	public String Mail_Address;
	public String Phone;
}

class Send_Mail {
	public long Send_Time;
	public int Send_Num;

	public String From_Adress;
	public String Mail_Title;
	public String Mail_Content;

	public ArrayList<To_Person> person;
}

class To_Person {
	int index;
	public Boolean Sending;

	public long Check_Time;

	public String To_Adress;
	public String Cord;
	public String Group_Name;
	public String Key;
}
