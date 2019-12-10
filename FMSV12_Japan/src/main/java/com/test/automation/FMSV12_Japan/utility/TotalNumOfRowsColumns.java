/**
 * 
 */
package com.test.automation.FMSV12_Japan.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class TotalNumOfRowsColumns extends TestBase {

	public static WebDriver driver;

	public TotalNumOfRowsColumns(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Verifying_TotalNum_Of_Col_Rows() throws Exception {

		List<WebElement> col = driver.findElements(By.xpath(
				"//table[@class='table table-striped table-hover table-coluredheader dataTable']/thead/tr/th[string-length(text()) > 0] "));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		Thread.sleep(2000);
		List<WebElement> row = driver.findElements(By.cssSelector("#rptBody > tr"));
		Thread.sleep(1000);
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);

	}
	
	
	
}
