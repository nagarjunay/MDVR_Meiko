/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class TrackOnMap extends TestBase {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;
	
	@FindBy(xpath = "//*[@id='lnk6']/a/span")
	WebElement Tracking;
	
	@FindBy(xpath = "//*[@id='lnk65']/a/span")
	WebElement TrackOnMap;
	
	@FindBy(xpath= "//*[@id='maptbr']/img")
	WebElement Mapfiltercriteria;
	
	@FindBy(css="#divheader > span")
	WebElement TrackonmapWindow;
	
	@FindBy(css="#s2id_lstStatus")
	WebElement statusDropdown;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[1]/div")
	WebElement dropdown_all;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[2]/div")
	WebElement dropdown_moving;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[3]/div")
	WebElement dropdown_stop;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[4]/div")
	WebElement dropdown_idle;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[5]/div")
	WebElement dropdown_notpolling;
	
	@FindBy(css="#s2id_lstSubUsers > a")
	WebElement userdropdown;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[1]/div")
	WebElement userdropdown_1;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[2]/div") 
	WebElement userdropdown_2;
	
	@FindBy(css="#trackhistory")
	WebElement trackhistoryButton;
	
	@FindBy(css="#tracklive")
	WebElement trackLiveButton;
	
	@FindBy(css="#clickmetoclose")
	WebElement TrackonmapWindowCloseButton;
	
	@FindBy(xpath="//*[@id='s2id_lstVehicles']/a/span[1]") 
	WebElement vehicleDropdown;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[1]/div")
	WebElement vehicle_meiko299;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[2]/div") 
	WebElement vehicle_meiko300;

	@FindBy(xpath="	//*[@id='msgtitle']") 
	WebElement validationpopuptitle;
	
	@FindBy(css="#msgbody > p")
	WebElement validationmessage;

	@FindBy(css="#static > div > div > div.modal-footer > button")
	WebElement validationpopupOkButton;
	
	
	
	
	public TrackOnMap(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void TrakonMap() throws Exception {

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
		expliciteWait(TrackOnMap, 20, driver);
		TrackOnMap.click();
		log("Clicked on Track On Map id====>>" + TrackOnMap + " and object is" + TrackOnMap.toString());
		test.log(LogStatus.INFO, "Clicked on Track On Map option");
	
	}
	
	public void validation() {
		expliciteWait(Mapfiltercriteria, 20, driver);
		Mapfiltercriteria.click();
		log("Clicked on Map filter criteria icon====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on Map filter criteria icon");
		expliciteWait(TrackonmapWindow, 20, driver);
		String actual_error =TrackonmapWindow.getText();
		log("Validating Track on Map popup window title: "+actual_error);
		test.log(LogStatus.INFO, "Validating Track on Map popup window title: "+actual_error );
	    String expected_error="地図上追跡";
	    Assert.assertEquals(actual_error, expected_error);
		expliciteWait(trackhistoryButton, 30, driver);
		trackhistoryButton.click();
		log("Clicked on Track history button");
		test.log(LogStatus.INFO, "Clicked on Track history button" );
		validationpopupwindow();
	    
	}
	
	public void selectingStatusDropdownMoving() {
		expliciteWait(validationpopupOkButton, 20, driver);
		validationpopupOkButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = statusDropdown; 
			ele.click();
		}
		/*expliciteWait(statusDropdown, 20, driver);
		statusDropdown.click();*/
		log("Clicked on vehicle status dropdown====>>" + statusDropdown + " and object is" + statusDropdown.toString());
		test.log(LogStatus.INFO, "Clicked on vehicle status dropdown");
		dropdown_moving.click();
		log("Selected moving vehicle from status dropdown====>>" + dropdown_moving + " and object is" + dropdown_moving.toString());
		test.log(LogStatus.INFO, "Selected moving vehicle from status dropdown");
        validationpopupwindow();
		
	}
	
	
	public void validationpopupwindow() {
		expliciteWait(validationpopuptitle, 30, driver);
		String actual_error1 =validationpopuptitle.getText();
		log("Validating popup window title: "+actual_error1);
		test.log(LogStatus.INFO, "Validating popup window title: "+actual_error1);
	    String expected_error1="FMS - 地図上追跡| 警告情報";
	    Assert.assertEquals(actual_error1, expected_error1);
	    expliciteWait(validationmessage, 20, driver);
	    String actual_error2 =validationmessage.getText();
		log("Validating popup window messages: "+actual_error2);
		test.log(LogStatus.INFO, "Validating popup window messages: "+actual_error2);
	}
}
