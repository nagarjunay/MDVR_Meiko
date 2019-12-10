/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class VehicleReports_IdleReport extends TestBase {
	
	WebDriver driver;

	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;

	@FindBy(xpath = "//li[@id='lnk3']/a")
	WebElement vehiclereports;

	@FindBy(xpath = "//li[@id='lnk24']/a")
	WebElement general;

	@FindBy(xpath = "//*[@id='lnk31']/a/span")
	WebElement idle;
	
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
	

	
	public VehicleReports_IdleReport(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void Idle() throws InterruptedException {
		
		expliciteWait(hamburger, 20);
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon" );
		expliciteWait(vehiclereports, 20);
		vehiclereports.click();
		log("Clicked on master id====>>" + vehiclereports + " and object is" + vehiclereports.toString());
		test.log(LogStatus.INFO, "Clicked on vehiclereports option" );
		expliciteWait(general, 20);
		general.click();
		log("Clicked on general id====>>" + general + " and object is" + general.toString());
		test.log(LogStatus.INFO, "Clicked on general option");
		expliciteWait(idle, 20);
		idle.click();
		log("Clicked on idle id====>>" + idle + " and object is" + idle.toString());
		test.log(LogStatus.INFO, "Clicked on idle option");

	}
	
	public void validation() {
		
		expliciteWait(generateReport, 20);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button====>>" + generateReport);
		expliciteWait(validationMessage, 20);
		String actual_error= validationMessage.getText();
		log("Verifying Validation Messages: " + actual_error);
		test.log(LogStatus.INFO, "Verifying Validation Messages: " + actual_error);
	    /*String expected_error = "日付から選択 現在まで選択 車両番号を選択";
	    Assert.assertEquals(actual_error, expected_error);*/
		validationPopupClose.click();
	}

	
	public void Vehicle_Dropdown() throws Exception {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("static")));
		if (invisiable) {
			WebElement ele = driver.findElement(By.xpath("//div[@id='s2id_lstVehicle']/a/span[1]"));
			ele.click();
		}
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("s2id_autogen11"))).click().build().perform();*/
		/*expliciteWait(selectVehicle, 40);
		selectVehicle.click();*/
		log("Clicked on selectVehicle dropdown====>>" + selectVehicle + " and object is" + selectVehicle.toString());
		test.log(LogStatus.INFO, "Clicked on selectVehicle dropdown" );
		expliciteWait(Meiko299, 30);
		Meiko299.click();
		log("Selected dropdownvalue id====>>" + Meiko299 + " and object is" + Meiko299.toString());
		test.log(LogStatus.INFO, "Selected dropdownvalue icon" );
		Pagination.click();
		log("Clicked on Pagination id====>>" + Pagination + " and object is" + Pagination.toString());
		test.log(LogStatus.INFO, "Clicked on Pagination button" );
		expliciteWait(generateReport, 10);
		generateReport.click();
		log("Clicked on generateReport id====>>" + generateReport + " and object is" + generateReport.toString());
		test.log(LogStatus.INFO, "Clicked on generateReport button");
		
	}
	
	


	public void log(String data) {
		
		log.info(data);
		Reporter.log(data);
	}

	
}
