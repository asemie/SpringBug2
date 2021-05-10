package com.syf.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseDriver {
	public AndroidDriver<AndroidElement> driver;

	@BeforeClass
	public void startUp() throws MalformedURLException {
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "127.0.0.1:62001");
		cap.setCapability("appPackage", "net.onest.hanstyleproject");
		cap.setCapability("appActivity", ".MainActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<AndroidElement>(url, cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}