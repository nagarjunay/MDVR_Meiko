/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

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
public class DashBoard_ManagementDashboards extends TestBase {


	public WebDriver driver;

	@FindBy(xpath = "//*[@id='recentalertsportlet']/div[1]/div[1]/span")
	WebElement Recentalerts_Text;
	
	@FindBy(xpath = "//*[@id='currentfleetportlet']/div[1]/div[1]/span")
	WebElement Currentfleet_Text;
	
	

	
	
	public DashBoard_ManagementDashboards(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Mouse_over() {

		log("Performing mouse over on Management Dashboard dropdown");
		test.log(LogStatus.INFO, "Performing mouse over on Management Dashboard dropdown");
		mouse_movement(driver, "//*[@id='mainpage']/div[1]/div/ul/li[1]/button/span");
	}

	public void Management_CheckBox() {
		WebElement Checkbox = driver
				.findElement(By.cssSelector("#mdashboards > label:nth-child(1) > div > span > input[type=checkbox]"));
		if (!Checkbox.isSelected()) {
			Checkbox.click();
		} else {
			log("Checkbox is checked: " + Checkbox.isSelected());
			test.log(LogStatus.INFO, "Checkbox is checked: " + Checkbox.isSelected());
		}

	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
