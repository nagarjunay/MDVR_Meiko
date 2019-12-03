package com.test.automation.FMSV12_Japan.uiActions;

import java.util.Iterator;

/**
 * @author nagarjuna
 *
 */

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class VehicleReports_ActivityReport extends TestBase {

	WebDriver driver;

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
	
	@FindBy(css="#rptBody > tr > td:nth-child(5) > a")
	WebElement violation_overSpeedSummary;
	
	@FindBy(css="#rptBody > tr > td:nth-child(7) > a")
	WebElement violation_harshBreak;

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
		test.log(LogStatus.INFO, "Clicked on general option" );
		expliciteWait(activity, 20);
		activity.click();
		log("Clicked on activity id====>>" + activity + " and object is" + activity.toString());
		test.log(LogStatus.INFO, "Clicked on activity option");

	}

	public void validation() {

		log("Parent Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Parent Window Title: " + driver.getTitle());
		expliciteWait(generateReport, 40);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		/*
		 * String expected_error = "Select From Date Select To Date Select a Vehicle";
		 * Assert.assertEquals(actual_error, expected_error);
		 */
		validationPopupClose.click();
	}
	
	public void validation1() {

		FromData();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("static")));
		if (invisiable) {
			WebElement ele = generateReport;
			ele.click();
		}
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}
	
	public void validation2() {

		FromData();
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
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}
	
	public void validation3() {

		FromData();
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
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		expliciteWait(validationMessage, 30);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
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

	/*
	 * public void sikuli() throws SikuliException { Screen screen = new Screen();
	 * // Create object of Pattern class and specify the images path Pattern image1
	 * = new Pattern(
	 * "C:/Users/nagarjuna/git/MDVR_Meiko/FMSV12_Japan/Images/SelectVehicle.png");
	 * screen.click(image1); log("Clicked on select Vehicle dropdow" );
	 * test.log(LogStatus.INFO, "Clicked on select Vehicle dropdown"); }
	 */

	public void Drodown() throws Exception {

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

	public void Verifying_TotalNum_Of_Col_Rows() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,450)");
		log("Scrolling page");
		test.log(LogStatus.INFO, "Scrolling page");
		List<WebElement> col = driver.findElements(By.xpath(
				"//table[@class='table table-striped table-hover table-coluredheader dataTable']/thead/tr/th[string-length(text()) > 0] "));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		Thread.sleep(3000);
		List<WebElement> row = driver.findElements(By.cssSelector("#rptBody > tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);

	}

	public void alertCount() throws Exception {

		expliciteWait(AlertCount, 40);
		AlertCount.click();
		log("Clicked on Alert count hyper link");
		test.log(LogStatus.INFO, "Clicked on Alert count hyper link");
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ids = windows.iterator();
		String ParentId = ids.next();
		String ChildId = ids.next();
		log("Switching to Child Window: " + ChildId);
		test.log(LogStatus.INFO, "Switching to Child Window: " + ChildId);
		driver.switchTo().window(ChildId);
		log("Child Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Child Window Title: " + driver.getTitle());
		Thread.sleep(2000);

	}

	public void violationCount() throws Exception {

		expliciteWait(AlertCount, 40);
		ViolationCount.click();
		log("Clicked on Violation count hyper link");
		test.log(LogStatus.INFO, "Clicked on Violation count hyper link");
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ids = windows.iterator();
		String ParentId = ids.next();
		String ChildId = ids.next();
		log("Switching to Child Window: " + ChildId);
		test.log(LogStatus.INFO, "Switching to Child Window: " + ChildId);
		driver.switchTo().window(ChildId);
		log("Child Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Child Window Title: " + driver.getTitle());
		Thread.sleep(2000);

	}
	
	public void overSpeedSummary() throws Exception {
		expliciteWait(violation_overSpeedSummary, 40);
		violation_overSpeedSummary.click();
		log("Clicked on Over Speed Summary count hyper link");
		test.log(LogStatus.INFO, "Clicked on Over Speed Summary count hyper link");
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
		Thread.sleep(2000);
		
	}
	
	public void harshBreak() throws Exception {
		
		expliciteWait(violation_harshBreak, 40);
		violation_harshBreak.click();
		log("Clicked on Harsh Break count hyper link");
		test.log(LogStatus.INFO, "Clicked on Harsh Break count hyper link");
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
		Thread.sleep(2000);
	}

	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
