package com.test.automation.FMSV12_Japan.uiActions;

import java.util.Iterator;

/**
 * @author nagarjuna
 *
 */

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.utility.DatePicker;

public class VehicleReports_ActivityReport extends TestBase {

	WebDriver driver;
	DatePicker datepicker;

	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;

	@FindBy(xpath = "//li[@id='lnk3']/a")
	WebElement vehiclereports;

	@FindBy(xpath = "//li[@id='lnk24']/a")
	WebElement general;

	@FindBy(xpath = "//li[@id='lnk30']/a")
	WebElement activity;

	@FindBy(xpath = "//*[@id='lnk31']/a/span")
	WebElement idle;

	@FindBy(xpath = "//*[@id='pageassociated']/div")
	WebElement Pagination;

	@FindBy(xpath = "//button[@id='generateReport']")
	WebElement generateReport;

	@FindBy(xpath = "//*[@id='s2id_lstVehicle']/a/span[1]")
	WebElement selectVehicle;

	@FindBy(css = "#select2-drop > ul > li:nth-child(1) > div")
	WebElement Meiko299;

	@FindBy(css = "#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div > span")
	WebElement Meiko300;

	@FindBy(css = "#msgbody > p")
	WebElement validationMessage;

	@FindBy(css = "#ClickToClose")
	WebElement validationPopupClose;

	@FindBy(css = "#rptSummaryV1 > tr:nth-child(6) > td:nth-child(2) > a")
	WebElement AlertCount;

	@FindBy(css = "#rptSummaryV1 > tr:nth-child(6) > td:nth-child(4) > a")
	WebElement ViolationCount;

	@FindBy(css = "#rptBody > tr > td:nth-child(5) > a")
	WebElement violation_overSpeedSummary;

	@FindBy(css = "#rptBody > tr > td:nth-child(7) > a")
	WebElement violation_harshBreak;

	@FindBy(css = "#rptBody > tr > td:nth-child(8) > a")
	WebElement violation_harshAcceleration;

	@FindBy(css = "#rptBody > tr > td:nth-child(9) > a")
	WebElement violation_UnauthorizedStop;

	@FindBy(css = "#rptBody > tr > td:nth-child(10) > a")
	WebElement violation_UnauthorizedRoad;

	@FindBy(css = "#rptBody > tr > td:nth-child(12) > a")
	WebElement violation_IdleReport;

	@FindBy(css = "#rptBody > tr > td:nth-child(13) > a")
	WebElement violation_DynamicTripSummaryReport;

	@FindBy(css = "#rptBody > tr > td:nth-child(14) > a")
	WebElement violation_WorkandDriveHourReport;

	public VehicleReports_ActivityReport(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Activity() throws InterruptedException {

		log("Dashboard Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Dashboard Window Title: " + driver.getTitle());
		expliciteWait(hamburger, 20);
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon");
		expliciteWait(vehiclereports, 20);
		vehiclereports.click();
		log("Clicked on master id====>>" + vehiclereports + " and object is" + vehiclereports.toString());
		test.log(LogStatus.INFO, "Clicked on vehiclereports option");
		expliciteWait(general, 20);
		general.click();
		log("Clicked on general id====>>" + general + " and object is" + general.toString());
		test.log(LogStatus.INFO, "Clicked on general option");
		expliciteWait(activity, 20);
		activity.click();
		log("Clicked on activity id====>>" + activity + " and object is" + activity.toString());
		test.log(LogStatus.INFO, "Clicked on activity option");
		log("Parent Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Parent Window Title: " + driver.getTitle());

	}

	public void validation() {

		expliciteWait(generateReport, 40);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying validation messages without entering details(From Date, TO Date, Select Vehicle) : "
				+ actual_error);
		test.log(LogStatus.INFO,
				"Verifying validation messages without entering details(From Date, TO Date, Select Vehicle) : "
						+ actual_error);
		/*
		 * String expected_error = "Select From Date Select To Date Select a Vehicle";
		 * Assert.assertEquals(actual_error, expected_error);
		 */
		validationPopupClose.click();
	}

