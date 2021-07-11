package com.swiggy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwiggyAppiumScript {
	
	static AndroidDriver<AndroidElement> driver = null;
	
	@Test
	public void StartConnection () throws MalformedURLException {

		
		
		DesiredCapabilities cap = new DesiredCapabilities();			
		
		cap.setCapability("deviceName", "nexus_5_5.1.1");		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		cap.setCapability("systemPort", 8201);
		
		//cap.setCapability("appPackage", "com.miui.calculator");
		//cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");		
			
		
		//This is Docker 		
		URL url = new URL("http://3.135.209.114:4444/wd/hub");

		//This is local Appium
		//URL url = new URL("http://127.0.0.1:4723/wd/hub/");		
		
		driver = new AndroidDriver<>(url, cap);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Connection successfuly started!");
		driver.quit();
	}

	
	public void TearDown () {		
		//driver.quit();
	}
	
	@Test
	public void test1 () {
		
		System.out.println("This is the test N1");
	}

}
