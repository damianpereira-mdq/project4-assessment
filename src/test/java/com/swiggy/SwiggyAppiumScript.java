package com.swiggy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwiggyAppiumScript {
	
	static AndroidDriver<WebElement> driver;	
	
	@Test
	public void StartConnection () throws MalformedURLException {

		
		DesiredCapabilities cap = new DesiredCapabilities();		
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.1.1");
		//cap.setCapability("remoteAdbHost", "127.0.0.1");
		//cap.setCapability("adbPort", "6080");
		
		
		//cap.setCapability("app", "/swiggy-3-69-1.apk");
		//cap.setCapability("appPackage", "in.swiggy.android");
		//cap.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
		//cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		
		
		//This is Docker 		
		URL url = new URL("http://127.0.0.1:4444/wd/hub/");

		//This is local Appium
		//URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		
		
		driver = new AndroidDriver<WebElement>(url, cap);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Connection successfuly started!");
	}

	
	public void TearDown () {		
		//driver.quit();
	}
	
	@Test
	public void test1 () {
		
		System.out.println("This is the test N1");
	}

}
