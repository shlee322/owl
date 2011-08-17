package Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import Protocol.SenderController.NewTaskRequest;
import Protocol.SenderController.NewTaskResponse;
import Protocol.SenderController.SenderHandler.BlockingInterface;
import Protocol.SenderController.SenderHandler.Stub;

import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.googlecode.protobuf.netty.NettyRpcChannel;
import com.googlecode.protobuf.netty.NettyRpcClient;

public class Sender {
	public static HashMap <String, DNS> DNS_Cache;
	//public static HashMap<long, Task> TaskList;
	public static Queue<Connect> Connect;
	
	private static NettyRpcClient client;
	
	static ExecutorService executorService;
	
	public static void main(String ar[])
	{
		Sender.DNS_Cache = new HashMap<String, DNS>();
		//Sender.DNS_Cache.
		Sender.Connect = new LinkedList<Connect>();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2950);

		class TaskThread extends Thread
		{
			String ip;

			public TaskThread(String ip)
			{
				this.ip = ip;
			}
			
		    public void run()
		    {
		    	Connect c = null;
		    	long time=System.currentTimeMillis();
		    	
		    	while(true)
		    	{
		    		synchronized(Sender.Connect)
		    		{
		    			c = Sender.Connect.poll();
		    		}
		    		
		    		if(c!=null)
		    		{
		    			c.Send(ip);
		    			time = System.currentTimeMillis();
		    		}
		    		else
		    		{
		    			if(System.currentTimeMillis()>time+5000)
		    			{
		    				//스래드가 5초이상 놀고있구먼.
		    				/*
		    				try {
								this.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/
		    				return;
		    			}
		    		}
		    		
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
		NettyRpcChannel channel = client.blockingConnect(new InetSocketAddress("controller.owl.or.kr", 7004));

		BlockingInterface blockingCalcService = Protocol.SenderController.SenderHandler.newBlockingStub(channel);
		RpcController controller = channel.newRpcController();
/*
		
		Task task = new Task(1, "test@owl.or.kr", "대용량 메일 전송 테스트입니다.","히히");
		
		for(int i=0; i<10000000; i++)
		{
			Sender.Connect.offer(new Connect(task, 1, "jagur@jagur.kr"));
    		//Sender.Connect.offer(new Connect(task, 1, "shlee940322@naver.com"));
    		//Sender.Connect.offer(new Connect(task, 2, "poweroyh@naver.com"));
			Sender.Connect.offer(new Connect(task, 3, "poweroyh@gmail.com"));
		}
		*/
		
		long time=System.currentTimeMillis()+5000;
		
		long test = 0;

		while(true)
		{
			Monitoring.Run();
			if(System.currentTimeMillis()>time)
			{				
				try {
					blockingCalcService.newTask(controller, NewTaskRequest.newBuilder().setTime(test).build());
					test = System.currentTimeMillis();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				time=System.currentTimeMillis()+5000;
				if(Sender.Connect.size()>0)
				{
					for(int i=67; i<=126; i++)
					{
							executorService.execute(new TaskThread(String.format("183.111.9.%d", i)));//.start();
					}
				}
			}
		}
		
		/*
		
		Task task = new Task(1, "test@owl.or.kr", "대용량 메일 전송 테스트입니다.","히히");
		
		try {
			//for(int i=0; i<100; i++)
			//{
				Sender.Connect.put(new Connect(task, 1, "shlee940322@naver.com"));
				Sender.Connect.put(new Connect(task, 2, "poweroyh@naver.com"));
				Sender.Connect.put(new Connect(task, 3, "poweroyh@gmail.com"));

				/*
				
				Sender.Connect.put(new Connect(task, 2, "jaugr@jagur.kr"));
				Sender.Connect.put(new Connect(task, 3, "xoul@joyfl.kr"));
				Sender.Connect.put(new Connect(task, 4, "pd@viewide.kr"));
				Sender.Connect.put(new Connect(task, 5, "jhoney510@gmail.com"));
				Sender.Connect.put(new Connect(task, 6, "toori67@gmail.com"));
				Sender.Connect.put(new Connect(task, 7, "junzang01@naver.com"));*/
			//}
		/*
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
		
		try {
			p.waitFor();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		String []Data;

		 try {
			int host_len = Host.length();
			while ((line = reader.readLine()) != null) {
				 if(line.length() < host_len || !line.substring(0, host_len).equals(Host))
					 continue;
				 if(line.indexOf("mail") == -1)
					 continue;
				 
				 Data = line.split(" "); //Data[3] : 占쎌선占쏙옙占쏙옙, Data[7] : 占쏙옙占싹쇽옙占쏙옙
				 Server server = new Server();
				 server.ranking = Integer.parseInt(Data[3].substring(0, Data[3].length()-1));
				 server.Host = Data[4].substring(0, Data[4].length() - 1);
				 //System.out.println(server.ranking + " " + server.Host);
				 MailServer.add(server);
			 }
			reader.close();
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

