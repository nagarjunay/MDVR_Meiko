/**
 * 
 */
package com.test.automation.FMSV12_Japan.loginpage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.utility.ColorCodeVerification;

/**
 * @author nagarjuna
 *
 */
public class TC003_VerfyingSubmitButtonColorCode extends TestBase {

	public LoginPage login;
	ColorCodeVerification color;

	@BeforeClass
	@Parameters("Browser_Name")
	public void setUp(String Browser_Name) throws IOException {
		init(Browser_Name);

	}

	@Test
	public void a_VerifyRememberMe_CheckBox() {
		log("=========>Started Verifying Remember me check box is checked");
		login = new LoginPage(driver);
		login.remeberMe();
		log("=========>Started Verifying Remember me check box is checked");
	}

	@Test
	public void b_verifySubmitButtonColor_BeforeClick() throws Exception {
		log("=========>Started Verifying submit button color Before click");
		color = new ColorCodeVerification(driver);
		String hexcolor = color.ColorVerify("button[type='submit']", "background-color");
		System.out.println(hexcolor);
		String expected = "#253a73";
		Assert.assertEquals(hexcolor, expected);
		log("Verifying submit button color: " + hexcolor);
		test.log(LogStatus.INFO, "Verifying submit button color: " + hexcolor);
		log("=========>Finished Verifying submit button color Before click");
	}

}
