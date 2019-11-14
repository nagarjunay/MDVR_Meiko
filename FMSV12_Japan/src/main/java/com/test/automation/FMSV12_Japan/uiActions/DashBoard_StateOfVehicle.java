package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class DashBoard_StateOfVehicle extends TestBase {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='ToolTables_tblReportData_0']")
	WebElement copyButton;

	@FindBy(xpath = "//*[@id='s2id_autogen11']/a/span[2]")
	WebElement RecordsPerPage_Dropdown;
	
	@FindBy(xpath = "//*[@id='s2id_autogen13']")
	WebElement RecordsPerPage_Dropdown1;
	

	@FindBy(xpath = "//*[@id='rptHeader']/th[2]")
	WebElement RandomClick;

	@FindBy(xpath = "//*[@id='mainreportsection']/div[1]/div[3]/div[1]/a")
	WebElement Tools_Dropdown;

		
	@FindBy(xpath = "//*[@id='mainpage']/div[1]/div/div[1]")
	WebElement Moving_BackButton;
	
	@FindBy(css = "#mainreportsection > div.portlet-title > div.actions > div.btn-group.open > a")
	WebElement Columns_Dropdown;
	
	/* Moving State */
	@FindBy(xpath = "//*[@id='dm']")
	WebElement Moving;
	
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

	public void Verifying_StateOfMovingVehicles() {

		Moving.click();
		log("Clicked on Moving Vehicles view detail arrow====>>" + Moving + " and object is" + Moving.toString());
		test.log(LogStatus.INFO, "Clicked on Moving Vehicles view detail arrow====>>" + Moving);
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='rptHeader']/th[string-length(text()) > 0]"));
		int colCount = col.size();
		log("Total Number of columns count in a Moving Vehicles table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a Moving Vehicles table: " + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblReportData']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a Moving Vehicles table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a Moving Vehicles table: " + rowCount);
	}
	
	public void Verifying_StateOfStoppedVehicles() {

		Stopped.click();
		log("Clicked on Stopped Vehicles view detail arrow====>>" + Stopped + " and object is" + Stopped.toString());
		test.log(LogStatus.INFO, "Clicked on Stopped Vehicles view detail arrow====>>" + Stopped);
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='rptHeader']/th[string-length(text()) > 0]"));
		int colCount = col.size();
		log("Total Number of columns count in a Stopped Vehicles table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a Stopped Vehicles table: " + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblReportData']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a Stopped Vehicles table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a Stopped Vehicles table: " + rowCount);
	}
	
	public void Verifying_StateOfIdleVehicles() {

		Idle.click();
		log("Clicked on Idle Vehicles view detail arrow====>>" + Idle + " and object is" + Idle.toString());
		test.log(LogStatus.INFO, "Clicked on Idle Vehicles view detail arrow====>>" + Idle);
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='rptHeader']/th[string-length(text()) > 0]"));
		int colCount = col.size();
		log("Total Number of columns count in a Idle Vehicles table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a Idle Vehicles table: " + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblReportData']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a Idle Vehicles table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a Idle Vehicles table: " + rowCount);
	}

	
	public void Verifying_StateOfInactiveVehicles() {

		Inactive.click();
		log("Clicked on Inactive Vehicles view detail arrow====>>" + Inactive + " and object is" + Inactive.toString());
		test.log(LogStatus.INFO, "Clicked on Inactive Vehicles view detail arrow====>>" + Inactive);
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='rptHeader']/th[string-length(text()) > 0]"));
		int colCount = col.size();
		log("Total Number of columns count in a Inactive Vehicles table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a Inactive Vehicles table: " + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblReportData']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a Inactive Vehicles table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a Inactive Vehicles table: " + rowCount);
	}
	
	
	public void Verifying_StateOfNotPollingVehicles() {

		NotPolling.click();
		log("Clicked on Not Polling Vehicles view detail arrow====>>" + NotPolling + " and object is" + NotPolling.toString());
		test.log(LogStatus.INFO, "Clicked on Not Polling Vehicles view detail arrow====>>" + NotPolling);
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='rptHeader']/th[string-length(text()) > 0]"));
		int colCount = col.size();
		log("Total Number of columns count in a Not Polling Vehicles table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a Not Polling Vehicles table: " + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblReportData']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a Not Polling Vehicles table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a Not Polling Vehicles table: " + rowCount);
	}
	
	public void Verifying_StateOfOutOfServiceVehicles() {

		OutOfService.click();
		log("Clicked on Out Of Service Vehicles view detail arrow====>>" + OutOfService + " and object is" + OutOfService.toString());
		test.log(LogStatus.INFO, "Clicked on Out Of Service Vehicles view detail arrow====>>" + OutOfService);
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='rptHeader']/th[string-length(text()) > 0]"));
		int colCount = col.size();
		log("Total Number of columns count in a Out Of Service Vehicles table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a Out Of Service Vehicles table: " + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblReportData']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a Out Of Service Vehicles table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a Out Of Service Vehicles table: " + rowCount);
	}
	
	public ArrayList<Object> verifyTools_dropdown() {

		// RandomClick.click();
		expliciteWait(Tools_Dropdown, 30);
		Tools_Dropdown.click();
		log("Clicked on Tools Dropdown ====>>" + Tools_Dropdown + " and object is" + Tools_Dropdown.toString());
		test.log(LogStatus.INFO, "Clicked on Tools Dropdown ====>>" + Tools_Dropdown);
		log("Verifying Tools dropdown");
		test.log(LogStatus.INFO, "Verifying Tools dropdown");
		ArrayList<Object> values = dropdown("//*[@class='dropdown-menu pull-right']/li/a");
		return values;
	}

	public ArrayList<Object> verifyRecordesPerPage_dropdown() {

		expliciteWait(RecordsPerPage_Dropdown, 20);
		RecordsPerPage_Dropdown.click();
		log("Clicked on Records Per Page Dropdown ====>>" + RecordsPerPage_Dropdown + " and object is"
				+ RecordsPerPage_Dropdown.toString());
		test.log(LogStatus.INFO, "Clicked on Records Per Page Dropdown ====>>" + RecordsPerPage_Dropdown);
		log("Verifying dropdown list in Records Per Page Dropdown");
		test.log(LogStatus.INFO, "Verifying dropdown list in Records Per Page Dropdown");
		ArrayList<Object> values = dropdown("//*[@id='select2-drop']/ul/li");
		return values;
	}

	
		
	public ArrayList<Object> verifyCloumns_Dropdown() {

		expliciteWait(Columns_Dropdown, 30);
		Columns_Dropdown.click();
		log("Clicked on Columns Dropdown ====>>" + Columns_Dropdown + " and object is"
				+ Columns_Dropdown.toString());
		test.log(LogStatus.INFO, "Clicked on Columns Dropdown ====>>" + Columns_Dropdown);
		log("Verifying Columns Dropdown List");
		test.log(LogStatus.INFO, "Verifying Columns Dropdown List");
		ArrayList<Object> values = dropdown("//*[@id='tblReportData_column_toggler']/label");
		return values;
	}
	
	/*public void Verifying_Copybutton() {

		copyButton.click();
		log("Clicking on Copy button: " + copyButton);
		test.log(LogStatus.INFO, "Clicking on Copy button:==>" + copyButton);
		expliciteWait(copyButton, 60);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println();
		log("Alert data: " + alertText);
		test.log(LogStatus.INFO, "Alert data: " + alertText);
		alert.accept();
		try {
			if (copyButton.isEnabled())
				log("Checking Copy button is enable or not: " + copyButton);
			test.log(LogStatus.INFO, "Checking Copy button is enable or not==>" + copyButton);
			{
				copyButton.click();
				log("Clicking on Copy button: " + copyButton);
				test.log(LogStatus.INFO, "Clicking on Copy button:==>" + copyButton);
			}
		} catch (UnhandledAlertException f) {
			try {
				Alert alert1 = driver.switchTo().alert();
				String alertText1 = alert.getText();
				System.out.println();
				log("Alert data: " + alertText1);
				test.log(LogStatus.INFO, "Alert data: " + alertText1);
				alert1.accept();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
	}*/

	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
