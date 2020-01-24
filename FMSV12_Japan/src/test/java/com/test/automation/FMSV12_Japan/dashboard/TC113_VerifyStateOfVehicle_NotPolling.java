/**
 * 
 */
package com.test.automation.FMSV12_Japan.dashboard;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.DashBoard_StateOfVehicle;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.utility.ColorCodeVerification;

/**
 * @author nagarjuna
 *
 */
public class TC113_VerifyStateOfVehicle_NotPolling extends TestBase{

	LoginPage loginpage;
	DashBoard_StateOfVehicle moving;
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
	public void Verify_NotpollingState(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started Not Polling Vehicles Report");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		moving = new DashBoard_StateOfVehicle(driver);
		moving.Verifying_StateOfNotPollingVehicles();
		// moving.Verifying_Copybutton();
		log("=========>Finished Not Polling Vehicles Report");

		log("=========>Started Verifying Tools dropdown color Code");
		color = new ColorCodeVerification(driver);
		String hexcolor = color.ColorVerify(
				"#mainreportsection > div.portlet-title > div.actions > div:nth-child(1) > a", "background-color");
		String expected = "#4d90fe";
		Assert.assertEquals(hexcolor, expected);
		log("Verifying Tools dropdown color Code: " + hexcolor);
		test.log(LogStatus.INFO, "Verifying Tools dropdown color Code: " + hexcolor);
		log("=========>Finished Verifying Tools dropdown color Code");

		log("=========>Started Tools Dropdown options");
		moving.verifyTools_dropdown();
		/*ArrayList<Object> list1 = new ArrayList<Object>();
		list1.add(" 印刷");
		list1.add(" Excel");
		list1.add(" PDF");
		ArrayList<Object> drop_down_values1 = moving.verifyTools_dropdown();
		System.out.println("List Values are " + drop_down_values1);
		Assert.assertEquals(drop_down_values1, list1);*/
		log("=========>Finished Tools Dropdown options");
		
		log("=========>Started Verifying back button color Code");
		color = new ColorCodeVerification(driver);
		String hexcolor1 = color.ColorVerify("#mainpage > div:nth-child(9) > div > div:nth-child(1) > a", "background-color");
		String expected1 = "#852b99";
		Assert.assertEquals(hexcolor1, expected1);
		log("Verifying back button color Code: " + hexcolor1);
		test.log(LogStatus.INFO, "Verifying back button color Code: " + hexcolor1);
		log("=========>Finished Verifying back button color Code");
		
		
		log("=========>Started Verifying Columns dropdown color Code");
		color = new ColorCodeVerification(driver);
		String hexcolor2 = color.ColorVerify("#mainreportsection > div.portlet-title > div.actions > div.btn-group.open > a", "background-color");
		String expected2 = "#0362fd";
		Assert.assertEquals(hexcolor2, expected2);
		log("Verifying Columns dropdown color Code: " + hexcolor2);
		test.log(LogStatus.INFO, "Verifying Columns dropdown color Code: " + hexcolor2);
		log("=========>Finished Verifying Columns dropdown color Code");
	}

	/*@Test()
	public void b_NotPollingVehiclesReport_VerifyRecordsperpageDropdown() throws Exception {
		
		log("=========>Started Verifying Records per page Dropdown options");
		moving.verifyRecordesPerPage_dropdown();
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("100");
		list.add("200");
		list.add("300");
		list.add("All");
		ArrayList<Object> drop_down_values = moving.verifyRecordesPerPage_dropdown();
		System.out.println("List Values are " + drop_down_values);
		Assert.assertEquals(drop_down_values, list);
		log("=========>Finished Verifying Records per page Dropdown options");
	}*/
	
}
