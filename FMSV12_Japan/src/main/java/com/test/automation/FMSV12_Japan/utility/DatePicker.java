/**
 * 
 */
package com.test.automation.FMSV12_Japan.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class DatePicker  extends TestBase{

	 WebDriver driver;

	public DatePicker(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FromData() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtfrom').value='02/09/2019'");
		log("Entered from Date");
		test.log(LogStatus.INFO, "Entered from Date");
	}

	public void TODate() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='02/09/2019'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
	}
	
	
	public void VideostatusFromData() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtfrom').value='02/09/2019 00:00'");
		log("Entered from Date");
		test.log(LogStatus.INFO, "Entered from Date");
	}

	public void VideostatusTODate() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='02/09/2019 23:59'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
	}
}
