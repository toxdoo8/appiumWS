package andriodClassOne;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LaunchChrom {
	
	DesiredCapabilities cap = new DesiredCapabilities();

	@Test
	public void launchChrome() throws MalformedURLException {

		// Create object of DesiredCapabilities class and specify android platform

		// set the capability to execute test in chrome browser
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

		// set the capability to execute our test in Android Platform
		cap.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

		// we need to define platform name
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		// Set the device name as well (you can give any name)
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "my phone");

		// set the android version as well
		cap.setCapability(MobileCapabilityType.VERSION, "5.0.1");

		// Create object of URL class and specify the appium server address
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		// Create object of AndroidDriver class and pass the url and capability
		// that we created
		WebDriver driver = new AndroidDriver<>(url, cap);

		// Open url
//		driver.get("http://www.facebook.com");
		driver.get("https://liveqa31.adaptiveplanning.com/app");

		// print the title
		System.out.println("Title " + driver.getTitle());

		// enter username
		driver.findElement(By.name("email")).sendKeys("a4@czgc.com");

		// enter password
		driver.findElement(By.name("pass")).sendKeys("aaa");

		// click on submit button
		driver.findElement(By.id("u_0_5")).click();

		// close the browser
		driver.quit();
	}
	
	@Test
	public void payTMApp() throws MalformedURLException {
		String urlPath = "http://127.0.0.1:4723/wd/hub";
		
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//		if (String name == "device") {
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
//		} else {
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
//		}
				
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "net.one97.paytm");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "net.one97.paytm.AJRMainActivity");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(urlPath), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
