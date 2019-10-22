/**
 * 
 */
package com.test.automation.FMSV12_Japan.vehiclereports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_ActivitySummaryReport;
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_TotalDistanceReport;

/**
 * @author nagarjuna
 *
 */

public class TC010_TotalDistance extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC010_TotalDistance.class.getName());
	LoginPage loginpage;
	VehicleReports_TotalDistanceReport tds;

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
		//tds.validation();
		tds.FromData();
		tds.TODate();
		tds.Drodown();
		tds.Verifying_TotalNum_Of_Col_Rows();
		log("=========>Finished--->Total distance Report Module");
	}

}