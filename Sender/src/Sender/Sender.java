package Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.net.*;

import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import Protocol.SenderController.SenderHandler.Interface;
import Protocol.SenderController.SenderHandler.Stub;

import com.googlecode.protobuf.netty.*;
//�붾젆�좊━ �섏젙���섎뒗媛�
public class Sender {
	public static HashMap <String, DNS> DNS_Cache;
	//public static HashMap<long, Task> TaskList;
	public static SynchronousQueue<Connect> Connect;
	
	private static NettyRpcClient client;
	
	public static void main(String ar[])
	{
		Sender.DNS_Cache = new HashMap<String, DNS>();
		//Sender.DNS_Cache.
		Sender.Connect = new SynchronousQueue<Connect>();
		
		class TaskThread extends Thread
		{
		    public void run()
		    {
		    	Connect c = null;
		    	while(true)
		    	{
		    		c = Sender.Connect.poll();
		    		if(c!=null)
		    			c.Send();
		    		
		    		try {
		    			Thread.sleep(0);
		    		} catch (InterruptedException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}
		    	}
		    }
		}
		
		Sender.client =  new NettyRpcClient((ChannelFactory) new NioClientSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
		NettyRpcChannel channel = client.blockingConnect(new InetSocketAddress("localhost", 7004));
		
		Stub calcService = Protocol.SenderController.SenderHandler.newStub(channel);
		Protocol.SenderController.SenderHandler.Interface blockingService = (Interface) Protocol.SenderController.SenderHandler.newBlockingStub(channel);
		
		for(int i=0; i<50; i++) //占쏙옙占쏙옙 IP占쏙옙 占쏙옙占쏙옙占쏙옙 50(IP占쏙옙)*16占쏙옙 = 800, 占쏙옙占쏙옙 처占쏙옙占쏙옙占쏙옙占쏙옙 占썅간占쌕꿔서
			new TaskThread().start();
		
		Monitoring.Run();

		/*
		
		Task task = new Task(1, "test@laeradr.com", "대용량 메일 전송 테스트입니다.","본 이메일의 수신을 원지 않으시면 돈좀...");
		try {
			for(int i=0; i<10000; i++)
			{
				Sender.Connect.put(new Connect(task, 1, "poweroyh@naver.com"));
				Sender.Connect.put(new Connect(task, 2, "jaugr@jagur.kr"));
				Sender.Connect.put(new Connect(task, 3, "xoul@joyfl.kr"));
				Sender.Connect.put(new Connect(task, 4, "pd@viewide.kr"));
				Sender.Connect.put(new Connect(task, 5, "jhoney510@gmail.com"));
				Sender.Connect.put(new Connect(task, 6, "toori67@gmail.com"));
				Sender.Connect.put(new Connect(task, 7, "junzang01@naver.com"));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	public static DNS GetDNS(String Host)
	{
		DNS dns = Sender.DNS_Cache.get(Host);
		if(dns != null)
			return dns;
		dns = new DNS();
		
		Process p = null;
		List<Server> MailServer = new ArrayList();

		try {
			p = Runtime.getRuntime().exec(String.format("nslookup -q=mx %s", Host));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		String []Data;

		 try {
			int host_len = Host.length();
			while ((line = reader.readLine()) != null) {
				 if(line.length() < host_len || !line.substring(0, host_len).equals(Host))
					 continue;
				 
				 Data = line.split(" "); //Data[3] : 占쎌선占쏙옙占쏙옙, Data[7] : 占쏙옙占싹쇽옙占쏙옙
				 Server server = new Server();
				 server.ranking = Integer.parseInt(Data[3].substring(0, Data[3].length()-1));
				 server.Host = Data[7];
				 MailServer.add(server);
				 
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 Comparator<Server> comparator = new Comparator<Server>() {
			 @Override
			 public int compare(Server o1, Server o2){
				 return (o1.ranking < o2.ranking ? 0 : 1);
			 }
		};
		
		Collections.sort(MailServer, comparator);
		
		dns.Server = new Server[0];
		dns.Server = (Server[])MailServer.toArray(dns.Server);
		
		Sender.DNS_Cache.put(Host, dns);
		
		return dns;
	}
	
	static void Processing(String Packet)
	{
		String []Data = Packet.split("\1");
		//String Type = Packet.substring(0, Packet.indexOf("\1"));
		if(Data[0].equals("Task"))
		{//Index, From, Subject, Message
			Task task = new Task(Long.valueOf(Data[1]),Data[2],Data[3],Data[4]);
			task.Load();
		}else if(Data[0].equals("To"))
		{//Index, ToIndex, To
			
		}
	}
}

