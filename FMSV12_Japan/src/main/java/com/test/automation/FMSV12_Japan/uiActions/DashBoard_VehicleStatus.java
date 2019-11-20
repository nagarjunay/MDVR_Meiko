package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

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

public class DashBoard_VehicleStatus extends TestBase {

	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id='tblDSW']/tbody/tr[1]/td[12]/a")
	WebElement downloadStatusButton;
	
	
	@FindBy(xpath="//*[@id='VivehicleNo']")
	WebElement VehicleNum;
	
	@FindBy(css="#tblDSW > tbody > tr.odd > td:nth-child(14) > a")
	WebElement MapItButton;
	
	@FindBy(xpath="//*[@id='form_modal13']/div/div/div[1]/button")
	WebElement LastdownloadwindowCloseButton;
	
    @FindBy(css="#dswfleettrack > div.portlet-title > div.caption > span")
    WebElement VehicleStatusText;

	public DashBoard_VehicleStatus(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void VerifyVehicleStatusWindowText() {
		String actual_error = VehicleStatusText.getAttribute("innerHTML");
		String expected_error = "所有車両追跡ー車両ステータス";
	    Assert.assertEquals(actual_error, expected_error);
	    log("Verify Vehicle Status Window Text: " + actual_error);
		test.log(LogStatus.INFO, "Verify Vehicle Status Window Text: " + actual_error);
	}
	
	
	public void Verifying_TotalNum_Of_Col_Rows() throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        log("Scrolling page");
		test.log(LogStatus.INFO, "Scrolling page");
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='dswHeader']/th"));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblDSW']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);
	}
	
	
	public void VerifyLastDownloadstatuswindow() {
		downloadStatusButton.click();
		String actual_error= driver.findElement(By.cssSelector("#form_modal13 > div > div > div:nth-child(1) > h4 > span")).getAttribute("innerHTML");
	    String expected_error="最終ダウンロードステータス";
	    Assert.assertEquals(actual_error, expected_error);
	    log("Verify Last Download Status Text: " + actual_error);
		test.log(LogStatus.INFO, "Verify Last Download Status Text: " + actual_error);
		log("Verify Last Download Status vehicle number: " + VehicleNum.getAttribute("innerHTML"));
		test.log(LogStatus.INFO, "Verify Last Download Status vehicle number: " + VehicleNum.getAttribute("innerHTML"));
		getScreenShot(actual_error);
		LastdownloadwindowCloseButton.click();
	}
	
	
	
	public void VerifyMapIt() {
		MapItButton.click();
		log("Clicked on Map It button " + downloadStatusButton.toString());
		test.log(LogStatus.INFO, "Clicked on Map It button");
		String actual_error= driver.findElement(By.cssSelector("#form_modal2 > div > div > div.modal-header > h4")).getAttribute("innerHTML");
	    //String expected_error=" 地図表示";
	    //Assert.assertEquals(actual_error, expected_error);
	    log("Verify Map Window Text: " + actual_error);
		test.log(LogStatus.INFO, "Verify Map Window Text: " + actual_error);
	}
	
	
	 
	//*[@id="tblDSW"]/tbody/tr[1]/td[2]/span/img
	/*public void Vehicle_Status() {
	    
	    String Before_xpath = "//*[@id='tblDSW']/tbody/tr[1]/td[";
	    String After_xpath = "]/span/img"; 
    	int row = 0;
		for (int i = 1; i <= row; i++) { 
    	String name = driver.findElement(By.xpath(Before_xpath + i + After_xpath)).getText();
	    System.out.println(name.toString()); 
	    if (name.contains("Inactive - N")) {
	     // tbody[@id="lstBody"]/tr[1]/td[1]/input
	    driver.findElement(By.xpath("//*[@id='tblDSW']/tbody/tr[1]/td[" + i + "]/span/img")).getText(); } }

	}*/
	    

	   /*
	    * public void Method2_Verifying_TotalNum_Of_Col_Rows() {
	    * driver.findElement(By.xpath(
	    * "//a[contains(text(),'RSA1903270000008')]/parent::td//preceding-sibling::td[2]/input[@type='checkbox']"
	    * )) .click();
	    * 
	    * }
    	*/

	public void log(String data) {
		
		log.info(data);
		Reporter.log(data);
	}

}
