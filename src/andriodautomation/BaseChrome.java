package andriodautomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseChrome {

	public static enum DeviceType {EMULATOR, REAL};

	public static AndroidDriver<AndroidElement> getDriver(DeviceType deviceType) throws MalformedURLException {
		String urlPath = "http://127.0.0.1:4723/wd/hub";
		String emulatorName = "Demo";
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("you are using: " + os);

		DesiredCapabilities cap = new DesiredCapabilities();
		if (deviceType == DeviceType.EMULATOR) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName); 
		} else if (deviceType == DeviceType.REAL) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); 
		}
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(urlPath), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo"); 
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
	}
}
