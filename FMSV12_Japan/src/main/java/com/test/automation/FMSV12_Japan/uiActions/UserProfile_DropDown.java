package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class UserProfile_DropDown extends TestBase {


	public WebDriver driver;

	public UserProfile_DropDown(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Mouse_over() {

		log("Performing mouse over on user profile dropdown");
		test.log(LogStatus.INFO, "Performing mouse over on user profile dropdown");
		mouse_movement(driver, "//li[@class='dropdown user']");
	}

	public void verify_drop_down() {

		log("Verifying dropdown list in user profile");
		test.log(LogStatus.INFO, "Verifying dropdown list in user profile");
		String dropdownList = driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[string-length(text()) > 0]")).getText();
		log("DropDown Contents: " + dropdownList);
		test.log(LogStatus.INFO, "DropDown Contents: " + dropdownList);
		/*String expected_error = "Current Password is wrong, Please Try again !!";
		Assert.assertEquals(dropdownList, expected_error);*/
		/*ArrayList<Object> values = dropdown("//ul[@class='dropdown-menu']/li/a[string-length(text()) > 0]");
		return values;*/
		
	}

	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
