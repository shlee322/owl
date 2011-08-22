//���� : 2011-07-15 15:00
package Sender;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;

import org.apache.log4j.Logger;

import com.google.protobuf.ServiceException;

import Protocol.SenderController.MailStatusRequest;
import biz.source_code.base64Coder.Base64Coder;

public class Connect {
	static Logger logger = Logger.getLogger(Connect.class);
	
	Task Task;
	String ObjectId;
	String Key;
	String Mail;
	PrintWriter out = null;
    BufferedReader in = null;
    String Msg="";
    String IP;
    
	public Connect(Task Task, String ObjectId, String Key, String Mail)
	{
		this.Task = Task;
		this.ObjectId = ObjectId;
		this.Key = Key;
		this.Mail = Mail;
	}
	
	public boolean Send(String ip)
	{
		this.IP = ip;
		long ProcessTime=System.currentTimeMillis();
		
		try{
			int hoststart = this.Mail.indexOf("@");
			String User = this.Mail.substring(0, hoststart);
			String Host = this.Mail.substring(hoststart+1);

			DNS dns = Sender.GetDNS(Host);
	
			Socket socket;
			
			boolean send = false;
	
			for (Server server : dns.Server) {
				try {
					socket = new Socket(server.getHost(), 25, InetAddress.getByName(ip), 0);
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
		            //IO에러는 다음 서버에 접속시도를 하고 SMTP서버쪽에서 에러를 던져주면 예외를 발생시킨다.

		            if(!Msg.substring(0, 3).equals("220"))
		            	throw new Exception(Msg);
	
		            if(!this.SendCmd("EHLO owl.or.kr", "250"))
		            	continue;
		            
		            if(!this.SendCmd(String.format("MAIL FROM:<%s>", this.Task.From), "250"))
		            	continue;
		            
		            if(!this.SendCmd(String.format("RCPT TO:<%s>", this.Mail), "250"))
		            	continue;
	
		            if(!this.SendCmd("DATA", "354"))
		            	continue;

		            out.println(String.format("From: <%s>\nTo: <%s>\nSubject: =?UTF-8?B?%s?=\nMIME-Version: 1.0\nContent-Type: text/html; charset=UTF-8\nContent-Transfer-Encoding: base64\n\n%s", this.Task.From, this.Mail, Base64Coder.encodeString(this.Task.Subject), Base64Coder.encodeString(this.Task.Message + String.format("<img src=\"http://www.owl.or.kr:8080/tracker.php?time=%d&objectid=%s&key=%s\" width=\"0\" height=\"0\">",this.Task.Time,this.ObjectId,this.Key))));
	
		            if(!this.SendCmd("\n.", "250"))
		            	continue;
		            out.println("quit");
		            socket.close();
		            send = true;

		            Monitoring.sendcount++;
		    		break;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(!send)
				throw new Exception("서버 접근 실패");
		}catch (Exception e)
		{
		}
		try {
			Sender.SenderHandler.mailStatus(Sender.controller, MailStatusRequest.newBuilder().setTime(this.Task.Time).setSenderIndex(Sender.SenderIndex).setSenderKey(Sender.SenderKey).setObjectId(ObjectId).setCode(Msg).setProcessTime(System.currentTimeMillis() - ProcessTime).build());
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	
	boolean SendCmd(String Cmd, String S) throws Exception
	{
		out.println(Cmd);
		this.Msg = this.Msg + "\n" + this.IP + " > " + Cmd;
        String Msg="";
		try {
			while(true)
			{
				Msg = in.readLine();
				this.Msg = this.Msg + "\n" + this.IP + " > " + Msg;

				if(!Msg.substring(0, 3).equals(S))
					throw new Exception(Msg);

				if(!Msg.substring(3, 4).equals("-"))
					break;
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
