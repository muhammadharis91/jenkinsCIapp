package testapk;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.appobjects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class testcases {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException

	{
		File file = new File("src");
		File location = new File(file,"app-release-signed.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "firstemulator");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, location.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

	@Test(priority=1)
	//-----------------------------------------------Correct email and correct password-------------------------------------------------------//
	public void tc1() throws MalformedURLException, InterruptedException {     

		AndroidDriver<AndroidElement> driver=Capabilities();
		appobjects ao=new appobjects(driver);
		WebDriverWait loadwait = new WebDriverWait(driver, 30);
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Jenkins-CI-Test']")));
		ao.selectemail.sendKeys("abbasshah17@gmail.com");
		ao.selectpassword.sendKeys("12345678");
		ao.selectloginbutton.click();
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.jenkins_ci_test:id/loginStatus")));
		String toasttext = ao.checkloginstatus.getText();
		System.out.println(toasttext);
		Assert.assertEquals("Login successful", toasttext);


	}
	@Test(priority=2)
	//-----------------------------------------------Incorrect email-------------------------------------------------------//
	public void tc2() throws MalformedURLException, InterruptedException {     

		AndroidDriver<AndroidElement> driver=Capabilities();
		appobjects ao=new appobjects(driver);
		WebDriverWait loadwait = new WebDriverWait(driver, 30);
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Jenkins-CI-Test']")));
		ao.selectemail.sendKeys("engrmharis@gmail.com");
		ao.selectpassword.sendKeys("12345678");
		ao.selectloginbutton.click();
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.jenkins_ci_test:id/loginStatus")));
		String toasttext = ao.checkloginstatus.getText();
		System.out.println(toasttext);
		Assert.assertEquals("Email not valid", toasttext);


	}

	@Test(priority=3)
	//-----------------------------------------------empty email and empty password-------------------------------------------------------//
	public void tc3() throws MalformedURLException, InterruptedException {     

		AndroidDriver<AndroidElement> driver=Capabilities();
		appobjects ao=new appobjects(driver);
		WebDriverWait loadwait = new WebDriverWait(driver, 30);
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Jenkins-CI-Test']")));
		ao.selectloginbutton.click();
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.jenkins_ci_test:id/loginStatus")));
		String toasttext = ao.checkloginstatus.getText();
		System.out.println(toasttext);
		Assert.assertEquals("Please enter valid email and passwords", toasttext);


	}
	@Test(priority=4)
	//-----------------------------------------------correct email and empty password-------------------------------------------------------//
	public void tc4() throws MalformedURLException, InterruptedException {     

		AndroidDriver<AndroidElement> driver=Capabilities();
		appobjects ao=new appobjects(driver);
		WebDriverWait loadwait = new WebDriverWait(driver, 30);
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Jenkins-CI-Test']")));
		ao.selectemail.sendKeys("abbasshah17@gmail.com");
		ao.selectloginbutton.click();
		loadwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.jenkins_ci_test:id/loginStatus")));
		String toasttext = ao.checkloginstatus.getText();
		System.out.println(toasttext);
		Assert.assertEquals("Please enter valid email and password", toasttext);


	}
	@Test(priority=5)
	//-----------------------------------------------correct email and empty password-------------------------------------------------------//
	public void tc5() throws MalformedURLException, InterruptedException {     

		AndroidDriver<AndroidElement> driver=Capabilities();
		System.out.println("Test jenkinsCIapp");
		

	}

}