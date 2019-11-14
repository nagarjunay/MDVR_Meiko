/**
 * 
 */
package com.test.automation.FMSV12_Japan.dashboard;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.ColorCodeVerification;
import com.test.automation.FMSV12_Japan.uiActions.DashBoard_ManagementDashboards;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;

/**
 * @author nagarjuna
 *
 */
public class TC106_VerifyManangementDashboardCheckbox extends TestBase {
	
	LoginPage loginpage;
	DashBoard_ManagementDashboards checkbox;
	ColorCodeVerification color;

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
	public void VerifyManangementDashboardCheckbox(String loginid, String password, String runMode) throws Exception {
		
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started Login");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		log("=========>Login successful");
		checkbox = new DashBoard_ManagementDashboards(driver);
		checkbox.Mouse_over();
		checkbox.Management_CheckBox();
		log("=========>Started Verifying Management dashboard dropdown color");
		color = new ColorCodeVerification(driver);
		String hexcolor =color.ColorVerify("button[type='button']", "background-color");
		System.out.println(hexcolor);
		String expected = "#0362fd";
		Assert.assertEquals(hexcolor, expected);
		log("Verifying Management Dashboard dropdown color: "+ hexcolor);
		test.log(LogStatus.INFO, "Verifying Management dashboard dropdown color: "+ hexcolor);
		log("=========>Finished Verifying Management dashboard dropdown color");
		
	}

}
