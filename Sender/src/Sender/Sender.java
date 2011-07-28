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
import java.util.concurrent.SynchronousQueue;
import java.net.*;
//�붾젆�좊━ �섏젙���섎뒗媛�
public class Sender {
	public static HashMap <String, DNS> DNS_Cache;
	//public static HashMap<long, Task> TaskList;
	public static SynchronousQueue<Connect> Connect;
	public static Socket Socket;
	static OutputStream out;
	
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
		
		for(int i=0; i<50; i++) //占쏙옙占쏙옙 IP占쏙옙 占쏙옙占쏙옙占쏙옙 50(IP占쏙옙)*16占쏙옙 = 800, 占쏙옙占쏙옙 처占쏙옙占쏙옙占쏙옙占쏙옙 占썅간占쌕꿔서
			new TaskThread().start();
		
		Monitoring.Run();
		
		
		
		System.out.println("처占쏙옙 占쏙옙占쏙옙占쏙옙 占쌔븝옙 占싹뤄옙");
		
		System.out.print("占쏙옙占쏙옙:");
		System.out.println(System.currentTimeMillis());
		
		Task task = new Task(1, "test@laeradr.com", "占쌓쏙옙트","占쌓쏙옙트占쌉니댐옙.");
		try {
			for(int i=0; i<100; i++)
				Sender.Connect.put(new Connect(task, 1, "shlee322@gmail.com"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		while(true)
		{//
			try {
				Sender.Socket = new Socket("127.0.0.1", 7004);
				InputStream in = Sender.Socket.getInputStream();
				Sender.out = Sender.Socket.getOutputStream();
				
				byte []buffer = new byte[1024];
				String string_buffer="";
				int len;
				
				out.write("Prove\1abcdefg\1test\0".getBytes());
				
				while(true)
				{
					len = in.read(buffer);
					String string = new String(buffer, 0, len);//占쏙옙占쏙옙 占쌓놂옙 占쏙옙占쌜몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙.
					string = string_buffer + string;
					String[] Packet = string.split("\0");
					
					int count = Packet.length;
					if(buffer[len-1]!=0)
					{
						count -= 1;
						string_buffer += Packet[count];
					}
					
					for(int i=0; i<count; i++)
						Processing(Packet[i]);
				}
				in.close();
				Sender.Socket.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
		
		
		
		
		
		
		
		/*
		class BThread extends Thread
		{
		    public void run()
		    {
				//占쌓쏙옙트
				Task task = new Task(1, "test@laeradr.com", "占쌓쏙옙트","占쌓쏙옙트占쌉니댐옙.");

		    	for(int i=0; i<20; i++)
		    	{
		    		//try {
			    		try {
							//Sender.Connect.put(new Connect(task, 1, "poweroyh@naver.com"));
							//Sender.Connect.put(new Connect(task, 1, "sungeun1990@naver.com"));
							Sender.Connect.put(new Connect(task, 1, "shlee940322@naver.com"));
							//Sender.Connect.put(new Connect(task, 1, "joseph4u@naver.com"));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		
		    			//Thread.sleep(0);
		    		//} catch (InterruptedException e) {
		    			// TODO Auto-generated catch block
		    		//	e.printStackTrace();
		    		//}
		    	}
		    }
		}
		
		new BThread().start();
		
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
    	
    	
    	
//*/
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

