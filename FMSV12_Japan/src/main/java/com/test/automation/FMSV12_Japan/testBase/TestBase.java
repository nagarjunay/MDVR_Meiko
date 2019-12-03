package com.test.automation.FMSV12_Japan.testBase;

/**
 * @author nagarjuna
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static WebDriver driver;
	public Properties OR = new Properties();
	public static ExtentReports extent;
	public static ExtentTest test;
	File file;

	/* This method is to select browser and url from the config file */
	@Parameters("Browser_Name")
	public void init(String Browser_Name) throws IOException {
		loadData();
		selectBrowser(Browser_Name);
		getUrl(OR.getProperty("url"));
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	/*
	 * static will load once on runtime, so can generate single extent report for
	 * every test run
	 */
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		
		/* extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/test/automation/FMSV12_Japan/report/Meiko_Report.html",
		 false);*/
		 
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/src/main/java/com/test/automation/FMSV12_Japan/report/FMSV12_Japan_"
						+ formater.format(calendar.getTime()) + ".html",
				true);
	}

	/* This method loads the data from the config file from main java folder */
	public void loadData() throws IOException {
		file = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\automation\\FMSV12_Japan\\Config\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}

	/*
	 * This Method will select the different browsers as mentioned in config
	 * properties file
	 */
//
	@Parameters("Browser_Name")
	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			log.info("creating object of " + browser);
			ChromeOptions copts = new ChromeOptions();
			/*copts.addArguments("--disable-infobars");*/
			copts.addArguments("notifications");
			copts.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			copts.setExperimentalOption("useAutomationExtension", false);
			copts.addArguments("incognito");
			copts.addArguments("--ppapi-flash-version=32.0.0.101");
			copts.addArguments("--ppapi-flash-path=/usr/lib/pepperflashplugin-nonfree/libpepflashplayer.so");
			copts.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new ChromeDriver(copts);
			log.info("Launching the Chrome browser");
			

		} else if (browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriverr.exe");
			log.info("creating object of " + browser);
			FirefoxOptions opts = new FirefoxOptions();
			opts.addArguments("-private");
			opts.addPreference("dom.webnotifications.enabled", false);
			opts.addPreference("app.update.enabled", false);
			opts.addPreference("geo.enabled", false);
			opts.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new FirefoxDriver(opts);
			log.info("Launching the Firefox browser");
			
		} else if (browser.equalsIgnoreCase("IE")) {
			//WebDriverManager.iedriver().setup();
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServerr.exe");
			log.info("creating object of " + browser);
			driver = new InternetExplorerDriver();
			log.info("Launching the Internet Explorer browser");
		}
	}

	/*This method will get url and maximizes browser window*/
	public void getUrl(String url) {
		log.info("Navigating to: " + url);
		driver.get(url);
		driver.manage().window().fullscreen();
		log.info("Window Maximized");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	/* This method is used for wait until element found */
	public void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/* This Method is to capture screenshots to on calling getScreenShot method */
	public void getScreenShot(String name) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\src\\main\\java\\com\\test\\automation\\FMSV12_Japan\\screenshot\\";
			File destFile = new File(
					(String) reportDirectory + name + "-" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/></a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* This method is used to print logs in TestNG reports */
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	/*
	 * This Method is used for generate Extent reports with screenshots for
	 * Pass/Fail test cases
	 */
	public void getresult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " Test Case PASSED ");
			String screen = captureScreen("");
			test.log(LogStatus.PASS, "  Success Screenshot : " + test.addScreenCapture(screen));
		}

		if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " Test Case SKIPPED and skip reason is:-" + result.getThrowable());
		}

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR,
					result.getName() + " Test case FAILED due to below issues: " + result.getThrowable());
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, "  Failure Screenshot : " + test.addScreenCapture(screen));
		} else

		if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " Test is started");

		}
	}

	/* This Method is used for to capture screenshots in Extent reports */
	public String captureScreen(String fileName) throws Exception {
		if (fileName == "") {
			fileName = "Screenshot";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = "\\src\\main\\java\\com\\test\\automation\\FMSV12_Japan\\screenshot\\";
			destFile = new File(
					(String) reportDirectory + fileName + "-" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			// This will help us to link screen shot in TestNg report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/></a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	/*
	 * public String capture_screenshot(WebDriver webDriver, String Sub_Folder_Name,
	 * String Image_Name) throws Exception { TakesScreenshot ts = ((TakesScreenshot)
	 * webDriver); File src = ts.getScreenshotAs(OutputType.FILE); String dest =
	 * System.getProperty("user.dir")+"/Screenshot/"+Sub_Folder_Name+"/"+Image_Name+
	 * "_"+datestamp("dd-MM-YYYY hh-mm-ss a")+".png"; File destination = new
	 * File(dest); FileUtils.copyFile(src, destination); return dest; }
	 * 
	 * public String datestamp(String Format) { SimpleDateFormat sdf = new
	 * SimpleDateFormat(Format); String date = sdf.format(new Date()); return date;
	 * }
	 */

	/* This method is used for dynamic list to store values and compare */
	public static ArrayList<Object> dropdown(String xpathExpression) {
		List<WebElement> li = driver.findElements(By.xpath(xpathExpression));
		ArrayList<Object> array_list = new ArrayList<Object>();

		for (WebElement webElement : li) {
			array_list.add(webElement.getText());
		}
		return array_list;
	}

	/* This method is used for Mouse over actions */
	public static void mouse_movement(WebDriver driver, String xpathExpression) {
		Actions act = new Actions(driver);
		WebElement target = driver.findElement(By.xpath(xpathExpression));
		act.moveToElement(target).build().perform();
	}

	/*public static String ColorVerify(WebDriver driver, String cssSelector, String cssValue)
	{
		WebElement target = driver.findElement(By.cssSelector(cssSelector));
		String colorCode= target.getCssValue(cssValue);
		String hexacolor = Color.fromString(colorCode).asHex();
		return hexacolor;
	}*/
	
	
	/* This method is used for List Selection */
	public static void list_selection_and_click(String xpathExpression, String string) {
		List<WebElement> li = driver.findElements(By.xpath(xpathExpression));
		for (WebElement element : li) {
			if (element.getText().equalsIgnoreCase(string)) {
				element.click();
				break;
			}
		}
	}

	/* This method is used for handling Alert/pop-up */
	public static void handling_alert_popup() throws Exception {

		Alert alert = driver.switchTo().alert();
		// Capturing alert message
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		test.log(LogStatus.INFO, "Captured alert message is: " + alertMessage);
		log.info("Captured alert message is: " + alertMessage);
		Thread.sleep(5000);
		// Accepting alert
		alert.accept();
	}

	/* This method is used for handling frames */
	public static void handling_frame(int index_number) {
		driver.switchTo().frame(index_number);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		getresult(result);
		test.log(LogStatus.INFO, result.getName() + " Test is Finished");
		test.log(LogStatus.INFO, " Browser Closed");
	}

	@BeforeMethod
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, "Browser Launched");
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		test.log(LogStatus.INFO, "Browser Name: "+ browserName);
		test.log(LogStatus.INFO, "Browser Version: "+browserVersion);
		String Currenturl= driver.getCurrentUrl();
		test.log(LogStatus.INFO, "Navigating to: "+Currenturl);
		test.log(LogStatus.INFO, result.getName() + " Test is Started");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser() {
		driver.quit();
		log.info("Browser closed");
		extent.endTest(test);
		extent.flush();
	}

}
