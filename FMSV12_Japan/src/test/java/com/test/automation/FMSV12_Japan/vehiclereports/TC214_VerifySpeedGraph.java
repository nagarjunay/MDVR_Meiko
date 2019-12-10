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
import com.test.automation.FMSV12_Japan.uiActions.VehicleReports_SpeedGraph;
import com.test.automation.FMSV12_Japan.utility.DatePicker;
import com.test.automation.FMSV12_Japan.utility.TotalNumOfRowsColumns;

/**
 * @author nagarjuna
 *
 */
public class TC214_VerifySpeedGraph extends TestBase {

	LoginPage loginpage;
	VehicleReports_SpeedGraph sg;
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
	public void speedGraphOption(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started--->Speed Graph Report Module");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		sg = new VehicleReports_SpeedGraph(driver);
		sg.SpeedGraph();
		sg.validation();
		datepicker = new DatePicker(driver);
		datepicker.FromData();
		datepicker.TODate();
		sg.Vehicle_Dropdown();
		/*table = new TotalNumOfRowsColumns(driver);
		table.Verifying_TotalNum_Of_Col_Rows()*/;
		log("=========>Finished--->Speed Graph Report Module");
	}

	
	
	
	
	
}
