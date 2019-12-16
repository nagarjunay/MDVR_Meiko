/**
 * 
 */
package com.test.automation.FMSV12_Japan.trackonmap;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.TrackOnMap_AlertStatus;

/**
 * @author nagarjuna
 *
 */
public class TC302_VerifyTrackOnMap_AlertStatus extends TestBase {
	
	LoginPage loginpage;
	TrackOnMap_AlertStatus tmas;
	
	
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
	public void verifyTrackOnMapAlertStatus(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started--->Track On Map Alert Status Module");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		tmas = new TrackOnMap_AlertStatus(driver);
		tmas.VehicleStatus();
		log("=========>Finished--->Track On Map Alert Status Module");
	}

}
