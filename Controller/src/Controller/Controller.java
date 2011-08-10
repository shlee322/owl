package Controller;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
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

		final TNonblockingServerSocket socket = new TNonblockingServerSocket(9099);
		final controlApi.controlApi.Processor processor = new controlApi.controlApi.Processor(new ClientHandler());
		Controller.Client_Server = new THsHaServer(processor, socket, new TFramedTransport.Factory(), new TBinaryProtocol.Factory());
		Controller.Client_Server.serve();
		
		Controller.MonggoDB();
		
		//일단은 대충대충 만듬
	}
	
	public static void MonggoDB()
	{
		try{
			Mongo m = new Mongo("controller.owl.or.kr");

			DB db = m.getDB( "test" );

			boolean auth = db.authenticate("owl","70210".toCharArray());
			
			m.dropDatabase("test");

			Set<String> colls = db.getCollectionNames();

			for (String s : colls) {
			    System.out.println(s);
			}

			
			DBCollection coll = db.getCollection("testCollection");

			BasicDBObject doc = new BasicDBObject();

	        doc.put("name", "MongoDB");
	        doc.put("type", "database");
	        doc.put("count", 1);

	        BasicDBObject info = new BasicDBObject();

	        info.put("x", 203);
	        info.put("y", 102);

	        doc.put("info", info);

	        coll.insert(doc);
	        
	        DBObject myDoc = coll.findOne();
	        System.out.println(myDoc);

	        for (int i=0; i < 100; i++) {
	            coll.insert(new BasicDBObject().append("i", i));
	        }

	        System.out.println(coll.getCount());

	        DBCursor cur = coll.find();

	        while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }
	        
	        BasicDBObject query = new BasicDBObject();

	        query.put("name", "MongoDB");

	        cur = coll.find(query);

	        while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }
	        
	        BasicDBObject query2 = new BasicDBObject();

	        query2.put("j", new BasicDBObject("$ne", 3));
	        query2.put("k", new BasicDBObject("$gt", 10));

	        cur = coll.find(query2);

	        while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }
	        
	        query = new BasicDBObject();

	        query.put("i", new BasicDBObject("$gt", 50));  // e.g. find all where i > 50

	        cur = coll.find(query);

	        while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }


	        query = new BasicDBObject();

	        query.put("i", new BasicDBObject("$gt", 20).append("$lte", 30));  // i.e.   20 < i <= 30

	        cur = coll.find(query);

	        while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }
	        
	        coll.createIndex(new BasicDBObject("i", 1));  // create index on "i", ascending
	        
	        List<DBObject> list = coll.getIndexInfo();

	        for (DBObject o : list) {
	            System.out.println(o);
	        }

	        Mongo x = new Mongo();

	        for (String s : x.getDatabaseNames()) {
	            System.out.println(s);
	        }

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		

	}
}
