package Sender;

public class Monitoring {
	static long time=0;
	static long test=0;
	static public void Run()
	{
		if(System.currentTimeMillis()<=time)
			return;
		time=System.currentTimeMillis()+500;
		System.out.println(String.format("스레드수 : %d 메모리 : %d 테스트 : %d", Thread.activeCount(), usedMemory(),test));
	}
	
	static public long usedMemory()
	{
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
}
