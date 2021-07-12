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

	
	@BeforeTest
	public void startDocker () throws IOException, InterruptedException {		
	

		System.out.println("Starting Docker-compose...");

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
		
		System.out.println("Docker-compose successfuly started!");
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
