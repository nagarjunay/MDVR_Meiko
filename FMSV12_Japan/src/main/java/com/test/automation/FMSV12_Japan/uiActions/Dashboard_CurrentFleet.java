/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class Dashboard_CurrentFleet extends TestBase {

	public WebDriver driver;

	public Dashboard_CurrentFleet(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CurrentFleet_Piechat_Mouseover() {

		Actions actions = new Actions(driver);
		// Retrieve WebElement
		WebElement element = driver.findElement(By.cssSelector(
				"#highcharts-2 > svg > g.highcharts-series-group > g.highcharts-series.highcharts-tracker > path"));
		// Use action class to mouse hover
		log("Performing mouse over on current fleet window");
		test.log(LogStatus.INFO, "Performing mouse over on current fleet window");
		actions.moveToElement(element).perform();
		WebElement toolTip = driver
				.findElement(By.cssSelector("#highcharts-2 > svg > g.highcharts-tooltip > text > tspan"));
		WebElement toolTipCount = driver
				.findElement(By.cssSelector("#highcharts-2 > svg > g.highcharts-tooltip > text > tspan:nth-child(2)"));
		WebElement toolTippercentage = driver
				.findElement(By.cssSelector("#highcharts-2 > svg > g.highcharts-tooltip > text > tspan:nth-child(4)"));
		// To get the tool tip text and assert
		String toolTipText = toolTip.getText();
		log("Current fleet Tool Tip Text: " + toolTipText);
		test.log(LogStatus.INFO, "Current fleet Tool Tip Text: " + toolTipText);
		
		String tooltipcount= toolTipCount.getText();
		log("Current fleet Tool Tip " + tooltipcount);
		test.log(LogStatus.INFO, "Current fleet Tool Tip " + tooltipcount);
		
		String tooltippercent= toolTippercentage.getText();
		//#highcharts-2 > svg > g.highcharts-tooltip > text > tspan:nth-child(4)
		log("Current fleet Tool Tip Percentage: " + tooltippercent);
		test.log(LogStatus.INFO, "Current fleet Tool Tip Percentage: " + tooltippercent);
		
		
		
		

	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
