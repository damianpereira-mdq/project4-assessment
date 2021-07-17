package com.swiggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DockerComposeSetup {	

	
	@BeforeTest
	public void startDocker () throws IOException, InterruptedException {		
	

		System.out.println("Starting Docker-compose...");
		/*
		 * // Working but somewhere over the cloud String[] args = new String[]
		 * {"/bin/bash", "-c", "docker-compose up -d"}; Process proc = new
		 * ProcessBuilder(args).start();
		 */
		
		// To test
		String myKey="/project4-assessment/NewKeyTest.pem";
		Runtime runtime = Runtime.getRuntime();
		String command = "ssh -i "+myKey+" ec2-user@ec2-3-23-60-85.us-east-2.compute.amazonaws.com 'bash /project4-assessment/start_dockerCompose.sh' -o StrictHostKeyChecking=no ";

		Process p = runtime.exec(command);
		p.waitFor();		
		
		
		/*
		 * try { Process proc = Runtime.getRuntime().exec("sh start_dockerCompose.sh");
		 * //Whatever you want to execute BufferedReader read = new BufferedReader(new
		 * InputStreamReader( proc.getInputStream())); try { proc.waitFor(); } catch
		 * (InterruptedException e) { System.out.println(e.getMessage()); } while
		 * (read.ready()) { System.out.println(read.readLine()); } } catch (IOException
		 * e) { System.out.println(e.getMessage()); }
		 */
		
		System.out.println("Docker-compose successfuly started!");
		Thread.sleep(60000);		

	}

		@AfterTest
		public void stopDocker () throws IOException, InterruptedException {

			String myKey="/project4-assessment/NewKeyTest.pem";
			Runtime runtime = Runtime.getRuntime();
			String command = "ssh -i "+myKey+" ec2-user@ec2-3-23-60-85.us-east-2.compute.amazonaws.com 'bash /project4-assessment/stop_dockerCompose.sh' -o StrictHostKeyChecking=no ";

			Process p = runtime.exec(command);
			p.waitFor();
			
			/*
			 * try { Process proc = Runtime.getRuntime().exec("sh stop_dockerCompose.sh");
			 * //Whatever you want to execute BufferedReader read = new BufferedReader(new
			 * InputStreamReader( proc.getInputStream())); try { proc.waitFor(); } catch
			 * (InterruptedException e) { System.out.println(e.getMessage()); } while
			 * (read.ready()) { System.out.println(read.readLine()); } } catch (IOException
			 * e) { System.out.println(e.getMessage()); }
			 */

			Thread.sleep(40000);						

		}	

	}
