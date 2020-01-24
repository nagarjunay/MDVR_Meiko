/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.utility.DatePicker;

/**
 * @author nagarjuna
 *
 */
public class TrackOnMap extends TestBase {

	WebDriver driver;
	DatePicker picker;

	@FindBy(xpath = "//div[@class='sidebar-toggler hidden-phone']")
	WebElement hamburger;

	@FindBy(xpath = "//*[@id='lnk6']/a/span")
	WebElement Tracking;

	@FindBy(xpath = "//*[@id='lnk65']/a/span")
	WebElement TrackOnMap;

	@FindBy(xpath = "//*[@id='maptbr']/img")
	WebElement Mapfiltercriteria;

	@FindBy(css = "#divheader > span")
	WebElement TrackonmapWindow;

	@FindBy(css = "#s2id_lstStatus")
	WebElement statusDropdown;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[1]/div")
	WebElement dropdown_all;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[2]/div")
	WebElement dropdown_moving;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[3]/div")
	WebElement dropdown_stop;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[4]/div")
	WebElement dropdown_idle;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[5]/div")
	WebElement dropdown_notpolling;

	@FindBy(css = "#s2id_lstSubUsers > a")
	WebElement userdropdown;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[1]/div")
	WebElement userdropdown_1;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[2]/div")
	WebElement userdropdown_2;

	@FindBy(css = "#trackhistory")
	WebElement trackhistoryButton;

	@FindBy(css = "#tracklive")
	WebElement trackLiveButton;

	@FindBy(css = "#clickmetoclose")
	WebElement TrackonmapWindowCloseButton;

	@FindBy(xpath = "//*[@id='s2id_lstVehicles']/a/span[1]")
	WebElement vehicleDropdown;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[1]/div")
	WebElement vehicle_meiko299;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[2]/div")
	WebElement vehicle_meiko300;

	@FindBy(css = "h4#msgtitle")
	WebElement validationpopuptitle;

	@FindBy(css = "#msgbody > p")
	WebElement validationmessage;

	@FindBy(css = "#static > div > div > div.modal-footer > button")
	WebElement validationpopupOkButton;

	@FindBy(xpath = "//*[@id='btnAnimate']")
	WebElement AnimateButton;

	@FindBy(css = "#btnGroupVerticalDrop5")
	WebElement dropDownButton;

	@FindBy(css = "#historyToolbar > div > div.btn-group-vertical.btn-group-solid > div > ul > li:nth-child(1) > a")
	WebElement dataSummary;

	@FindBy(css = "#historyToolbar > div > div.btn-group-vertical.btn-group-solid > div > ul > li:nth-child(2) > a")
	WebElement Trackdata;

	@FindBy(xpath = "//*[@id='data_summary']/div/div/div[3]/button")
	WebElement DataSummaryOkButton;

	@FindBy(xpath = "//*[@id='data_history']/div/div/div[3]/button")
	WebElement DataHistoryOkButton;

	@FindBy(css = "#GMAP > div:nth-child(1) > div > div:nth-child(17) > div:nth-child(2) > div:nth-child(1)")
	WebElement Satellite;

	@FindBy(css = "#GMAP > div:nth-child(1) > div > div.fullScreen > div > div > strong")
	WebElement Fullscreendisplay;

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

	public void TrackonMapValidation() {
		expliciteWait(Mapfiltercriteria, 20, driver);
		Mapfiltercriteria.click();
		log("Clicked on Map filter criteria icon====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on Map filter criteria icon");
		expliciteWait(TrackonmapWindow, 20, driver);
		String actual_error = TrackonmapWindow.getText();
		log("Validating Track on Map popup window title: " + actual_error);
		test.log(LogStatus.INFO, "Validating Track on Map popup window title: " + actual_error);
		String expected_error = "地図上追跡";
		Assert.assertEquals(actual_error, expected_error);
		expliciteWait(trackhistoryButton, 30, driver);
		trackhistoryButton.click();
		log("Clicked on Track history button");
		test.log(LogStatus.INFO, "Clicked on Track history button");
		validationpopupwindow();
	}

	public void TrackonMapValidation1() {
		expliciteWait(validationpopupOkButton, 20, driver);
		validationpopupOkButton.click();
		selectStatusDropdown();
		log("Clicked on vehicle status dropdown====>>" + statusDropdown + " and object is" + statusDropdown.toString());
		test.log(LogStatus.INFO, "Clicked on vehicle status dropdown");
		dropdown_moving.click();
		log("Selected moving vehicle from status dropdown====>>" + dropdown_moving + " and object is"
				+ dropdown_moving.toString());
		test.log(LogStatus.INFO, "Selected moving vehicle from status dropdown");
		validationpopupwindow();

	}

