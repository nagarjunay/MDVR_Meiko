package com.test.automation.FMSV12_Japan.dashboard;

/**
 * @author nagarjuna
 *
 */

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.DashBoard_StateOfVehicle;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;

public class TC106_VerifyingStateOfVehicle extends TestBase {

	public static final Logger log = Logger.getLogger(TC106_VerifyingStateOfVehicle.class.getName());
	LoginPage loginpage;
	DashBoard_StateOfVehicle moving;

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

	@Test(dataProvider = "getDataFromExcel", priority = 1)
	public void movingState(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started Moving-->Moving Vehicles Report");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		moving = new DashBoard_StateOfVehicle(driver);
		moving.Verifying_StateOfMoving();
		// moving.Verifying_Copybutton();
		log("=========>Finished Moving-->Moving Vehicles Report");

		log("=========>Started Tools Dropdown options");
		ArrayList<Object> list1 = new ArrayList<Object>();
		list1.add(" 印刷");
		list1.add("  Excel");
		list1.add("  PDF");
		ArrayList<Object> drop_down_values1 = moving.verifyTools_dropdown();
		System.out.println("List Values are " + drop_down_values1);
		Assert.assertEquals(drop_down_values1, list1);
		log("=========>Finished VTools Dropdown options");
	}
	/*
	 * @Test(dataProvider = "getDataFromExcel", priority=2) public void
	 * MovingVehiclesReport(String loginid, String password, String runMode) throws
	 * Exception { if (runMode.equalsIgnoreCase("n")) { throw new
	 * SkipException("User marked this not to run"); }
	 * log("=========>Started Moving-->Moving Vehicles Report"); loginpage = new
	 * LoginPage(driver); loginpage.loginToApplication(loginid, password); moving =
	 * new DashBoard_StateOfVehicle(driver); moving.Verifying_StateOfMoving();
	 * //moving.Verifying_Copybutton();
	 * log("=========>Finished Moving-->Moving Vehicles Report");
	 * 
	 * log("=========>Started Verifying Records per page Dropdown options");
	 * ArrayList<Object> list = new ArrayList<Object>(); list.add("100");
	 * list.add("200"); list.add("300"); list.add("All"); ArrayList<Object>
	 * drop_down_values = moving.verifyRecordesPerPage_dropdown();
	 * System.out.println("List Values are " + drop_down_values);
	 * Assert.assertEquals(drop_down_values, list);
	 * log("=========>Finished Verifying Records per page Dropdown options"); }
	 */

}
