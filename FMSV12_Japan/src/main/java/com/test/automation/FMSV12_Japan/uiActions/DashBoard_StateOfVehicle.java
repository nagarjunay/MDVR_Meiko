package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class DashBoard_StateOfVehicle extends TestBase {

	public static final Logger log = Logger.getLogger(DashBoard_StateOfVehicle.class.getName());

	WebDriver driver;

	/* Moving State */
	@FindBy(xpath = "//*[@id='dm']")
	WebElement Moving;

	@FindBy(xpath = "//*[@id='ToolTables_tblReportData_0']")
	WebElement copyButton;

	@FindBy(xpath = "//*[@id='s2id_autogen11']/a/span[2]")
	WebElement RecordsPerPage_Dropdown;

	@FindBy(xpath = "//*[@id='rptHeader']/th[2]")
	WebElement RandomClick;

	@FindBy(xpath = "//*[@id='mainreportsection']/div[1]/div[3]/div[1]/a")
	WebElement Tools_Dropdown;

	@FindBy(xpath = "//*[@id='mainpage']/div[1]/div/div[1]")
	WebElement Moving_BackButton;

	/* Stopped State */
	@FindBy(xpath = "//*[@id='ds']")
	WebElement Stopped;

	/* Idle State */
	@FindBy(xpath = "//*[@id='di']")
	WebElement Idle;

	/* Inactive State */
	@FindBy(xpath = "//*[@id='dia']")
	WebElement Inactive;

	/* OutOfService State */
	@FindBy(xpath = "//*[@id='dio']")
	WebElement OutOfService;

	/* NotPolling State */
	@FindBy(xpath = "//*[@id='dip']")
	WebElement NotPolling;

	public DashBoard_StateOfVehicle(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Verifying_StateOfMoving() {
		
		Moving.click();
		log("Clicked on Moving Vehicle view detail arrow====>>" + Moving + " and object is" + Moving.toString());
		test.log(LogStatus.INFO, "Clicked on Moving Vehicle view detail arrow====>>" + Moving);
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='rptHeader']/th[string-length(text()) > 0]"));
		int colCount = col.size();
		log("Total Number of columns count in a Moving Vehicle table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a Moving Vehicle table==>" + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblReportData']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a Moving Vehicle table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a Moving Vehicle table==>" + rowCount);
	}

	public ArrayList<Object> verifyTools_dropdown() {
		
		// RandomClick.click();
		expliciteWait(Tools_Dropdown, 20);
		Tools_Dropdown.click();
		log("Clicked on Tools Dropdown ====>>" + Tools_Dropdown + " and object is" + Tools_Dropdown.toString());
		test.log(LogStatus.INFO, "Clicked on Tools Dropdown ====>>" + Tools_Dropdown);
		log("Verifying dropdown list in user profile");
		test.log(LogStatus.INFO, "Verifying dropdown list in Tools Dropdown");
		ArrayList<Object> values = dropdown("//*[@class='dropdown-menu pull-right']/li/a");
		return values;
	}

	public ArrayList<Object> verifyRecordesPerPage_dropdown() {
		
		expliciteWait(RecordsPerPage_Dropdown, 40);
		RecordsPerPage_Dropdown.click();
		log("Clicked on Records Per Page Dropdown ====>>" + RecordsPerPage_Dropdown + " and object is"
				+ RecordsPerPage_Dropdown.toString());
		test.log(LogStatus.INFO, "Clicked on Records Per Page Dropdown ====>>" + RecordsPerPage_Dropdown);
		log("Verifying dropdown list in Records Per Page Dropdown");
		test.log(LogStatus.INFO, "Verifying dropdown list in Records Per Page Dropdown");
		ArrayList<Object> values = dropdown("//*[@id='select2-drop']/ul/li");
		return values;
	}

	/*
	 * public void Verifying_Copybutton() {
	 * 
	 * Button.click(); log("Clicking on Copy button: " + Button);
	 * test.log(LogStatus.INFO, "Clicking on Copy button:==>" + Button);
	 * expliciteWait(Button, 60); Alert alert = driver.switchTo().alert(); String
	 * alertText = alert.getText(); System.out.println(); log("Alert data: " +
	 * alertText); test.log(LogStatus.INFO, "Alert data: " + alertText);
	 * alert.accept();
	 * 
	 * try { if (copyButton.isEnabled())
	 * log("Checking Copy button is enable or not: " + copyButton);
	 * test.log(LogStatus.INFO, "Checking Copy button is enable or not==>" +
	 * copyButton); { copyButton.click(); log("Clicking on Copy button: " +
	 * copyButton); test.log(LogStatus.INFO, "Clicking on Copy button:==>" +
	 * copyButton);
	 * 
	 * } } catch (UnhandledAlertException f) { try { Alert alert =
	 * driver.switchTo().alert(); String alertText = alert.getText();
	 * System.out.println(); log("Alert data: " + alertText);
	 * test.log(LogStatus.INFO, "Alert data: " + alertText); alert.accept(); } catch
	 * (NoAlertPresentException e) { e.printStackTrace(); } } }
	 */

	public void log(String data) {
		
		log.info(data);
		Reporter.log(data);
	}

}
