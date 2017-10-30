package andriodClassOne;

import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import andriodClassOne.Base.DeviceType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics {
	
	public static void main(String[] args) throws MalformedURLException {
		
//		AndroidDriver<AndroidElement> driver = (new base()).capabilities();		
		AndroidDriver<AndroidElement> driver = Base.getDriver();		
		
//		WebElement optPreference = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
//		optPreference.click();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		
		driver.findElementById("android:id/checkbox").click();
		
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Monday Monday");
		driver.findElementsByClassName("android.widget.Button").get(2).click();
				
	}

}
