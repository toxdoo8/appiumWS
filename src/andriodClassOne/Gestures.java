package andriodClassOne;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Gestures {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = new Base().getDriver();
		TouchAction t = new TouchAction(driver);
		
		WebElement viewOption = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		viewOption.click();

		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();

		// t.press(driver.findElement(By.xpath(("//andriod.widget.TextView[@text='People
		// Names']"))).waitAction(5000).perform();
		t.press(driver.findElementByXPath("//android.widget.TextView[@text='People Names']")).waitAction(5000)
				.release().perform();
		System.out.println(driver.findElementById("android:id/title").getText());

	}

}
