package Sender;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import Protocol.SenderController.NewTaskRequest;
import Protocol.SenderController.NewTaskResponse;
import Protocol.SenderController.SenderHandler.BlockingInterface;
import Protocol.SenderController.SenderHandler.Stub;

import biz.source_code.base64Coder.Base64Coder;

import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.googlecode.protobuf.netty.NettyRpcChannel;
import com.googlecode.protobuf.netty.NettyRpcClient;

public class Sender {
	static Logger logger = Logger.getLogger(Sender.class);
	
	public static HashMap <String, DNS> DNS_Cache;
	//public static HashMap<long, Task> TaskList;
	public static Queue<Connect> Connect;
	
	public static BlockingInterface SenderHandler;
	public static RpcController controller;

	
	static ExecutorService executorService;
	
	static String[] IPList;
	static int IPCount;
	
	static String Monitoring_CPU;
	static String Monitoring_Network;
	
	public static void main(String ar[])
	{
		Sender.DNS_Cache = new HashMap<String, DNS>();
		Sender.Connect = new LinkedList<Connect>();

		//나중에 파일로 처리
		Properties properties = new Properties();
		try {
			FileInputStream properties_file;
			properties_file = new FileInputStream("sender.properties");
			properties.load(properties_file);
			properties_file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		Sender.IPList = properties.getProperty("IPList").split(",");
		Sender.IPCount = 0;

		ExecutorService executorService = Executors.newFixedThreadPool(Integer.parseInt(properties.getProperty("MAX_ThreadCount"))); //IP수 * IP당 갯수
		
		Sender.Monitoring_CPU = properties.getProperty("Monitoring_CPU");
		Sender.Monitoring_Network = properties.getProperty("Monitoring_Network");
		
		
		NettyRpcClient client =  new NettyRpcClient((ChannelFactory) new NioClientSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
		NettyRpcChannel channel = client.blockingConnect(new InetSocketAddress(properties.getProperty("Controller_Host"), Integer.parseInt(properties.getProperty("Controller_Port"))));

		Sender.SenderHandler = Protocol.SenderController.SenderHandler.newBlockingStub(channel);
		Sender.controller = channel.newRpcController();
		
		
		//모니터링 시작
		new Monitoring().start();
		
		long time=System.currentTimeMillis()+5000;
		long NewTaskTime=0;

		while(true)
		{
			if(System.currentTimeMillis()>time)
			{
				try {
					NewTaskResponse Task = Sender.SenderHandler.newTask(Sender.controller, NewTaskRequest.newBuilder().setTime(NewTaskTime).build());
					time=Task.getTime();
					String[] ObjectId = Task.getObjectId().split("\1");
					String[] From = Task.getFrom().split("\1");
					String[] Subject = Task.getSubject().split("\1");
					String[] Message = Task.getMessage().split("\1");
					
					for(int i=0; i<ObjectId.length; i++)
					{
						Task newTask = new Task(ObjectId[i], From[i], Subject[i], Message[i]);
						newTask.Load();
					}
					
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				time=System.currentTimeMillis()+5000;
				if(Sender.Connect.size()>0)
				{
					synchronized(IPList)
					{
						executorService.execute(new TaskThread(IPList[IPCount]));
						IPCount++;
						if(IPCount>=IPList.length)
							IPCount = 0;
					}
				}
			}
		}
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
				 
				 Data = line.split(" ");
				 Server server = new Server();
				 server.ranking = Integer.parseInt(Data[3]);
				 server.Host = Data[4].substring(0, Data[4].length() - 1);
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
}

