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
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_TotalDistanceReport;
import com.test.automation.FMSV12_Japan.utility.DatePicker;
import com.test.automation.FMSV12_Japan.utility.TotalNumOfRowsColumns;

/**
 * @author nagarjuna
 *
 */

public class TC204_VerifyTotalDistanceReport extends TestBase {
	
	
	LoginPage loginpage;
	VehicleReports_TotalDistanceReport tds;
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
	public void TotaldistanceOption(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started--->Total distance Report Module");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		tds = new VehicleReports_TotalDistanceReport(driver);
		tds.TotalDistance();
		tds.validation();
		datepicker = new DatePicker(driver);
		datepicker.FromData();
		datepicker.TODate();
		tds.Vehicle_Dropdown();
		table = new TotalNumOfRowsColumns(driver);
		table.Verifying_TotalNum_Of_Col_Rows();
		log("=========>Finished--->Total distance Report Module");
	}

}
