package andriodautomation;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ChromeTest {
	
	AndroidDriver<AndroidElement> driver;
//	DesiredCapabilities cap = null;
	
	@BeforeTest
	public void init() throws MalformedURLException {
//		driver = BaseChrome.getDriver(BaseChrome.DeviceType.EMULATOR);
		driver = BaseChrome.capabilities();
	}
	
	@Test
	public void openChrom() {		
		driver.findElementByXPath("//android.widget.Button[@text='ACCEPT & CONTINUE']").click();
		driver.findElementByXPath("//android.widget.Button[@text='CONTINUE']").click();
		driver.findElementByXPath("//android.widget.Button[@text='OK, GOT IT']").click();
		
		driver.get("http://facebook.com");
		
		System.out.println("Hello I am testing chrome on android now");
	}

	@AfterTest
	public void cleanup() {
		driver.close();
	}
}
