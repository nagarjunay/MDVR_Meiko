/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class VehicleReports_TotalDistanceReport extends TestBase{
	
	public static final Logger log = Logger.getLogger(VehicleReports_TotalDistanceReport.class.getName());

	WebDriver driver;

	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;

	@FindBy(xpath = "//li[@id='lnk3']/a")
	WebElement vehiclereports;

	@FindBy(xpath = "//li[@id='lnk24']/a")
	WebElement general;

	@FindBy(xpath = "//*[@id='lnk34']/a/span")
	WebElement totaldistance;
	
	@FindBy(xpath = "//*[@id='pageassociated']/div/span[1]") 
	WebElement Pagination;
	
	@FindBy(xpath = "//button[@id='generateReport']") 
	WebElement generateReport;
	 
	@FindBy(css = "#s2id_autogen11")
	WebElement selectVehicle;
	
	@FindBy(css = "#select2-drop > ul > li:nth-child(2) > div")
	WebElement Meiko299;
	
	@FindBy(css = "#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div")
	WebElement Meiko300;
	

	
	public VehicleReports_TotalDistanceReport(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void TotalDistance() throws InterruptedException {
		
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon====>>" + hamburger);
		vehiclereports.click();
		log("Clicked on master id====>>" + vehiclereports + " and object is" + vehiclereports.toString());
		test.log(LogStatus.INFO, "Clicked on vehiclereports option====>>" + vehiclereports);
		general.click();
		log("Clicked on general id====>>" + general + " and object is" + general.toString());
		test.log(LogStatus.INFO, "Clicked on general option====>>" + general);
		totaldistance.click();
		log("Clicked on total distance id====>>" + totaldistance + " and object is" + totaldistance.toString());
		test.log(LogStatus.INFO, "Clicked on total distance option====>>" + totaldistance);

	}
	
	public void validation() {
		
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		String actual_error= driver.findElement(By.xpath("//*[@id='msgbody']/p")).getText();
	    String expected_error = "Select From Date Select To Date Select a Vehicle";
	    Assert.assertEquals(actual_error, expected_error);
	}

	public void FromData() {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtfrom').value='02/09/2019'");
		log("Entered from Date");
		test.log(LogStatus.INFO, "Entered from Date");
	}

	public void TODate() {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='02/09/2019'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
	}
	
	
	public void Drodown() throws Exception {
		
		selectVehicle.click();
		log("Clicked on selectVehicle dropdown====>>" + selectVehicle + " and object is" + selectVehicle.toString());
		test.log(LogStatus.INFO, "Clicked on selectVehicle dropdown====>>" + selectVehicle);
		Meiko299.click();
		log("Selected dropdownvalue id====>>" + Meiko299 + " and object is" + Meiko299.toString());
		test.log(LogStatus.INFO, "Selected dropdownvalue icon====>>" + Meiko299);
		Pagination.click();
		log("Clicked on Pagination id====>>" + Pagination + " and object is" + Pagination.toString());
		test.log(LogStatus.INFO, "Clicked on Pagination button====>>" + Pagination);
		//expliciteWait(generateReport, 10);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		
	}
	
	public void Verifying_TotalNum_Of_Col_Rows() throws Exception {
		List<WebElement> col = driver.findElements(By.xpath(
				"//table[@class='table table-striped table-hover table-coluredheader dataTable']/thead/tr/th[string-length(text()) > 0] "));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//tbody[@id='rptBody']/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);

	}

	public void log(String data) {
		
		log.info(data);
		Reporter.log(data);
	}


	
	

}
