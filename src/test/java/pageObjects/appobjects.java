package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class appobjects {
	
	public appobjects(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.example.jenkins_ci_test:id/input_email")
	public WebElement selectemail;
	
	@AndroidFindBy(id="com.example.jenkins_ci_test:id/input_password")
	public WebElement selectpassword;  
	
	@AndroidFindBy(id="com.example.jenkins_ci_test:id/login_button")
	public WebElement selectloginbutton;  

	
	//@AndroidFindBy(xpath="//*[@text='11:30 AM']")
	//public WebElement Catchupplayed_2;
	
	@AndroidFindBy(id="com.example.jenkins_ci_test:id/loginStatus")
	public WebElement checkloginstatus;

	@AndroidFindBy(id="com.jgo.go:id/nextIcon")
	public WebElement previousChannelplayed;
			
	@AndroidFindBy(id="com.jgo.go:id/playPauseIcon")
	public WebElement playpauseplayedchannel;
	

	@AndroidFindBy(xpath="//*[@text='PERSIAN']")
	public WebElement livetvpackageselected;
	

	@AndroidFindBy(xpath="//*[@text='ALL CHANNELS']")
	public WebElement livetvcategoryselected;
	
	
	@AndroidFindBy(id="com.jgo.go:id/tier2Itemimage")
	public List<WebElement> Channelplayedchannellist;
	
	
	
}
