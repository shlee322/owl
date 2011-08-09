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
	
	public boolean Send(String ip)
	{
		try{
			int hoststart = this.Mail.indexOf("@");
			String User = this.Mail.substring(0, hoststart);
			String Host = this.Mail.substring(hoststart+1);
	
			DNS dns = Sender.GetDNS(Host);
	
			Socket socket;
			
			boolean send = false;
	
			for (Server server : dns.Server) {
				try {
					socket = new Socket(server.Host, 25, InetAddress.getByName(ip), 0);
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

		            if(!Msg.substring(0, Msg.indexOf(" ")).equals("220"))
		            	throw new Exception(Msg);
	
		            if(!this.SendCmd("HELO", "250"))
		            	continue;
		            
		            if(!this.SendCmd(String.format("MAIL FROM:<%s>", this.Task.From), "250"))
		            	continue;
		            
		            if(!this.SendCmd(String.format("RCPT TO:<%s>", this.Mail), "250"))
		            	continue;
	
		            if(!this.SendCmd("DATA", "354"))
		            	continue;
	
		            //스마트폰에서 확인시 utf8 인코딩쪽에 문제가 있는것 같음.
		            //
		            out.println(String.format("From: <%s>\nTo: <%s>\nSubject: %s\n\n%s<img src=\"http://www.owl.or.kr/read.php?key=%s\" width=\"0\" height=\"0\">", this.Task.From, this.Mail, this.Task.Subject, this.Task.Message, "4.7.123"));
	
		            if(!this.SendCmd(".", "250"))
		            	continue;
		            
		            socket.close();
		            send = true;
		            //System.out.println(String.format("전송성공 %d %s", System.currentTimeMillis(), this.Mail));
		            Monitoring.test++;
		    		break;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(!send)
				throw new Exception("서버 접근 실패");
		}catch (Exception e)
		{
			e.printStackTrace();
			//이제 이걸 컨트롤러쪽으로 던져주던지....
		}
		
		//try {
			//if(!send)
			//	Sender.Connect.put(this);
		//} catch (InterruptedException e) {
			//e.printStackTrace();
		//}
		
		return true;
	}
	
	boolean SendCmd(String Cmd, String S) throws Exception
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
			throw new Exception(Msg);
		return r;
	}
}
