package andriodautomation;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SwipeDemo {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = new Base().getDriver();
		TouchAction t = new TouchAction(driver);
		
//		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		WebElement viewOption = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		viewOption.click();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		t.press(driver.findElementByXPath("//*[@content-desc='15']")).waitAction(2000)
				.moveTo(driver.findElementByXPath("//*[@content-desc='45']")).release().perform();
		
	}

}
