
package com.test.automation.FMSV12_Japan.loginpage;

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

public class TC001_Verifylogin extends TestBase {

	LoginPage loginpage;

	@DataProvider
	public Object[][] getDataFromExcel() throws Exception {
		Object[][] data = Excel_Reader.read_excel("LoginData");// sheet name
		return data;
	}

	@BeforeClass
	@Parameters("Browser_Name")
	public void setUp(String Browser_Name) throws IOException {
		init(Browser_Name);

	}

	@Test(dataProvider = "getDataFromExcel")
	public void verifyLogin(String loginid, String password, String xpath, String expected_message, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started verify login");
		loginpage = new LoginPage(driver);
		/*
		 * String lcs=LoginData.credentials().get("LoginCredentials1"); String
		 * logininfo[]=lcs.split("_");
		 */
		loginpage.loginToApplication1(loginid, password, xpath, expected_message);
		LoginPage.verify_error_message(xpath, expected_message);
		log("=========>Finished verify login");
	}

}
