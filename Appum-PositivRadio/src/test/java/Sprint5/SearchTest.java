package Sprint5;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class SearchTest {

	AndroidDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException, MalformedURLException {
		File appDir = new File("D:/APK");
		File app = new File(appDir, "positivradio.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		// capabilities.setCapability("deviceName", "S6");
		capabilities.setCapability("deviceName", "192.168.237.101:5555");
		// capabilities.setCapability(CapabilityType.VERSION, "5.1.0");
		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");

		// Here we mention the app's package name, to find the package name we
		// have to convert .apk file into java class files
		capabilities.setCapability("app-package", "com.positivradio");
		// Here we mention the activity name, which is invoked initially as
		// app's first page.
		capabilities.setCapability("app-activity", "com.positivradio.activity");
		// capabilities.setCapability("fullReset", false);
		// driver.startActivity("com.medianet.positivradio",
		// "com.medianet.positivradio.activity.SplashActivity");
		// capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4730/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		// driver.quit();

	}

	@Test(priority = 1)
	public void doLogin() {

		MobileElement PlayServiceErrorPopUp = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp.click();

		MobileElement Email = (MobileElement) (driver.findElement(By.name("Email")));
		Email.sendKeys("manish.dangas@gate6.com");

		MobileElement Password = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/edittext_password")));
		Password.sendKeys("Gate6@123");

		MobileElement ClickSign = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/btn_signin")));
		ClickSign.click();

		MobileElement mediaPermission1 = (MobileElement) (driver.findElement(By.name("Allow")));
		mediaPermission1.click();

		MobileElement PlayServiceErrorPopUp1 = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp1.click();

	}

//	@Test(priority = 2)
//	public void SearchTalk() {
//
//		MobileElement ClickOnSearch = (MobileElement) (driver.findElement(By.name("Search")));
//		ClickOnSearch.click();
//		
//		
//		MobileElement SearchTalk = (MobileElement) (driver
//				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
//		SearchTalk.sendKeys("tony robbins");
//		SearchTalk.clear();
//		
//	}
//
//	@Test(priority = 3)
//	public void SearchSpeaker() {
//
//		MobileElement SearchTalk = (MobileElement) (driver
//				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
//		SearchTalk.sendKeys("Grant cardon");
//		SearchTalk.clear();
//	}
//
//	@Test(priority = 4)
//	public void PartialKeywordSearchTalk() {
//
//		MobileElement SearchParTalk = (MobileElement) (driver
//				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
//		SearchParTalk.sendKeys("Ton");
//		SearchParTalk.clear();
//
//	}
//
//	@Test(priority = 5)
//	public void PartialKeywordSearchSpeaker() {
//
//		MobileElement SearcParTalk = (MobileElement) (driver
//				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
//		SearcParTalk.sendKeys("Gran");
//		SearcParTalk.clear();
//
//	}
	
	@Test(priority = 6)
	public void SearchTalkAndVerifyIt() {

		MobileElement SearchTalk = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
		SearchTalk.sendKeys("tony robbins");
		
		MobileElement ClickTalk = (MobileElement) (driver
				.findElement(By.className("android.widget.TextView")));
		ClickTalk.click();
		
		MobileElement Text = (MobileElement) (driver
				.findElement(By.name("Speaker")));
		String content= Text.getText();
		System.out.println(content);
		
		Assert.assertEquals("Speaker", content);
		
		
		}

//	@Test(priority = 6)
//	public void SearchSpeakerAndVerifyIt() {
//
//		MobileElement SearchTalk = (MobileElement) (driver
//				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
//		SearchTalk.sendKeys("tony robbins");
//		
//		MobileElement ClickTalk = (MobileElement) (driver
//				.findElement(By.id("com.medianet.positivradio:id/txt_artistName")));
//		ClickTalk.sendKeys("tony robbins");
//		
//		}
	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
