package io.acornsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.acornsoft.client.Client1;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	private static final int PORT_NUMBER = 4432;
	
	public static void main(String[] args) {
		

		logger.info("* * * * * * * * * * * * * * * * * * *");
		logger.info("* Socket Application Client Process Start");
		logger.info("* * * * * * * * * * * * * * * * * * *");
		
		try {
			if(args!=null && args.length > 0) {
				String ip = args[0];
				int port = PORT_NUMBER;
				
				for(int i=0; i<86400; i++) {
					new Client1(i, ip, port);
					Thread.sleep(2500);
				}
			}
			else {
				
				String ip = System.getenv("DSERVER_IP")==null?"":System.getenv("DSERVER_IP");
				
				if(ip.equals("")) {
					System.out.println("* * * * * * * * * * * * * * * * * * *");
					System.out.println("* There are two ways to RUN. ");
					System.out.println("* 1. java -jar <RUNABLE_JAR_FILENAME> <SERVER_IP> ");
					System.out.println("* 2. export DSERVER_IP=<SERVER_IP>  ");
					System.out.println("*    java -jar <RUNABLE_JAR_FILENAME>  ");
					System.out.println("* * * * * * * * * * * * * * * * * * *");
				}
				else {
					int port = PORT_NUMBER;
					
					for(int i=0; i<86400; i++) {
						new Client1(i, ip, port);
						Thread.sleep(2500);
					}	
				}
			}
			
		}
		catch(Exception e) {
			logger.error(e.toString());
			System.out.println(e);
		}
		
	}

}
