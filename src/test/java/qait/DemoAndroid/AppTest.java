package qait.DemoAndroid;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppTest {

	public static void main(String[] args) {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);
		
		//Set ChromeDriver location
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harshitsrivastava\\Downloads\\chromedriver.exe");
		
		//Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
				
		//Open URL in Chrome Browser
		driver.get("https://qainfotech.com/");
		MobileElement text = (MobileElement)(driver.findElement(By.id("s")));
		text.sendKeys("automation");
		MobileElement submit_btn = (MobileElement)(driver.findElement(By.id("searchsubmit")));
		submit_btn.click();
		
		
	}
}