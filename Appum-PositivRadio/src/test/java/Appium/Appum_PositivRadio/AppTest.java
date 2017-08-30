package Appium.Appum_PositivRadio;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppTest {

	WebDriver driver = null;

	@BeforeMethod
	public void setup() throws InterruptedException, MalformedURLException {
		File appDir = new File("D:/APK");
		File app = new File(appDir, "positivradio.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		// capabilities.setCapability("deviceName", "S6");
		capabilities.setCapability("deviceName", "192.168.237.101:5555");
		capabilities.setCapability(CapabilityType.VERSION, "5.1.0");
		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		capabilities.setCapability("platformVersion", "5.1.0");
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

	@Test(priority = 1)
	public void signUp() {

		MobileElement PlayServiceErrorPopUp2 = (MobileElement) (driver.findElement(By.name("OK")));
		PlayServiceErrorPopUp2.click();

		MobileElement ClickSignUp = (MobileElement) (driver.findElement(By.name("SIGN UP")));
		ClickSignUp.click();

		MobileElement PlayServiceErrorPopUp3 = (MobileElement) (driver.findElement(By.name("OK")));
		PlayServiceErrorPopUp3.click();

		MobileElement FUllName = (MobileElement) (driver.findElement(By.name("Full Name")));
		FUllName.sendKeys("Test Account");

		MobileElement Email = (MobileElement) (driver.findElement(By.name("Email")));
		Email.sendKeys("test.account21@mailinator.com");

		MobileElement Password = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/edittext_password")));
		Password.sendKeys("Gate6@123");

		MobileElement ClickSignUpButton = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/btn_signup")));
		ClickSignUpButton.click();

		MobileElement mediaPermission = (MobileElement) (driver.findElement(By.name("Allow")));
		mediaPermission.click();

		MobileElement PlayServiceErrorPopUp4 = (MobileElement) (driver.findElement(By.name("OK")));
		PlayServiceErrorPopUp4.click();

		MobileElement AssertCheck = (MobileElement) (driver.findElement(By.name("FREE")));
		String AssertCheck1 = AssertCheck.getText();

		Assert.assertEquals("FREE", AssertCheck1);

	}

	@Test(priority = 2)
	public void Login_Logout() {

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

		MobileElement Setting = (MobileElement) (driver.findElement(By.id("com.medianet.positivradio:id/imageView")));
		Setting.click();

		MobileElement clickLogout = (MobileElement) (driver.findElement(By.name("Logout")));
		clickLogout.click();

		MobileElement confirmationPopup = (MobileElement) (driver.findElement(By.name("OK")));
		confirmationPopup.click();

	}

	@Test(priority = 3)
	public void facebookSignup() {

		MobileElement PlayServiceErrorPopUp = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp.click();

		MobileElement clickFacebook = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_facebook")));
		clickFacebook.click();

		MobileElement userName = (MobileElement) (driver.findElement(By.name("Email address or phone number")));
		userName.sendKeys("manish.dangas@gate6.com");

		List<WebElement> Password = (driver.findElements(By.xpath("//android.widget.EditText")));
		Password.get(1).sendKeys("Gate6@321");

		MobileElement ClickLogin = (MobileElement) (driver.findElement(By.xpath("//android.widget.Button")));
		ClickLogin.click();

		MobileElement clickContinue = (MobileElement) (driver.findElement(By.className("android.webkit.WebView")));
		clickContinue.click();

		WebElement parentElement = driver.findElement(By.className("android.webkit.WebView"));
		List<WebElement> childElements = parentElement.findElements(By.className("android.view.View"));
		WebElement mainElement = childElements.get(3);
		mainElement.findElement(By.className("android.view.View"));
		WebElement mainElement1 = childElements.get(0);
		mainElement1.findElement(By.className("android.view.View"));
		WebElement mainElement2 = childElements.get(1);
		mainElement2.findElement(By.className("android.view.View"));
		WebElement mainElement3 = childElements.get(0);
		mainElement3.findElement(By.className("android.widget.Button")).click();

		MobileElement mediaPermission = (MobileElement) (driver.findElement(By.name("Allow")));
		mediaPermission.click();

		MobileElement PlayServiceErrorPopUp1 = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp1.click();

		MobileElement assertCheck = (MobileElement) (driver.findElement(By.name("Browse")));
		String Content = assertCheck.getText();

		Assert.assertEquals("Browse", Content);

	}

	@Test(priority = 4)
	public void forgotPassword() {

		MobileElement PlayServiceErrorPopUp = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp.click();

		MobileElement clickForgotPass = (MobileElement) (driver.findElement(By.name("Forgot password?")));
		clickForgotPass.click();

		MobileElement userName = (MobileElement) (driver.findElement(By.name("Email")));
		userName.sendKeys("test12@mailinator.com");

		MobileElement ClickLogin = (MobileElement) (driver.findElement(By.name("GENERATE OTP")));
		ClickLogin.click();

		MobileElement assertCheck = (MobileElement) (driver.findElement(By.name("Forgot password?")));
		String Content = assertCheck.getText();

		Assert.assertEquals("Forgot password?", Content);

	}

	@Test(priority = 5)
	public void AddAndRemoveToLibrary() {

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

		// Login to the application

		MobileElement ClickBrowse = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/tab_Browse")));
		ClickBrowse.click();

		MobileElement SelectTopSpeakers = (MobileElement) (driver.findElement(By.name("Top Speakers")));
		SelectTopSpeakers.click();

		MobileElement SelectTalk = (MobileElement) (driver.findElement(By.name("Jack Canfield")));
		SelectTalk.click();

		MobileElement ClickThreeDot = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot.click();

		MobileElement AddLibrary = (MobileElement) (driver.findElement(By.name("Add to Library")));
		AddLibrary.click();

		MobileElement ClickThreeDot1 = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot1.click();

		MobileElement GetStatus = (MobileElement) (driver.findElement(By.name("Remove from Library")));
		String test = GetStatus.getText();

		Assert.assertEquals("Remove from Library", test);

		MobileElement ClickRemoveFromLibrary = (MobileElement) (driver.findElement(By.name("Remove from Library")));
		ClickRemoveFromLibrary.click();

		MobileElement ClickThreeDot2 = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot2.click();

		MobileElement GetStatus1 = (MobileElement) (driver.findElement(By.name("Add to Library")));
		String Assert1 = GetStatus1.getText();

		Assert.assertEquals("Add to Library", Assert1);

	}

	@Test(priority = 6)
	public void DownloadAndRemoveToLibrary() {

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

		// Login to the application

		MobileElement ClickBrowse = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/tab_Browse")));
		ClickBrowse.click();

		MobileElement SelectTopSpeakers = (MobileElement) (driver.findElement(By.name("Top Speakers")));
		SelectTopSpeakers.click();

		MobileElement SelectTalk = (MobileElement) (driver.findElement(By.name("Jack Canfield")));
		SelectTalk.click();

		MobileElement ClickThreeDot = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot.click();

		MobileElement Download = (MobileElement) (driver.findElement(By.name("Download")));
		Download.click();

		MobileElement ClickThreeDot1 = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot1.click();

		MobileElement GetStatus = (MobileElement) (driver.findElement(By.name("Remove from Downloads")));
		String test = GetStatus.getText();

		//System.out.println(GetStatus);

		Assert.assertEquals("Remove from Downloads", test);

		MobileElement ClickRemoveDownload = (MobileElement) (driver.findElement(By.name("Remove from Downloads")));
		ClickRemoveDownload.click();

		MobileElement ClickThreeDot2 = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot2.click();

		MobileElement GetStatus1 = (MobileElement) (driver.findElement(By.name("Download")));
		String Assert1 = GetStatus1.getText();

		//System.out.println(GetStatus1);

		Assert.assertEquals("Download", Assert1);

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {

		Thread.sleep(10000);
		driver.quit();
	}

}
