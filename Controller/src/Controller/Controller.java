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
		
		
	}
}

