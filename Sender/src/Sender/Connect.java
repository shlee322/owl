//���� : 2011-07-15 15:00
package Sender;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;

public class Connect {
	Task Task;
	long ToIndex;
	String Mail;
	PrintWriter out = null;
    BufferedReader in = null;
    
	public Connect(Task Task, long ToIndex, String Mail)
	{
		this.Task = Task;
		this.ToIndex = ToIndex;
		this.Mail = Mail;
	}
	
	public boolean Send(String ip, int port)
	{
		int hoststart = this.Mail.indexOf("@");
		String User = this.Mail.substring(0, hoststart);
		String Host = this.Mail.substring(hoststart+1);

		DNS dns = Sender.GetDNS(Host);

		Socket socket;
		
		boolean send = false;

		for (Server server : dns.Server) {
			try {
					socket = new Socket(server.Host, 25);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
	            in = new BufferedReader(
	                                    new InputStreamReader(socket.getInputStream())
	            );

	            String Msg = in.readLine();
	  
	            
	            if(!Msg.substring(0, Msg.indexOf(" ")).equals("220"))
	            	continue;

	            if(!this.SendCmd("HELO", "250"))
	            	continue;
	            
	            if(!this.SendCmd(String.format("MAIL FROM:<%s>", this.Task.From), "250"))
	            	continue;
	            
	            if(!this.SendCmd(String.format("RCPT TO:<%s>", this.Mail), "250"))
	            	continue;

	            if(!this.SendCmd("DATA", "354"))
	            {
	            }

	            out.println(String.format("From: <%s>\nTo: <%s>\nSubject: %s\n\n%s", this.Task.From, this.Mail, this.Task.Subject, this.Task.Message));

	            if(!this.SendCmd(".", "250"))
	            {
	            
	            }
	            
	            
	            socket.close();
	            send = true;
	    		break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//try {
			//if(!send)
			//	Sender.Connect.put(this);
		//} catch (InterruptedException e) {
			//e.printStackTrace();
		//}
		
		return true;
	}
	
	boolean SendCmd(String Cmd, String S)
	{
		out.println(Cmd);
        String Msg;
		try {
			Msg = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		boolean r = Msg.substring(0, Msg.indexOf(" ")).equals(S);
		if(!r)
		{
			System.out.println(Msg);
		}
		return r;
	}
}
