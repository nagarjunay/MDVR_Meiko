/**
 * 
 */
package com.test.automation.FMSV12_Japan.loginpage;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LogoVerification;

/**
 * @author nagarjuna
 *
 */
public class TC002_VerifyLoginPageMeikoLogo extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC002_VerifyLoginPageMeikoLogo.class.getName());

	
	LogoVerification logo;

	@BeforeClass
	@Parameters("Browser_Name")
	public void setUp(String Browser_Name) throws IOException {
		init(Browser_Name);

	}

	@Test
	public void verifyMeikoLogo() throws Exception {
		log("=========>Started Verifying Login page Meiko logo");
		logo = new LogoVerification(driver);
		logo.VerifyDashboardlogo();
		log("=========>Finished Verifying Login page Meiko logo");

	}
	
	
	
}
