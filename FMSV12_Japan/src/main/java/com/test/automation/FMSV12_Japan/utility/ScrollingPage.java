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
public class ScrollingPage extends TestBase{

	 WebDriver driver;

	public ScrollingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,450)");
		log("Scrolling page");
		test.log(LogStatus.INFO, "Scrolling page");
	}

	
	
}
