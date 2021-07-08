package com.swiggy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DockerComposeSetup {
	
	@BeforeTest
	public void startDocker () throws IOException, InterruptedException {
		
		System.out.println("Startin Docker-compose");
		Process proc = Runtime.getRuntime().exec("./start_dockerCompose.sh");                        
		proc.waitFor();
		Thread.sleep(25000);		
		
	}
	
	@AfterTest
	public void stopDocker () throws IOException, InterruptedException {
		
		System.out.println("Shutting down Docker-compose");
		Process proc = Runtime.getRuntime().exec("./stop_dockerCompose.sh");                        
		proc.waitFor();
		Thread.sleep(25000);				
		
	}	

}
