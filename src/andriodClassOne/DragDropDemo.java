package andriodClassOne;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragDropDemo extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = new Base().getDriver();
 		
		WebElement viewOption = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		viewOption.click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		TouchAction t = new TouchAction(driver);
		t.longPress(driver.findElementsByClassName("android.view.View").get(0)).moveTo(driver.findElementsByClassName("android.view.View").get(1)).release().perform();
//		t.longPress(driver.findElementById("io.appium.android.apis:id/drag_dot_1")).moveTo(driver.findElementById("io.appium.android.apis:id//drag_dot_3")).release().perform();
//		io.appium.android.apis:id//drag_dot_1
//		com.example.android.apis:id//drag_dot_1
		
	}

}
