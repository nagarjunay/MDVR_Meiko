package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class UserProfile_ChangePassword extends TestBase {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id='currentpassword']")
	WebElement CurrentPassword;

	@FindBy(xpath = "//*[@id='newpassword']")
	WebElement NewPassword;

	@FindBy(xpath = "//*[@id='confirmpassword']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//*[@id='ChangePassword']/div/div/div[3]/button[2]")
	WebElement ChangeButton;

	@FindBy(xpath = "//*[@id='ChangePassword']/div/div/div[3]/button[1]")
	WebElement CancelButton;

	@FindBy(xpath = "//*[@id='hdResultChangePassword']/div")
	WebElement ValidationMessage;
	

	public UserProfile_ChangePassword(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Mouse_over() {

		log("Performing mouse over on user profile dropdown");
		test.log(LogStatus.INFO, "Performing mouse over on user profile dropdown");
		mouse_movement(driver, "//li[@class='dropdown user']");
	}

	public void click_ChangePassword()  {

		log("Clicking on Change password from user profile dropdown");
		test.log(LogStatus.INFO, "Clicking on Change password from user profile dropdown");
		
		driver.findElement(By.xpath("//a[@href='#ChangePassword']")).click();
			
	}

	public void VerifyChangePassword_Validation(String Currentpassword, String Newpassword, String Confirmpassword)
			throws Exception {
		expliciteWait(CurrentPassword, 60, driver);
		CurrentPassword.clear();
		CurrentPassword.sendKeys(Currentpassword);
		log("Entered Current Password is====>>" + Currentpassword);
		test.log(LogStatus.INFO, "Entered Current Password is====>>" + Currentpassword);
		NewPassword.clear();
		NewPassword.sendKeys(Newpassword);
		log("Entered New Password is====>>" + Newpassword);
		test.log(LogStatus.INFO, "Entered New Password is====>>" + Newpassword);
		ConfirmPassword.clear();
		ConfirmPassword.sendKeys(Confirmpassword);
		log("Entered Confirm Password is====>>" + Confirmpassword);
		test.log(LogStatus.INFO, "Entered Confirm Password is====>>" + Confirmpassword);
		try {
			ChangeButton.click();
			log("Clicked on Change Button");
			test.log(LogStatus.INFO, "Clicked on Change Button");	
		/*} catch (UnhandledAlertException f) {
			try {*/
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				log("Alert data: " + alertText);
				test.log(LogStatus.INFO, "Alert data: " + alertText);
				alert.accept();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}

	/*}*/

	public void VerifyValidationMessage() {
		String actual_error = driver.findElement(By.cssSelector("#hdResultChangePassword > div")).getText();
		log("Validation Message: " + actual_error);
		test.log(LogStatus.INFO, "Validation Message: " + actual_error);
		String expected_error = "Current Password is wrong, Please Try again !!";
		Assert.assertEquals(actual_error, expected_error);
	}

	public void VerifyValidationMessage1() {
		String actual_error = driver.findElement(By.cssSelector("#hdResultChangePassword > div")).getText();
		String expected_error = " Password updated successfully";
		Assert.assertEquals(actual_error, expected_error);
	}

	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
