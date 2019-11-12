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
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;

/**
 * @author nagarjuna
 *
 */
public class TC004_VerfiyForgotPassword extends TestBase {

	public static final Logger log = Logger.getLogger(TC004_VerfiyForgotPassword.class.getName());

	LoginPage login;

	@BeforeClass
	@Parameters("Browser_Name")
	public void setUp(String Browser_Name) throws IOException {
		init(Browser_Name);

	}

	@Test
	public void verifyForgotPassword() throws Exception {
		log("=========>Started Verifying Remember Me check box");
		login = new LoginPage(driver);
		login.forgotPassword();
		log("=========>Finished Verifying Remember Me check box ");
	}

	@Test
	public void verifyForgotPasswordwith_InvalidMailId() throws Exception {
		log("=========>Started Verifying Invalid mail Id");
		login = new LoginPage(driver);
		login.forgotPassword1();
		log("=========>Finished Verifying Invalid mail Id");
	}
	
	@Test
	public void verifyForgotPasswordwith_ValidMailId() throws Exception {
		log("=========>Started Verifying Valid mail Id");
		login = new LoginPage(driver);
		login.forgotPassword2();
		log("=========>Finished Verifying Valid mail Id");
	}
}
