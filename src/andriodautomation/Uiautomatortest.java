package andriodautomation;

import java.net.MalformedURLException;

import org.apache.commons.codec.binary.Base32;
import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Uiautomatortest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = new Base().getDriver();
		
		System.out.println(driver.findElementByXPath("//andriod.widget.TextView[@text='Views']").getText());
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size());
		System.out.println("Test is done, and maybe passed");
	}

}
