package Sender;

public class Monitoring {
	static public void Run()
	{
	}
	
	static public long usedMemory()
	{
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
}