	public void validation1() {

		datepicker = new DatePicker(driver);
		datepicker.FromData();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("static")));
		if (invisiable) {
			WebElement ele = generateReport;
			ele.click();
		}
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}

	public void validation2() {

		datepicker.FromData();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='05/09/2019'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("static")));
		if (invisiable) {
			WebElement ele = generateReport;
			ele.click();
		}
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}

	public void validation3() {

		datepicker.FromData();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='01/09/2019'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("static")));
		if (invisiable) {
			WebElement ele = generateReport;
			ele.click();
		}
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}

	
	public void VehicleDropdown() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("static")));
		if (invisiable) {
			WebElement ele = driver.findElement(By.xpath("//div[@id='s2id_lstVehicle']/a/span[1]"));
			ele.click();
		}
		log("Clicked on select Vehicle dropdow");
		test.log(LogStatus.INFO, "Clicked on select Vehicle dropdown");
		Meiko299.click();
		log("Selected Vehicle from vehicle dropdown====>>" + Meiko299 + " and object is" + Meiko299.toString());
		test.log(LogStatus.INFO, "Selected Vehicle from vehicle dropdown");
		Pagination.click();
		log("Clicked on Pagination id====>>" + Pagination + " and object is" + Pagination.toString());
		test.log(LogStatus.INFO, "Clicked on Pagination button");
		expliciteWait(generateReport, 10);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");

	}

	
	public void alertCount() throws Exception {

		expliciteWait(AlertCount, 40);
		AlertCount.click();
		log("Clicked on Alert count hyper link");
		test.log(LogStatus.INFO, "Clicked on Alert count hyper link");
		switching2Tabs();
		Thread.sleep(2000);

	}

	public void violationCount() throws Exception {

		expliciteWait(AlertCount, 40);
		ViolationCount.click();
		log("Clicked on Violation count hyper link");
		test.log(LogStatus.INFO, "Clicked on Violation count hyper link");
		switching2Tabs();
		Thread.sleep(2000);

	}

	public void overSpeedSummary() throws Exception {
		expliciteWait(violation_overSpeedSummary, 40);
		violation_overSpeedSummary.click();
		log("Clicked on Over Speed Summary Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Over Speed Summary Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);

	}

	public void harshBreak() throws Exception {

		expliciteWait(violation_harshBreak, 40);
		violation_harshBreak.click();
		log("Clicked on Harsh Break Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Harsh Break Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);
	}

	public void harshAcceleration() throws Exception {

		expliciteWait(violation_harshAcceleration, 30);
		violation_harshAcceleration.click();
		log("Clicked on Harsh Acceleration Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Harsh Acceleration Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);
	}

	public void UnauthorizedStop() throws Exception {

		expliciteWait(violation_UnauthorizedStop, 30);
		violation_UnauthorizedStop.click();
		log("Clicked on Unauthorized Stop Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Unauthorized Stop Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);
	}

	public void UnauthorizedRoad() throws Exception {

		expliciteWait(violation_UnauthorizedRoad, 30);
		violation_UnauthorizedRoad.click();
		log("Clicked on Unauthorized Road Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Unauthorized Road Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);
	}

	public void IdleReport() throws Exception {

		expliciteWait(violation_IdleReport, 30);
		violation_IdleReport.click();
		log("Clicked on Idle Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Idle Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);
	}

	public void DynamicTripSummaryReport() throws Exception {

		expliciteWait(violation_DynamicTripSummaryReport, 30);
		violation_DynamicTripSummaryReport.click();
		log("Clicked on Dynamic Trip Summary Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Dynamic Trip Summary Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);

	}

	public void WorkandDriveHourReport() throws Exception {

		expliciteWait(violation_WorkandDriveHourReport, 30);
		violation_WorkandDriveHourReport.click();
		log("Clicked on Work and Drive Hour Report hyper link");
		test.log(LogStatus.INFO, "Clicked on Work and Drive Hour Report hyper link");
		switching3Tabs();
		Thread.sleep(2000);
	}

	
	
	public void switching2Tabs() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ids = windows.iterator();
		String ParentId = ids.next();
		String ChildId = ids.next();
		log("Switching to Child Window: " + ChildId);
		test.log(LogStatus.INFO, "Switching to Child Window: " + ChildId);
		driver.switchTo().window(ChildId);
		log("Child Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Child Window Title: " + driver.getTitle());
	}

	public void switching3Tabs() {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ids = windows.iterator();
		String ParentId = ids.next();
		String ChildId = ids.next();
		String SubChildId = ids.next();
		log("Switching to Sub Child Window: " + SubChildId);
		test.log(LogStatus.INFO, "Switching to Sub Child Window: " + SubChildId);
		driver.switchTo().window(SubChildId);
		log("Sub Child Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Sub Child Window Title: " + driver.getTitle());
	}

	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
