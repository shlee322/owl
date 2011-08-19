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
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.googlecode.protobuf.netty.*;

public class Controller {
	static NettyRpcServer Sender_Server;
	static TServer Client_Server;
	public static void main(String ar[]) throws TTransportException
	{
		/*
		Controller.Sender_Server = new NettyRpcServer(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
		
		Controller.Sender_Server.registerService(Protocol.SenderController.SenderHandler.newReflectiveService(new SenderHandler()));
		Controller.Sender_Server.serve(new InetSocketAddress(7004));
		
		ServerBootstrap webbootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool()));
				  
		// Set up the event pipeline factory.
		webbootstrap.setPipelineFactory(new HttpServerPipelineFactory());
		  
		// Bind and start to accept incoming connections.
		webbootstrap.bind(new InetSocketAddress(8080));
		
		

		
		final TNonblockingServerSocket socket = new TNonblockingServerSocket(9099);
		final controlApi.controlApi.Processor processor = new controlApi.controlApi.Processor(new ClientHandler());
		Controller.Client_Server = new THsHaServer(processor, socket, new TFramedTransport.Factory(), new TBinaryProtocol.Factory());
		Controller.Client_Server.serve();
		*/
		//�단� �충��만듬
		/*
		MongoDB MongoDB = new MongoDB();
		MongoDB.DBStart("poweroyh");
		MongoDB.Del_User("poweroyh");
		
		MongoDB.Add_Group("SWmaestro");
		MongoDB.Add_Person("SWmaestro", "�유, "poweroyh@naver.com", "010-2563-7816");
		MongoDB.Add_Person("SWmaestro", "�성�, "poweroyh@naver.com", "010-1111-2222");
		MongoDB.Add_Person("SWmaestro", "�상, "poweroyh@naver.com", "010-3333-4444");
		MongoDB.Add_Person("SWmaestro", "�성�", "�ㅁ�ㅇ�ㄴnaver.c.om", "010-2563-7816");
		MongoDB.Add_Person("SWmaestro", "�수, "poweroyh@naver.com", "1111-2222-7816");
		MongoDB.Add_Person("SWmaestro", "김종헌", "poweroyh@naver.com", "010-2563-3333");
	//	MongoDB.printResults();
		MongoDB.Add_Group("SWmaestro");
		ArrayList<Person> PersonList = new ArrayList<Person>();
		PersonList = MongoDB.Load_Group("SWmaestro");
		
		for (Person person : PersonList) {
			System.out.println(person.Mail_Address);
			
		}*/
		ArrayList<Person> as = new ArrayList<Person>();
		Person a = PersonList.get(1);
		a.Mail_Address = "fuckyou!!!";
		as.add(a);
		MongoDB.Update_User("SWmaestro", as);
		
		for (Person person : PersonList) {
			System.out.println(person.Mail_Address);
			
		}
	}
}

