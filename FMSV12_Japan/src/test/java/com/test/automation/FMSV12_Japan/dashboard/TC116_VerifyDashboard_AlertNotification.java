/**
 * 
 */
package com.test.automation.FMSV12_Japan.dashboard;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.DashBoard_ManagementDashboards;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.utility.ColorCodeVerification;
import com.test.automation.FMSV12_Japan.utility.ScrollingPage;

/**
 * @author nagarjuna
 *
 */
public class TC116_VerifyDashboard_AlertNotification extends TestBase{
	
	LoginPage loginpage;
	DashBoard_ManagementDashboards checkbox;
	ColorCodeVerification color;
	ScrollingPage scroll;

	@DataProvider
	public Object[][] getDataFromExcel() throws Exception {
		Object[][] data = Excel_Reader.read_excel("Master");// sheet name
		return data;
	}

	@BeforeClass
	@Parameters("Browser_Name")
	public void setUp(String Browser_Name) throws IOException {
		init(Browser_Name);

	}

	@Test(dataProvider = "getDataFromExcel")
	public void a_VerifyNotificationHeader1(String loginid, String password, String runMode) throws Exception {
		
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started Login");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		log("=========>Login successful");
		checkbox = new DashBoard_ManagementDashboards(driver);
		checkbox.alert();
		scroll = new ScrollingPage(driver);
		scroll.scrollPage();
				
	}
	
	@Test
	public void b_VerifyNotificationHeader2() {
		checkbox.alert1();
	}
	
	

}
