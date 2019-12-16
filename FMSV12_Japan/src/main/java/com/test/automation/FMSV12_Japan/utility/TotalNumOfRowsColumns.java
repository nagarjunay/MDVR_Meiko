/**
 * 
 */
package com.test.automation.FMSV12_Japan.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class TotalNumOfRowsColumns extends TestBase {

	 WebDriver driver;
	
	@FindBy(xpath="//table[@class='table table-striped table-hover table-coluredheader dataTable']/thead/tr/th[string-length(text()) > 0] ")
	WebElement list;

	public TotalNumOfRowsColumns(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Verifying_TotalNum_Of_Col_Rows() throws Exception {

		expliciteWait(list, 60, driver);
		List<WebElement> col = driver.findElements(By.xpath(
				"//table[@class='table table-striped table-hover table-coluredheader dataTable']/thead/tr/th[string-length(text()) > 0] "));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		Thread.sleep(2000);
		List<WebElement> row = driver.findElements(By.cssSelector("#rptBody > tr"));
		Thread.sleep(2000);
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);

	}
	
	
	public void Verifying_TotalNumOfColRows_VehicleStatus() throws Exception {
	
		expliciteWait(list, 60, driver);
		List<WebElement> col = driver.findElements(By.xpath(
				"//table[@class='table table-striped table-hover table-coluredheader dataTable']/thead/tr/th[string-length(text()) > 0] "));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		Thread.sleep(2000);
		List<WebElement> row = driver.findElements(By.cssSelector("#tblDSW > tbody > tr"));
		Thread.sleep(2000);
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);
		
		
	}
}
