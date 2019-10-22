package com.test.automation.FMSV12_Japan.dashboard;

/**
 * @author nagarjuna
 *
 */

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.DashBoard_VehicleStatus;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;


public class TC002_VerifyingVehicleStatusTable extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyingVehicleStatusTable.class.getName());
	LoginPage loginpage;
	DashBoard_VehicleStatus dashboard;

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
	public void masterOption(String loginid, String password, String runMode) throws Exception {
		
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started Master-->Fleet Tracking Vehicle Status");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		dashboard = new DashBoard_VehicleStatus(driver);
		dashboard.Verifying_TotalNum_Of_Col_Rows();
		log("=========>Finished Master-->Fleet Tracking Vehicle Status");
	}

}
