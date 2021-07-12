package com.swiggy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwiggyAppiumScript {
	
	AppiumDriver<WebElement> driver;
	
	@BeforeClass
	public void StartConnection () throws MalformedURLException {

		System.out.println("Starting Connection...");
		
		DesiredCapabilities cap = new DesiredCapabilities();			
		
		/* SWIGGY
		 * cap.setCapability("deviceName", "appium-emulator");
		 * cap.setCapability("udid","emulator-5554"); cap.setCapability("platformName",
		 * "Android"); cap.setCapability("platformVersion", "4.4");
		 * cap.setCapability("appPackage","in.swiggy.android");
		 * cap.setCapability("appActivity","in.swiggy.android.activities.HomeActivity");
		 */
		
		
		  cap.setCapability("deviceName", "appium-emulator"); 
		  cap.setCapability("udid","emulator-5554"); 
		  cap.setCapability("platformName", "Android"); 
		  cap.setCapability("platformVersion", "4.4"); 
		  cap.setCapability("appPackage","com.android.calculator2"); 
		  cap.setCapability("appActivity","com.android.calculator2.Calculator");
		 
		
		
		
		
		
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		//cap.setCapability("systemPort", 8201);		
		//cap.setCapability("appPackage", "com.miui.calculator");
		//cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");		
			
		
		//This is Docker 		
		URL url = new URL("http://0.0.0.0:49155/wd/hub");

		//This is local Appium
		//URL url = new URL("http://127.0.0.1:4723/wd/hub/");		
		
		driver = new AppiumDriver<WebElement>(url, cap);		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Connection successfuly started!");
		driver.quit();
	}

	@AfterClass
	public void TearDown () {		
		//driver.quit();
	}
	
	@Test
	public void test1 () {
		
		System.out.println("This is the test N1");
	}

}
