package andriodClassOne;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class Miscellaneous {

	public static void main(String[] args) throws MalformedURLException {
		new Base();
		AndroidDriver<AndroidElement> driver = Base.getDriver();
		
		System.out.println("currentActivity: " + driver.currentActivity());
		System.out.println("getContext: " + driver.getContext());
		System.out.println("getDeviceTime: " + driver.getDeviceTime() + driver.getContext());
		
		System.out.println(driver.getOrientation());
		System.out.println(driver.isLocked());
//		driver.hideKeyboard();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.pressKeyCode(AndroidKeyCode.BACK);
		System.out.println("pressKeyCode.AndroidKeyCode.BACK");
		driver.pressKeyCode(AndroidKeyCode.HOME);
		System.out.println("pressKeyCode.AndroidKeyCode.HOME");
	}

}
