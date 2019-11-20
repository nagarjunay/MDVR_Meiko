/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class DashBoard_RecentAlerts extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(css="#recentalertsportlet > div.portlet-title > div.caption > span")
	WebElement RecentAlerts;
	
	@FindBy(css="#recentalertsportlet > div.portlet-body > div.scroller-footer > div > a > span")
	WebElement RecentAlerts_HyperLink;
	
	
	public DashBoard_RecentAlerts(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void RecentAlertsWindow() {

		String actual_error = RecentAlerts.getAttribute("innerHTML");
		String expected_error = "最近アラート";
	    Assert.assertEquals(actual_error, expected_error);
	    log("Verify Recent Alerts Window Text: " + actual_error);
		test.log(LogStatus.INFO, "Verify Recent Alerts Window Text: " + actual_error);
		RecentAlerts_HyperLink.click();
		log("Clicked See All Alerts Hyperlink");
		test.log(LogStatus.INFO, "Clicked See All Alerts Hyperlink" );
	}	
}
