package com.test.automation.FMSV12_Japan.dashboard;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.UserProfile_ChangePassword;

/**
 * @author nagarjuna
 *
 */

public class TC101_VerifyUserProfile_ChangePassword extends TestBase {

	LoginPage loginpage;
	UserProfile_ChangePassword cp;

	/*@DataProvider
	public Object[][] getDataFromExcel() throws Exception {
		Object[][] data = Excel_Reader.read_excel("ChangePasswordData");// sheet name
		return data;
	}*/

	@BeforeClass
	@Parameters("Browser_Name")
	public void setUp(String Browser_Name) throws IOException {
		init(Browser_Name);
	}

	@Test
	public void a_verifyingChangePasswordValidation() throws Exception {
		
		log("=========>Started verify login");	
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication("Meiko", "welcome");
		log("=========>Finished verify login");
		cp = new UserProfile_ChangePassword(driver);
		cp.Mouse_over();
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(" English");
		list.add(" 日本語");
		list.add(" パスワード変更 ");
		list.add(" 全画面表示 ");
		list.add(" ヘルプ");
		list.add(" お問い合わせ");
		list.add(" ログアウト ");
		list.add(" Action");
		list.add(" Another action");
		list.add(" Something else here");
		list.add(" New release v1.2 30% 40% Complete ");
		list.add(" Separated link");
		log("=========>Started to click on Change Password option");
		@SuppressWarnings("unused")
		ArrayList<Object> drop_down_values = cp.Click_ChangePassword();
		log("=========>Clicked on Change password option");
		cp.VerifyChangePassword_Validation("demo", "", "");
	}
	
	@Test
	public void b_verifyingChangePasswordValidation() throws Exception {
		
		cp.VerifyChangePassword_Validation("demo", "fsfdg", "");
	}
	
	@Test
	public void c_verifyingChangePasswordValidation() throws Exception {
		
		cp.VerifyChangePassword_Validation("de123123", "", "3@!@#!#");
	}
	
	@Test
	public void d_verifyingChangePasswordValidation() throws Exception {
		
		cp.VerifyChangePassword_Validation("de123123", "welcome", "welcome");
		cp.VerifyValidationMessage();
	}
	
	/*@Test(priority=5)
	public void VerifyingChangePasswordValidation_Type5() throws Exception {
		
		cp.VerifyChangePassword_Validation("welcome", "welcome123", "welcome123");
		cp.VerifyValidationMessage1();
	}
	*/
	
}
