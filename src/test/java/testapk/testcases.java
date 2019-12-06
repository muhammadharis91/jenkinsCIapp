package testapk;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.appobjects;
public class Testcases {
	
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException
	
	
	{
		File file = new File("src");
		File location = new File(file,"app-release-signed.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "firstemulator");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, location.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		System.out.println("driver testcase");
		return driver;
		
	}

	@Test(priority=1)
	@Severity(SeverityLevel.BLOCKER)
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
	@BeforeSuite
	@Severity(SeverityLevel.CRITICAL)
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
	@Severity(SeverityLevel.NORMAL)
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
		Assert.assertEquals("Please enter valid email and password", toasttext);


	}
	@Test(priority=4)
	@Severity(SeverityLevel.MINOR)
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
	@BeforeTest
	@Severity(SeverityLevel.TRIVIAL)
	//-----------------------------------------------correct email and empty password-------------------------------------------------------//
	public void tc5() throws MalformedURLException, InterruptedException {     

		AndroidDriver<AndroidElement> driver=Capabilities();
		System.out.println("Test jenkinsCIapp");
		

	}

}