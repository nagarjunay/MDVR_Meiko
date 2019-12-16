/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

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

/**
 * @author nagarjuna
 *
 */
public class VehicleReports_AlertExpectionSummary extends TestBase {

	
	WebDriver driver;
	DatePicker datepicker;

	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;
	
	@FindBy(xpath = "//li[@id='lnk3']/a")
	WebElement vehiclereports;

	@FindBy(css = "#lnk28 > a")
	WebElement alertException;

	@FindBy(css = "#lnk93 > a > span")
	WebElement alertExceptionSummary;

	@FindBy(xpath = "//*[@id='pageassociated']/div/span[1]") 
	WebElement Pagination;
	
	@FindBy(xpath = "//button[@id='generateReport']") 
	WebElement generateReport;
	 
	@FindBy(css = "#s2id_lstVehicle > ul > li")
	WebElement selectVehicle;
	
	@FindBy(css = "#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div")
	WebElement Meiko299;
	
	@FindBy(css = "#select2-drop > ul > li:nth-child(2) > div")
	WebElement Meiko300;
	
	@FindBy(css="#msgbody > p")
	WebElement validationMessage;
	
	@FindBy(css="#ClickToClose")
	WebElement validationPopupClose;

	
	public VehicleReports_AlertExpectionSummary(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void AlertExceptionSummary() throws InterruptedException {
		
		expliciteWait(hamburger, 20, driver);
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon" );
		expliciteWait(vehiclereports, 20, driver);
		vehiclereports.click();
		log("Clicked on Vehicle Reorts id====>>" + vehiclereports + " and object is" + vehiclereports.toString());
		test.log(LogStatus.INFO, "Clicked on vehicle reports option");
		expliciteWait(alertException, 20, driver);
		alertException.click();
		log("Clicked on Alert Exception id====>>" + alertException + " and object is" + alertException.toString());
		test.log(LogStatus.INFO, "Clicked on Alert Exception option");
		expliciteWait(alertExceptionSummary, 40, driver);
		alertExceptionSummary.click();
		log("Clicked on Alert Exception Summary id====>>" + alertExceptionSummary + " and object is" + alertExceptionSummary.toString());
		test.log(LogStatus.INFO, "Clicked on Alert Exception Summary option");
		log("Parent Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Parent Window Title: " + driver.getTitle());

	}
	
	public void validation() {
		
		expliciteWait(generateReport, 20, driver);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 40, driver);
		String actual_error= validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
	    /*String expected_error = "日付から選択 現在まで選択 車両番号を選択";
	    Assert.assertEquals(actual_error, expected_error);*/
		validationPopupClose.click();
	}

	public void validation1() {

		datepicker = new DatePicker(driver);
		datepicker.VideostatusFromData();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = generateReport;
			ele.click();
		}
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 30, driver);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}

	public void validation2() {

		datepicker.VideostatusFromData();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='05/09/2019 00:00'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = generateReport;
			ele.click();
		}
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 30, driver);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}

	public void validation3() {

		datepicker.VideostatusFromData();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='01/09/2019 00:00'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = generateReport;
			ele.click();
		}
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		expliciteWait(validationMessage, 30, driver);
		String actual_error = validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
		validationPopupClose.click();
	}

	
	
	public void Vehicle_Dropdown() throws Exception {
		
		WebElement ele = driver.findElement(By.cssSelector("input[id='s2id_autogen11'][ class='select2-input select2-default']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		/*expliciteWait(selectVehicle, 20);
		selectVehicle.click();*/
		/*WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("static")));
		if (invisiable) {
			WebElement ele = driver.findElement(By.xpath("//div[@id='s2id_lstVehicle']/a/span[1]"));
			ele.click();
		}*/
		log("Clicked on selectVehicle dropdown====>>" + selectVehicle + " and object is" + selectVehicle.toString());
		test.log(LogStatus.INFO, "Clicked on select Vehicle dropdown");
		Meiko299.click();
		log("Selected dropdown value id====>>" + Meiko299 + " and object is" + Meiko299.toString());
		test.log(LogStatus.INFO, "Selected vehicle from dropdown");
		expliciteWait(generateReport, 20, driver);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		Thread.sleep(3000);
		
	}
	
	
	public void log(String data) {
		
		log.info(data);
		Reporter.log(data);
	}
	
	
	
	
	
}
