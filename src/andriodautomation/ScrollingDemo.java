package andriodautomation;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollingDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = new Base().getDriver();
		
		WebElement viewOption = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		viewOption.click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		driver.findElementByXPath("//android.widget.TextView[@text='WebView']").click();
	}

}
