package com.swiggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class DockerComposeSetup {

	int iExitValue;
	String sCommandString;

	public void runScript(String command){
		sCommandString = command;
		CommandLine oCmdLine = CommandLine.parse(sCommandString);
		DefaultExecutor oDefaultExecutor = new DefaultExecutor();
		oDefaultExecutor.setExitValue(0);
		try {
			iExitValue = oDefaultExecutor.execute(oCmdLine);
		} catch (ExecuteException e) {
			System.err.println("Execution failed.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("permission denied.");
			e.printStackTrace();
		}
	}

	
	@BeforeTest
	public void startDocker () throws IOException, InterruptedException {		
	

		System.out.println("Starting Docker-compose");

		try {
            Process proc = Runtime.getRuntime().exec("sh start_dockerCompose.sh"); //Whatever you want to execute
            BufferedReader read = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            try {
                proc.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            while (read.ready()) {
                System.out.println(read.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

		Thread.sleep(25000);		

	}

		@AfterTest
		public void stopDocker () throws IOException, InterruptedException {

			try {
	            Process proc = Runtime.getRuntime().exec("sh stop_dockerCompose.sh"); //Whatever you want to execute
	            BufferedReader read = new BufferedReader(new InputStreamReader(
	                    proc.getInputStream()));
	            try {
	                proc.waitFor();
	            } catch (InterruptedException e) {
	                System.out.println(e.getMessage());
	            }
	            while (read.ready()) {
	                System.out.println(read.readLine());
	            }
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }	

			Thread.sleep(25000);						

		}	

	}
