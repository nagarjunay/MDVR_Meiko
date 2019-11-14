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
import com.test.automation.FMSV12_Japan.uiActions.ColorCodeVerification;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;

/**
 * @author nagarjuna
 *
 */
public class TC005_VerifyingSubmitButtonColorAfterClick extends TestBase {

	public LoginPage login;
	ColorCodeVerification color;

	@BeforeClass
	@Parameters("Browser_Name")
	public void setUp(String Browser_Name) throws IOException {
		init(Browser_Name);

	}

	@Test
	public void verifySubmitButtonColor_AfterClick() throws Exception {
		log("=========>Started Verifying submit button color After click");
		login = new LoginPage(driver);
		login.loginToApplication("Hello", "");
		color = new ColorCodeVerification(driver);
		String hexcolor = color.ColorVerify("button[type='submit']", "background-color");
		System.out.println(hexcolor);
		String expected = "#1d943b";
		Assert.assertEquals(hexcolor, expected);
		log("Verifying submit button color: " + hexcolor);
		test.log(LogStatus.INFO, "Verifying submit button color: " + hexcolor);
		log("=========>Finished Verifying submit button color After click");

	}

}
