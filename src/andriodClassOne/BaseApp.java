package andriodClassOne;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseApp {

	public static void main(String[] args) throws MalformedURLException {
		// Create object of Desiredcap class and specify android
		// platform
		DesiredCapabilities cap = new DesiredCapabilities();

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
		WebDriver driver = new AndroidDriver(url, cap);
//		driver = new AndroidDriver<>(new URL(urlPath), cap);

		// Open url
		driver.get("http://www.facebook.com");

		// print the title
		System.out.println("Title " + driver.getTitle());

		// enter username
		driver.findElement(By.name("email")).sendKeys("mukesh@gmail.com");

		// enter password
		driver.findElement(By.name("pass")).sendKeys("mukesh_selenium");

		// click on submit button
		driver.findElement(By.id("u_0_5")).click();

		// close the browser
		driver.quit();
	}
}
