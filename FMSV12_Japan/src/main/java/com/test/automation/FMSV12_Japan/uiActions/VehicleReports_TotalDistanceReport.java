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
public class VehicleReports_TotalDistanceReport extends TestBase{
	
	WebDriver driver;
	DatePicker datepicker;

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
	
	@FindBy(css = "#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div")
	WebElement Meiko299;
	
	@FindBy(css = "#select2-drop > ul > li:nth-child(2) > div")
	WebElement Meiko300;
	
	@FindBy(css="#msgbody > p")
	WebElement validationMessage;
	
	@FindBy(css="#ClickToClose")
	WebElement validationPopupClose;

	
	public VehicleReports_TotalDistanceReport(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void TotalDistance() throws InterruptedException {
		
		expliciteWait(hamburger, 20, driver);
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon" );
		expliciteWait(vehiclereports, 20, driver);
		vehiclereports.click();
		log("Clicked on master id====>>" + vehiclereports + " and object is" + vehiclereports.toString());
		test.log(LogStatus.INFO, "Clicked on vehiclereports option" );
		expliciteWait(general, 20, driver);
		general.click();
		log("Clicked on general id====>>" + general + " and object is" + general.toString());
		test.log(LogStatus.INFO, "Clicked on general option" );
		expliciteWait(totaldistance, 40, driver);
		totaldistance.click();
		log("Clicked on total distance id====>>" + totaldistance + " and object is" + totaldistance.toString());
		test.log(LogStatus.INFO, "Clicked on total distance option" );
		log("Parent Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Parent Window Title: " + driver.getTitle());
	}
	
	public void validation() {
		
		expliciteWait(generateReport, 20, driver);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button" );
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
		datepicker.FromData();
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

		datepicker.FromData();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='05/09/2019'");
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

		datepicker.FromData();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='01/09/2019'");
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
		
		/*expliciteWait(selectVehicle, 40);
		selectVehicle.click();*/
		WebElement ele = driver.findElement(By.cssSelector("input[id='s2id_autogen11'][ class='select2-input select2-default']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		log("Clicked on selectVehicle dropdown====>>" + selectVehicle + " and object is" + selectVehicle.toString());
		test.log(LogStatus.INFO, "Clicked on selectVehicle dropdown");
		Meiko299.click();
		log("Selected dropdownvalue id====>>" + Meiko299 + " and object is" + Meiko299.toString());
		test.log(LogStatus.INFO, "Selected dropdownvalue ico");
		Pagination.click();
		log("Clicked on Pagination id====>>" + Pagination + " and object is" + Pagination.toString());
		test.log(LogStatus.INFO, "Clicked on Pagination button");
		expliciteWait(generateReport, 10, driver);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		
	}
	
	
	public void log(String data) {
		
		log.info(data);
		Reporter.log(data);
	}


	
	

}
