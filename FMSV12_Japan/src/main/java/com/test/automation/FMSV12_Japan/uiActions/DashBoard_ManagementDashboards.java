/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class DashBoard_ManagementDashboards extends TestBase{
	
	
	public static final Logger log = Logger.getLogger(DashBoard_ManagementDashboards.class.getName());

	public WebDriver driver;

	@FindBy(xpath = "//*[@id='currentpassword']")
	WebElement CurrentPassword;


	public DashBoard_ManagementDashboards(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Mouse_over() {

		log("Performing mouse over on user profile dropdown");
		test.log(LogStatus.INFO, "Performing mouse over on user profile dropdown");
		mouse_movement(driver, "//*[@id='mainpage']/div[1]/div/ul/li[1]/button/span");
	}
	
	public void Management_CheckBox() {
		WebElement Checkbox = driver.findElement(By.cssSelector("#mdashboards > label:nth-child(1) > div > span > input[type=checkbox]"));
		if (Checkbox.isEnabled()) {
			Checkbox.click();
		} else {
			System.out.println("Checked 'Remember Me' checkbox as it is unchecked.");
		}
		log("Checked 'Remember Me' checkbox as it is unchecked" + Checkbox.toString());
		test.log(LogStatus.INFO, "Checked 'Remember Me' checkbox as it is unchecked" + Checkbox.toString());
		//return LoginPage;
	}

	
	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
