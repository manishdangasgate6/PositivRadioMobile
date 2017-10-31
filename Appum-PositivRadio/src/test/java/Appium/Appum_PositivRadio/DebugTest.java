package Appium.Appum_PositivRadio;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DebugTest {
	Dimension size;
	AndroidDriver driver;

	@BeforeMethod
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
		// capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4730/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		// driver.quit();

	}

	@Test(priority = 8)
	public void AddTalkToLibrar() throws InterruptedException {

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

		MobileElement ClickBrowse = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/tab_Browse")));
		ClickBrowse.click();

		driver.scrollTo("Ultimate Edge");

		MobileElement SelectOneTalk = (MobileElement) (driver.findElement(By.name("Ultimate Edge")));
		SelectOneTalk.click();

		MobileElement ClickThreeDot = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/header_menu")));
		ClickThreeDot.click();

		MobileElement AddtoLibrary = (MobileElement) (driver.findElement(By.name("Add to Library")));
		AddtoLibrary.click();
		
		MobileElement ClickThreeDot1 = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/header_menu")));
		ClickThreeDot1.click();
		
		MobileElement CheckText = (MobileElement) (driver.findElement(By.name("Remove from Library")));
		String Assert12 = CheckText.getText();
		
		Assert.assertEquals("Remove from Library", Assert12);
		
	}
}
