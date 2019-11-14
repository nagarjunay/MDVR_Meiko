package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class LogoVerification extends TestBase {


	public WebDriver driver;

	public LogoVerification(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyLoginpageMeikologo() {

		log("Checking logo is present or not");
		test.log(LogStatus.INFO, "Checking logo is present or not");
		Boolean meikoLogo = driver.findElement(By.cssSelector("body > div.logo > img"))
				.isDisplayed();
		Assert.assertTrue(meikoLogo);
	}
	
	
	
	
	public void VerifyDashboardlogo() {

		log("Checking logo is present or not");
		test.log(LogStatus.INFO, "Checking logo is present or not");
		Boolean dashboardLogo = driver.findElement(By.cssSelector("body > div.logo > img"))
				.isDisplayed();
		Assert.assertTrue(dashboardLogo);
	}

}
