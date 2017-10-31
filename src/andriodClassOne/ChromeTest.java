package andriodClassOne;

import java.net.MalformedURLException;

import org.apache.http.impl.cookie.BasicSecureHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ChromeTest {
	
	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities cap = null;
	
	@BeforeTest
	public void init() throws MalformedURLException {
		driver = BaseChrome.getDriver(BaseChrome.DeviceType.EMULATOR);
	}
	
	@Test
	public void openChrom() {
		System.out.println("Hello I am testing chrome on android now");
	}

	@AfterTest
	public void cleanup() {
		driver.close();
	}
}
