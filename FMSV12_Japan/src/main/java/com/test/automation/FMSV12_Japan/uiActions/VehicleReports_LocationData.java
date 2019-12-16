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
public class VehicleReports_LocationData extends TestBase {

	
	WebDriver driver;
	DatePicker datepicker;

	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;

	@FindBy(xpath = "//li[@id='lnk3']/a")
	WebElement vehiclereports;

	@FindBy(xpath = "//li[@id='lnk24']/a")
	WebElement general;

	@FindBy(css = "#lnk37 > a > span")
	WebElement locationData;
	
	@FindBy(xpath = "//*[@id='pageassociated']/div/span[1]") 
	WebElement Pagination;
	
	@FindBy(xpath = "//button[@id='generateReport']") 
	WebElement generateReport;
	 
	@FindBy(css = "input[id='s2id_autogen11'][ class='select2-input select2-default']")
	WebElement selectVehicle;
	
	@FindBy(css = "#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div")
	WebElement Meiko299;
	
	@FindBy(css = "#select2-drop > ul > li:nth-child(2) > div")
	WebElement Meiko300;
	
	@FindBy(css="#msgbody > p")
	WebElement validationMessage;
	
	@FindBy(css="#ClickToClose")
	WebElement validationPopupClose;
	
	@FindBy(css="#rptBody > tr")
	WebElement totalNumofRows;
	

	
	public VehicleReports_LocationData(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void LocationData() throws InterruptedException {
		
		expliciteWait(hamburger, 20, driver);
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon" );
		expliciteWait(vehiclereports, 20, driver);
		vehiclereports.click();
		log("Clicked on master id====>>" + vehiclereports + " and object is" + vehiclereports.toString());
		test.log(LogStatus.INFO, "Clicked on vehiclereports option" );
		expliciteWait(general, 20,driver);
		general.click();
		log("Clicked on general id====>>" + general + " and object is" + general.toString());
		test.log(LogStatus.INFO, "Clicked on general option");
		expliciteWait(locationData, 20, driver);
		locationData.click();
		log("Clicked on Location Data id====>>" + locationData + " and object is" + locationData.toString());
		test.log(LogStatus.INFO, "Clicked on Location Data option");
		log("Parent Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Parent Window Title: " + driver.getTitle());
	}
	
	public void validation() {
		
		expliciteWait(generateReport, 20, driver);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		expliciteWait(validationMessage, 20, driver);
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
		

		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = driver.findElement(By.xpath("//div[@id='s2id_lstVehicle']/a/span[1]"));
			ele.click();
		}
		/*expliciteWait(selectVehicle, 40);
		selectVehicle.click();*/
		log("Clicked on selectVehicle dropdown====>>" + selectVehicle + " and object is" + selectVehicle.toString());
		test.log(LogStatus.INFO, "Clicked on selectVehicle dropdown" );
		expliciteWait(Meiko299, 30, driver);
		Meiko299.click();
		log("Selected dropdownvalue id====>>" + Meiko299 + " and object is" + Meiko299.toString());
		test.log(LogStatus.INFO, "Selected dropdownvalue icon" );
		Pagination.click();
		log("Clicked on Pagination id====>>" + Pagination + " and object is" + Pagination.toString());
		test.log(LogStatus.INFO, "Clicked on Pagination button" );
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
