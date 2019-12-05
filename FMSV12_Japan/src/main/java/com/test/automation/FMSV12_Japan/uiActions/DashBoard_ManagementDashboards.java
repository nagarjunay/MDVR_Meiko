/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import java.util.List;

import org.openqa.selenium.By;
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
public class DashBoard_ManagementDashboards extends TestBase {


	public WebDriver driver;

	@FindBy(xpath = "//*[@id='recentalertsportlet']/div[1]/div[1]/span")
	WebElement Recentalerts_Text;
	
	@FindBy(xpath = "//*[@id='currentfleetportlet']/div[1]/div[1]/span")
	WebElement Currentfleet_Text;
	
	@FindBy(xpath="//*[@id='header_notification_bar']/ul/li[3]/a")
	WebElement seeAllAlertsHyperlink;

	
	
	public DashBoard_ManagementDashboards(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Mouse_over() {

		log("Performing mouse over on Management Dashboard dropdown");
		test.log(LogStatus.INFO, "Performing mouse over on Management Dashboard dropdown");
		mouse_movement(driver, "//*[@id='mainpage']/div[1]/div/ul/li[1]/button/span");
	}

	public void Management_CheckBox() {
		WebElement Checkbox = driver
				.findElement(By.cssSelector("#mdashboards > label:nth-child(1) > div > span > input[type=checkbox]"));
		if (!Checkbox.isSelected()) {
			Checkbox.click();
		} else {
			log("Checkbox is checked: " + Checkbox.isSelected());
			test.log(LogStatus.INFO, "Checkbox is checked: " + Checkbox.isSelected());
		}

	}
	
	public void alert() throws Exception {
		log("Performing mouse over on header notification icon");
		test.log(LogStatus.INFO, "Performing mouse over on header notification icon");
		mouse_movement(driver, "//ul[@class='nav navbar-nav pull-right']/li[1]/a");
		String alert1text = driver.findElement(By.xpath("//*[@id='pAlertCount']")).getText();
		log("Notification header text: " + alert1text);
		test.log(LogStatus.INFO, "Notification 1 header text: " + alert1text);
		String alert1Count = driver.findElement(By.xpath("//*[@id='spnAlertCount']")).getText();
		log("Notification header count: " + alert1Count);
		test.log(LogStatus.INFO, "Notification 1 header count: " + alert1Count);
		seeAllAlertsHyperlink.click();
		log("Clicked on See All Alerts Hyper link on Alert mouse over window====>>" + seeAllAlertsHyperlink + " and object is" + seeAllAlertsHyperlink.toString());
		test.log(LogStatus.INFO, "Clicked on See All Alerts Hyper link on Alert mouse over window");
		log("Alert Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Alert Window Title: " + driver.getTitle());
		Verifying_TotalNum_Of_Col_Rows();
		
		
		}

	
	public void alert1() {
		log("Performing mouse over on header notification icon");
		test.log(LogStatus.INFO, "Performing mouse over on header notification icon");
		mouse_movement(driver, "//ul[@class='nav navbar-nav pull-right']/li[3]/a");
		
		String actaul = driver.findElement(By.xpath("//*[@id='pTotalAlertCount']")).getText();
		log("Notification header text: " + actaul);
		test.log(LogStatus.INFO, "Notification 2 header text: " + actaul);
		String alert1Count = driver.findElement(By.xpath("//*[@id='spnTotalAlertCount']")).getText();
		log("Notification header count: " + alert1Count);
		test.log(LogStatus.INFO, "Notification 1 header count: " + alert1Count);
	}
	
	public void Verifying_TotalNum_Of_Col_Rows() throws Exception {

		List<WebElement> col = driver.findElements(By.xpath(
				"//table[@class='table table-striped table-hover table-coluredheader dataTable']/thead/tr/th[string-length(text()) > 0] "));
		int colCount = col.size();
		log("Total Number of columns count in a table: " + colCount);
		test.log(LogStatus.INFO, "Total Number of columns count in a table==>" + colCount);
		Thread.sleep(2000);
		List<WebElement> row = driver.findElements(By.cssSelector("#tblDSW > tbody > tr"));
		int rowCount = row.size();
		log("Total Number of rows count in a table: " + rowCount);
		test.log(LogStatus.INFO, "Total Number of rows count in a table==>" + rowCount);

	}
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
