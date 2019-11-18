/**
 * 
 */
package com.test.automation.FMSV12_Japan.dashboard;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.Dashboard_CurrentFleet;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;

/**
 * @author nagarjuna
 *
 */
public class TC114_VerfiyCurrentFleet_ToolTipText extends TestBase {

	LoginPage loginpage;
	Dashboard_CurrentFleet fleet;

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
	public void verifyCureentFleet_ToolTip(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started login into application");
		test.log(LogStatus.INFO, "Started login into application");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		log("=========>Finished login into application");
		test.log(LogStatus.INFO, "Finished login into application");
		
		log("=========>Started verifying current fleet pie chart tootip");
		test.log(LogStatus.INFO, "Started verifying current fleet pie chart tootip");
		fleet = new Dashboard_CurrentFleet(driver);
		fleet.CurrentFleet_Piechat_Mouseover();
		log("=========>Finished verifying current fleet pie chart tootip");
		test.log(LogStatus.INFO, "Finished verifying current fleet pie chart tootip");

		
	}
	
	
	
}
