package com.test.automation.FMSV12_Japan.vehiclereports;

/**
 * @author nagarjuna
 *
 */

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_ActivityReport;
import com.test.automation.FMSV12_Japan.utility.DatePicker;
import com.test.automation.FMSV12_Japan.utility.TotalNumOfRowsColumns;

public class TC201_02_VerifyActivityReport_ViolationCount extends TestBase {

	LoginPage loginpage;
	VehicleReports_ActivityReport vr;
	DatePicker datepicker;
	TotalNumOfRowsColumns table;

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
	public void verifyActivityOption_violationCount(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started--->Verifying Activity Report->Violation Count");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		vr = new VehicleReports_ActivityReport(driver);
		vr.Activity();
		datepicker = new DatePicker(driver);
		datepicker.FromData();
		datepicker.TODate();
		vr.VehicleDropdown();
		vr.violationCount();
		table = new TotalNumOfRowsColumns(driver);
		table.Verifying_TotalNum_Of_Col_Rows();
		log("=========>Finished--->Verifying Activity Report->Violation Count");
	}

	

}
