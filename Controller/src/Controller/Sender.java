package Controller;

public class Sender {
	public String Name;
	public String Key;
	public Monitoring Monitoring;
	
	public Sender(String Name, String Key)
	{
		this.Name = Name;
		this.Key = Key;
		this.Monitoring = new Monitoring();
	}
}
