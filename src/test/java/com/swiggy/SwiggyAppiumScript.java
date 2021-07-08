package com.swiggy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwiggyAppiumScript {
	
	AndroidDriver<MobileElement> driver;

	@BeforeClass
	public void StartConnection () throws MalformedURLException {

		
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "sdk_gphone_x86_arm");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "in.swiggy.android");
		cap.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
		//cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

		
		URL url = new URL("http://0.0.0.0:4723/wd/hub/");
		driver = new AndroidDriver<MobileElement>(url, cap);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Connection successfuly started!");
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
