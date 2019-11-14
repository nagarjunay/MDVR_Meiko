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
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_IdleReport;

/**
 * @author nagarjuna
 *
 */

public class TC203_VerifyIdleReport extends TestBase {
	
	LoginPage loginpage;
	VehicleReports_IdleReport ir;

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
	public void IdleOption(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started--->Idle Report Module");
		loginpage = new LoginPage(driver);
	    loginpage.loginToApplication(loginid, password);
		ir = new VehicleReports_IdleReport(driver);
		ir.Idle();
		//ir.validation();
		ir.FromData();
		ir.TODate();
		ir.Drodown();
		ir.Verifying_TotalNum_Of_Col_Rows();
		log("=========>Finished--->Idle Report Module");
	}
}
