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
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.LogoVerification;

public class TC105_VerifyingDashboardLogo extends TestBase {

	public static final Logger log = Logger.getLogger(TC105_VerifyingDashboardLogo.class.getName());

	LoginPage loginpage;
	LogoVerification logo;

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
	public void verifyDashboardLogo(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started Verifying logo");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		logo = new LogoVerification(driver);
		logo.VerifyDashboardlogo();
		log("=========>Finished Verifying logo");

	}

}