	public void validatingAllDropdowns() {
		expliciteWait(validationpopupOkButton, 20, driver);
		validationpopupOkButton.click();
		selectStatusDropdown();
		dropdown_all.click();
		log("Selected All vehicle option from status dropdown====>>" + dropdown_moving + " and object is"
				+ dropdown_moving.toString());
		test.log(LogStatus.INFO, "Selected All vehicle option from status dropdown");
		selectUserDropdown();
		expliciteWait(userdropdown_2, 20, driver);
		userdropdown_2.click();
		log("Selected Meiko User from user dropdown====>>" + userdropdown_2 + " and object is"
				+ userdropdown_2.toString());
		test.log(LogStatus.INFO, "Selected Meiko User from user dropdown");
		selectVehicleDropdown();
		vehicle_meiko299.click();
		log("Selected Meiko 299 from vehicle dropdown====>>" + vehicle_meiko299 + " and object is"
				+ vehicle_meiko299.toString());
		test.log(LogStatus.INFO, "Selected Meiko 299 from vehicle dropdown");
		trackhistoryButton.click();
		log("Clicked on Track history button");
		test.log(LogStatus.INFO, "Clicked on Track history button");
		validationpopupwindow();

	}

	public void validationFromDate() {

		expliciteWait(validationpopupOkButton, 20, driver);
		validationpopupOkButton.click();
		VideostatusFromData();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = trackhistoryButton;
			ele.click();
		}
		log("Clicked on Track history button");
		test.log(LogStatus.INFO, "Clicked on Track history button");
		validationpopupwindow();

	}

	public void Trackonmaphistory() throws Exception {

		expliciteWait(validationpopupOkButton, 20, driver);
		validationpopupOkButton.click();
		VideostatusTODate();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		boolean invisiable = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = trackhistoryButton;
			ele.click();
		}
		log("Clicked Track history button");
		test.log(LogStatus.INFO, "Clicked on Track history button");
		/*
		 * expliciteWait(validationpopupOkButton, 20, driver);
		 * validationpopupOkButton.click();
		 */
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		boolean invisiable1 = wait1.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable1) {
			WebElement ele1 = TrackonmapWindowCloseButton;
			ele1.click();
		}
		/*
		 * expliciteWait(TrackonmapWindowCloseButton, 20, driver);
		 * TrackonmapWindowCloseButton.click();
		 */
		log("Clicked on Track on map close button");
		test.log(LogStatus.INFO, "Clicked on Track on map close button");
		zoomIn();
		log("Zoom In on Map");
		test.log(LogStatus.INFO, "Zoom In on Map");

	}

	public void AnimateButton() {
		expliciteWait(AnimateButton, 20, driver);
		AnimateButton.click();
		log("Clicked on Animate button");
		test.log(LogStatus.INFO, "Clicked on Animate button");
	}

	public void Dropdown() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = dropDownButton;
			ele.click();
		}
		/*
		 * expliciteWait(dropDownButton, 20, driver); dropDownButton.click();
		 */
		log("Clicked on Dropdown button");
		test.log(LogStatus.INFO, "Clicked on Dropdown button");

	}

	public void Summary() throws Exception {
		expliciteWait(dataSummary, 30, driver);
		// Thread.sleep(2000);
		dataSummary.click();
		log("Selected Summary from Dropdown");
		test.log(LogStatus.INFO, "Selected Summary from Dropdown");

	}

	public void TrackData() {
		expliciteWait(Trackdata, 20, driver);
		Trackdata.click();
		log("Selected Track Data from Dropdown");
		test.log(LogStatus.INFO, "Selected Track Data from Dropdown");

	}

	public void SummaryOkButton() {
		expliciteWait(DataSummaryOkButton, 20, driver);
		DataSummaryOkButton.click();
		log("Clicked on Data Summary OK button");
		test.log(LogStatus.INFO, "Clicked on Data Summary OK button");
	}

	public void HistoryOkButton() {
		expliciteWait(DataHistoryOkButton, 20, driver);
		DataHistoryOkButton.click();
		log("Clicked on Data History OK button");
		test.log(LogStatus.INFO, "Clicked on Data History OK button");
	}

	public void VideostatusFromData() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtfrom').value='09/12/2019 00:00'");
		log("Entered from Date");
		test.log(LogStatus.INFO, "Entered from Date");
	}

	public void VideostatusTODate() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dtto').value='09/12/2019 23:59'");
		log("Entered to Date");
		test.log(LogStatus.INFO, "Entered to Date");
	}

	public void selectStatusDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = statusDropdown;
			ele.click();
		}
	}

	public void selectUserDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = userdropdown;
			ele.click();
		}
	}

	public void selectVehicleDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean invisiable = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='static' or @class='modal-backdrop fade']")));
		if (invisiable) {
			WebElement ele = vehicleDropdown;
			ele.click();
		}
	}

	public void zoomIn() throws Exception {
		// To zoom In page 4 time using CTRL and + keys.
		
		Robot robot = new Robot();
		System.out.println("About to zoom in");
		for (int i = 0; i < 1; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public void zoomOut() {
		// To zoom out page 4 time using CTRL and - keys.
		for (int i = 0; i < 1; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		}
	}

	public void set100() {
		// To set browser to default zoom level 100%
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
	}

	public void validationpopupwindow() {
		expliciteWait(validationpopuptitle, 20, driver);
		String actual_error1 = validationpopuptitle.getText();
		log("Validating popup window title: " + actual_error1);
		test.log(LogStatus.INFO, "Validating popup window title: " + actual_error1);
		String expected_error1 = "FMS - 地図上追跡| 警告情報";
		Assert.assertEquals(actual_error1, expected_error1);
		expliciteWait(validationmessage, 20, driver);
		String actual_error2 = validationmessage.getText();
		log("Validating popup window messages: " + actual_error2);
		test.log(LogStatus.INFO, "Validating popup window messages: " + actual_error2);
	}

	public void verifySummaryData() throws Exception {

		TrakonMap();
		expliciteWait(Mapfiltercriteria, 20, driver);
		Mapfiltercriteria.click();
		log("Clicked on Map filter criteria icon====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on Map filter criteria icon");
		selectStatusDropdown();
		dropdown_all.click();
		log("Selected All vehicle option from status dropdown====>>" + dropdown_moving + " and object is"
				+ dropdown_moving.toString());
		test.log(LogStatus.INFO, "Selected All vehicle option from status dropdown");
		selectUserDropdown();
		expliciteWait(userdropdown_2, 20, driver);
		userdropdown_2.click();
		log("Selected Meiko User from user dropdown====>>" + userdropdown_2 + " and object is"
				+ userdropdown_2.toString());
		test.log(LogStatus.INFO, "Selected Meiko User from user dropdown");
		selectVehicleDropdown();
		vehicle_meiko299.click();
		log("Selected Meiko 299 from vehicle dropdown====>>" + vehicle_meiko299 + " and object is"
				+ vehicle_meiko299.toString());
		test.log(LogStatus.INFO, "Selected Meiko 299 from vehicle dropdown");
		VideostatusFromData();
		VideostatusTODate();
		trackhistoryButton.click();
		log("Clicked on Track history button");
		test.log(LogStatus.INFO, "Clicked on Track history button");
		TrackonmapWindowCloseButton.click();
		expliciteWait(dropDownButton, 30, driver);
		dropDownButton.click();
		Summary();

	}

	public void verifyHistoryTrackData() throws Exception {

		TrakonMap();
		expliciteWait(Mapfiltercriteria, 20, driver);
		Mapfiltercriteria.click();
		log("Clicked on Map filter criteria icon====>>" + hamburger + " and object is" + hamburger.toString());
		test.log(LogStatus.INFO, "Clicked on Map filter criteria icon");
		selectStatusDropdown();
		dropdown_all.click();
		log("Selected All vehicle option from status dropdown====>>" + dropdown_moving + " and object is"
				+ dropdown_moving.toString());
		test.log(LogStatus.INFO, "Selected All vehicle option from status dropdown");
		selectUserDropdown();
		expliciteWait(userdropdown_2, 20, driver);
		userdropdown_2.click();
		log("Selected Meiko User from user dropdown====>>" + userdropdown_2 + " and object is"
				+ userdropdown_2.toString());
		test.log(LogStatus.INFO, "Selected Meiko User from user dropdown");
		selectVehicleDropdown();
		vehicle_meiko299.click();
		log("Selected Meiko 299 from vehicle dropdown====>>" + vehicle_meiko299 + " and object is"
				+ vehicle_meiko299.toString());
		test.log(LogStatus.INFO, "Selected Meiko 299 from vehicle dropdown");
		VideostatusFromData();
		VideostatusTODate();
		trackhistoryButton.click();
		log("Clicked on Track history button");
		test.log(LogStatus.INFO, "Clicked on Track history button");
		TrackonmapWindowCloseButton.click();
		expliciteWait(dropDownButton, 30, driver);
		dropDownButton.click();
		TrackData();
	}

	public void satellite() {
		Satellite.click();
	}
	
	public void fullscreen() {
		Fullscreendisplay.click();
	}
}
