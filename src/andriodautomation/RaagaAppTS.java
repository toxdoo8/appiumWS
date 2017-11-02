package andriodautomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import andriodautomation.BaseDeviceType.DeviceType;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class RaagaAppTS {
	AndroidDriver<AndroidElement> driver = null;
	DesiredCapabilities cap = null;
	
	@BeforeClass
	public void init() throws MalformedURLException {
		driver = BaseDeviceType.getDriver(DeviceType.EMULATOR);	
	}

	@Test
	public void raagaAppEndToEnd() throws MalformedURLException {
		File appdir = new File("src");
		File app = new File(appdir, "Raaga.apk");		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("android:id/button2")).click();
//		driver.findElementByAndroidUIAutomator("text(\"LATER\")").click();
//		driver.findElementByXPath("//android.widget.Button[@text='LATER']").click();
		
//		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(className(\"android.widget.RelativeLayout\").get(11))");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"World Music\"))");
		driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
		
//		driver.scrollTo("Trending Now");
		TouchAction t = new TouchAction(driver);
		WebElement trendingNowEl = driver.findElementById("com.raaga.android:id/xrellay_TrendingNow");
		t.tap(trendingNowEl).perform();
		
		List<WebElement> webEl = driver.findElementsByClassName("android.widget.TextView");
		for(int i = 0; i<webEl.size(); i++) {
			if(webEl.get(i).getText().contains("Tum")) { //When this statement returned True
//				driver.findElementByXPath("//android.widget.TextView[@text='Tum']").click();
				t.longPress(driver.findElementByXPath("//android.widget.TextView[@text='Tum']"));
			}
		}
	}

	@Test
	public void raagaAppEndToEnd2() throws MalformedURLException {
		String appPath = "src";
		String appName = "Raaga.apk";
		String emulatorName = "Demo";
		String urlPath = "http://127.0.0.1:4723/wd/hub";
		
		File appDir = new File(appPath);
		File app = new File(appDir, appName);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(urlPath), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"LATER\")").click();
	}
}
