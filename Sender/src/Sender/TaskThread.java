package Sender;

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
    			c.Task.Load(c);
    		}
    		else
    		{
    			if(System.currentTimeMillis()>time+5000)
    			{
    				//스래드가 5초이상 놀고있구먼.
					synchronized(Sender.IPList)
					{
						int count = (Sender.IPCount==0?Sender.IPList.length-1:Sender.IPCount-1);
						if(Sender.IPList[count].equals(ip))
						{
							Sender.IPCount = count;
							return;
						}
					}
    				
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