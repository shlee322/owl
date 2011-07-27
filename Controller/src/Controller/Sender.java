package Controller;

import java.util.TimerTask;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Sender extends SimpleChannelHandler{
	boolean certification;
	String PacketBuffer;
	
	public Sender()
	{
		this.certification = false;
		this.PacketBuffer = "";
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
	{
		Channel ch = e.getChannel();
		ChannelBuffer buf = (ChannelBuffer)e.getMessage();
		
		
		
		while(buf.readable())
		{
			System.out.println((char)buf.readByte());
			System.out.flush();
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
	{
		e.getCause().printStackTrace();
		
		Channel ch = e.getChannel();

		ch.close();
	}
	
	public static class WorkTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("Timer.");
		  }
	}

}
