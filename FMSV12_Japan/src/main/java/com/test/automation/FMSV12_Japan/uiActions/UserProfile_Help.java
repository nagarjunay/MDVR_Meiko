/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class UserProfile_Help extends TestBase{
	
	
	public static final Logger log = Logger.getLogger(UserProfile_Help.class.getName());

	public WebDriver driver;

	
	
	@FindBy(xpath = "//div[@id='mdbody]/div/text()")
	WebElement helpcontent;
	
	public UserProfile_Help(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Mouse_over() {

		log("Performing mouse over on user profile dropdown");
		test.log(LogStatus.INFO, "Performing mouse over on user profile dropdown");
		mouse_movement(driver, "//li[@class='dropdown user']");
	}

	public ArrayList<Object> Click_Help() throws Exception {

		log("Clicking on Help from user profile dropdown");
		test.log(LogStatus.INFO, "Clicking on Help from user profile dropdown");
		ArrayList<Object> values = dropdown("//ul[@class='dropdown-menu']/li/a[string-length(text()) > 0]");
		if (values.contains(" ヘルプ")) {
			driver.findElement(By.xpath("//*[@id='Help']/span")).click();
		}
		return values;
	}
	
	public ArrayList<Object> ContantUs() throws Exception {

		log("Clicking on Contact Us from user profile dropdown");
		test.log(LogStatus.INFO, "Clicking on Contact Us from user profile dropdown");
		ArrayList<Object> values = dropdown("//ul[@class='dropdown-menu']/li/a[string-length(text()) > 0]");
		if (values.contains(" お問い合わせ")) {
			driver.findElement(By.xpath("//*[@id='About']/span")).click();
		}
		return values;
	}


	public void VerifyHelpHeader() {
		//expliciteWait(element, timeToWaitInSec);
		String actual_error = driver.findElement(By.cssSelector("#mdtitle")).getAttribute("innerHTML");
		log("Verifing help header title: " + actual_error);
		test.log(LogStatus.INFO, "Verifing help header text: " + actual_error);
		String expected_error = " ヘルプ";
		Assert.assertEquals(actual_error, expected_error);
	}


	public void VerifyContactUs() {
		String actual_error = driver.findElement(By.xpath("//*[@id='mdtitle']")).getAttribute("innerHTML");
		log("Verifing contact us popup window text: " + actual_error);
		test.log(LogStatus.INFO, "Verifing contact us popup window text: " + actual_error);
		String expected_error = " お問い合わせ";
		Assert.assertEquals(actual_error, expected_error);
	}


	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
