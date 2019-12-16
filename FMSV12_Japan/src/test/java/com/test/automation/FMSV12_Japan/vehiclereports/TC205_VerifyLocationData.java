/**
 * 
 */
package com.test.automation.FMSV12_Japan.vehiclereports;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_LocationData;
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_VideoStatus;
import com.test.automation.FMSV12_Japan.utility.DatePicker;
import com.test.automation.FMSV12_Japan.utility.TotalNumOfRowsColumns;

/**
 * @author nagarjuna
 *
 */
public class TC205_VerifyLocationData extends TestBase{
	
	LoginPage loginpage;
	VehicleReports_LocationData ld;
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
	public void verifyLocationDataOption(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started--->Location Data Report Module");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		ld = new VehicleReports_LocationData(driver);
		ld.LocationData();
		ld.validation();
		ld.validation1();
		ld.validation2();
		ld.validation3();
		datepicker = new DatePicker(driver);
		datepicker.VideostatusFromData();
		datepicker.VideostatusTODate();
		ld.Vehicle_Dropdown();
		table = new TotalNumOfRowsColumns(driver);
		table.Verifying_TotalNum_Of_Col_Rows();
		log("=========>Finished--->Location Data Report Module");
	}

	

}
