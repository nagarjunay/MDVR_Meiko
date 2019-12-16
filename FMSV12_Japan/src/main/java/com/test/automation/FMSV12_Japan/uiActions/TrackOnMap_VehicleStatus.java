/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.utility.TotalNumOfRowsColumns;

/**
 * @author nagarjuna
 *
 */
public class TrackOnMap_VehicleStatus extends TestBase {
	
	WebDriver driver;
	TotalNumOfRowsColumns vs;

	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;
	
	@FindBy(xpath = "//*[@id='lnk6']/a/span")
	WebElement Tracking;
	
	@FindBy(xpath = "//*[@id='lnk64']/a")
	WebElement DynamicStatus;
	
	//*[@id='lnk6']/a/span

	@FindBy(xpath = "//*[@id='lnk68']/a")
	WebElement VehicleStatus;

	@FindBy(xpath = "//*[@id='lnk69']/a")
	WebElement AlertStatus;

	@FindBy(xpath = "//*[@id='lnk31']/a/span")
	WebElement idle;
	
	@FindBy(css="#tblDSW > tbody > tr.odd > td:nth-child(13) > a")
	WebElement VideoButton;
    

	public TrackOnMap_VehicleStatus(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void VehicleStatus() throws Exception {

		log("Dashboard Window Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Dashboard Window Title: " + driver.getTitle());
		expliciteWait(hamburger, 20, driver);
		hamburger.click();
		log("Clicked on hamburger icon id====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on hamburger icon");
		expliciteWait(Tracking, 20, driver);
		Tracking.click();
		log("Clicked on Tracking id====>>" + Tracking + " and object is" + Tracking.toString());
		test.log(LogStatus.INFO, "Clicked on Tracking option");
		expliciteWait(DynamicStatus, 20, driver);
		DynamicStatus.click();
		log("Clicked on Dynamic Status id====>>" + DynamicStatus + " and object is" + DynamicStatus.toString());
		test.log(LogStatus.INFO, "Clicked on Dynamic Status option");
		expliciteWait(VehicleStatus, 20, driver);
		VehicleStatus.click();
		log("Clicked on Vehicle Status id====>>" + VehicleStatus + " and object is" + VehicleStatus.toString());
		test.log(LogStatus.INFO, "Clicked on Vehicle Status option");
		vs = new TotalNumOfRowsColumns(driver);
		vs.Verifying_TotalNumOfColRows_VehicleStatus();
	
	}
	
	public void LiveVideo() {
		expliciteWait(VideoButton, 20, driver);
		VideoButton.click();
		log("Clicked on Video Button ====>>" + VideoButton + " and object is" + VideoButton.toString());
		test.log(LogStatus.INFO, "Clicked on Video Button ");
		
	}
}
