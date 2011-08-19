//���� : 2011-07-15 15:00
package Sender;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;

import org.apache.log4j.Logger;

import biz.source_code.base64Coder.Base64Coder;

public class Connect {
	static Logger logger = Logger.getLogger(Connect.class);
	
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
	
		            //스마트폰에서 확인시 utf8 인코딩쪽에 문제가 있는것 같음.
		            //
		            out.println(String.format("MIME-Version: 1.0\nFrom: <%s>\nTo: <%s>\nSubject: =?UTF-8?B?%s?=\nContent-Type: text/html; charset=UTF-8\nContent-Transfer-Encoding: base64\n\n%s", this.Task.From, this.Mail, Base64Coder.encodeString(this.Task.Subject), Base64Coder.encodeString(this.Task.Message + String.format("<img src=\"http://www.owl.or.kr/read.php?objectid=%s&key=%s\" width=\"0\" height=\"0\">","123","123"))));
	
		            if(!this.SendCmd(".", "250"))
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
			//Connect.logger.error(e.getMessage());
			e.printStackTrace();
			//이제 이걸 컨트롤러쪽으로 던져주던지....
		}
		return true;
	}
	
	boolean SendCmd(String Cmd, String S) throws Exception
	{
		out.println(Cmd);
        String Msg="";
		try {
			while(true)
			{
				Msg = in.readLine();

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
