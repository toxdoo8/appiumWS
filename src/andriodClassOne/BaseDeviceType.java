package andriodClassOne;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import andriodClassOne.Base.DeviceType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseDeviceType {
	
	public static enum DeviceType{EMULATOR,REAL};

	public static AndroidDriver<AndroidElement> getDriver(DeviceType deviceType) throws MalformedURLException {
		
//		AndroidDriver<AndroidElement>  driver;
		String urlPath = "http://127.0.0.1:4723/wd/hub";
		String emulatorName = "Demo";
		String appName = "ApiDemos-debug.apk";
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("you are using: " + os);
		
		File f = new File("src/appiumAndriodClassOne");
		File fs = new File(f, appName);
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName);
		
		if(deviceType == DeviceType.EMULATOR) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName); // for emulator
		} else if(deviceType == DeviceType.REAL){
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // for a real device
		}
		
//		if(deviceType.equals("emulator")) {
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName); // for emulator
//		} else if(deviceType.equals("real")){
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // for a real device
//		}
		
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(urlPath), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
//		driver.close();
	}

}
