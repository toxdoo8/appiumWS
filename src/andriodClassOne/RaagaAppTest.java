package andriodClassOne;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class RaagaAppTest extends Base{

	static AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		new BaseDeviceType();
		driver = Base.getDriver();
	}
	
	@Test
	public static void raagaOpenAppChangeNotification() throws MalformedURLException {	
		driver.findElementById("com.raaga.android:id/skip_login_btn").click();
		driver.findElementById("com.raaga.android:id/talk_intro_gotit_btn").click();
		// driver.findElementByXPath("//android.widget.RelativeLayout").click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");

//		driver.findElementByXPath("//com.raaga.android:id/text_view_lang[@text='Bengali']").click();
//		driver.findElementsByClassName("android.widget.RelativeLayout").get(5).click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(xpath(\"//android.widget.TextView[@text='World Music']\"))");
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(className(\"android.widget.RelativeLayout\").get(11))");
//		assertTrue(el.isDisplayed());
		
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"World Music\"))");
		driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceID(\"com.raaga.android:id/music_home_raaga_live\"))");
		driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();
	}

	@Test
	public void raagaEndToEnd1() throws MalformedURLException {
		driver.findElement(By.id("android:id/button2")).click();
//		driver.findElementByAndroidUIAutomator("text(\"LATER\")").click();
//		driver.findElementByXPath("//android.widget.Button[@text='LATER']").click();
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(className(\"android.widget.RelativeLayout\").get(11))");
		driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
	}
	
	@Test
	public void raagaEndToEnd2() throws MalformedURLException {
		File appdir = new File("src");
		File app = new File(appdir, "raaga.apk");		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.findElement(By.id("android:id/button2")).click();
//		driver.findElementByAndroidUIAutomator("text(\"LATER\")").click();
//		driver.findElementByXPath("//android.widget.Button[@text='LATER']").click();	
	}
		
}
