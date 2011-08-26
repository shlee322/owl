package apiServer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class logging {
	public static Logger logging = Logger.getLogger(thriftApiServer.class);

	public void startLogging() {
		PropertyConfigurator.configure("log4j.properties");
	}
}
