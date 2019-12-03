/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import java.util.List;
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
	
	@FindBy(css="#msgbody > p")
	WebElement validationMessage;
	
	@FindBy(css="#ClickToClose")
	WebElement validationPopupClose;

	
	public VehicleReports_TotalDistanceReport(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void TotalDistance() throws InterruptedException {
		
		expliciteWait(hamburger, 20);
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon====>>" + hamburger);
		expliciteWait(vehiclereports, 20);
		vehiclereports.click();
		log("Clicked on master id====>>" + vehiclereports + " and object is" + vehiclereports.toString());
		test.log(LogStatus.INFO, "Clicked on vehiclereports option====>>" + vehiclereports);
		expliciteWait(general, 20);
		general.click();
		log("Clicked on general id====>>" + general + " and object is" + general.toString());
		test.log(LogStatus.INFO, "Clicked on general option====>>" + general);
		expliciteWait(totaldistance, 40);
		totaldistance.click();
		log("Clicked on total distance id====>>" + totaldistance + " and object is" + totaldistance.toString());
		test.log(LogStatus.INFO, "Clicked on total distance option====>>" + totaldistance);

	}
	
	public void validation() {
		
		expliciteWait(generateReport, 20);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		expliciteWait(validationMessage, 40);
		String actual_error= validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
	    /*String expected_error = "日付から選択 現在まで選択 車両番号を選択";
	    Assert.assertEquals(actual_error, expected_error);*/
		validationPopupClose.click();
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
		
		/*expliciteWait(selectVehicle, 40);
		selectVehicle.click();*/
		WebElement ele = driver.findElement(By.cssSelector("input[id='s2id_autogen11'][ class='select2-input select2-default']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		log("Clicked on selectVehicle dropdown====>>" + selectVehicle + " and object is" + selectVehicle.toString());
		test.log(LogStatus.INFO, "Clicked on selectVehicle dropdown====>>" + selectVehicle);
		Meiko299.click();
		log("Selected dropdownvalue id====>>" + Meiko299 + " and object is" + Meiko299.toString());
		test.log(LogStatus.INFO, "Selected dropdownvalue icon====>>" + Meiko299);
		Pagination.click();
		log("Clicked on Pagination id====>>" + Pagination + " and object is" + Pagination.toString());
		test.log(LogStatus.INFO, "Clicked on Pagination button====>>" + Pagination);
		expliciteWait(generateReport, 10);
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
		List<WebElement> row = driver.findElements(By.cssSelector("#rptBody > tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);

	}

	public void log(String data) {
		
		log.info(data);
		Reporter.log(data);
	}


	
	

}
