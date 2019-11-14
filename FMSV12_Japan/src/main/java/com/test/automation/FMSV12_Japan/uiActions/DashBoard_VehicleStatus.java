package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class DashBoard_VehicleStatus extends TestBase {

	WebDriver driver;

	public DashBoard_VehicleStatus(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Verifying_TotalNum_Of_Col_Rows() throws Exception {

		List<WebElement> col = driver.findElements(By.xpath("//*[@id='dswHeader']/th"));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='tblDSW']/tbody/tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);
	}
	
	   /*
	    * String Before_xpath = "//tbody[@id='lstBody']/tr["; String After_xpath =
	    * "]/td[3]"; 
    	* for (int i = 1; i <= rowCount; i++) { String name =
	    * driver.findElement(By.xpath(Before_xpath + i + After_xpath)).getText();
	    * System.out.println(name.toString()); if (name.contains("RSR1904010000002")) {
	    * // tbody[@id="lstBody"]/tr[1]/td[1]/input
	    * driver.findElement(By.xpath("//tbody[@id='lstBody']/tr[" + i +
	    * "]/td[1]/input")).click(); } }
	    */

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
