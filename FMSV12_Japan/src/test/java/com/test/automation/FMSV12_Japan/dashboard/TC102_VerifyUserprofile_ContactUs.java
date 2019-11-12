/**
 * 
 */
package com.test.automation.FMSV12_Japan.dashboard;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.UserProfile_Help;

/**
 * @author nagarjuna
 *
 */
public class TC102_VerifyUserprofile_ContactUs extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC102_VerifyUserprofile_ContactUs.class.getName());

	LoginPage loginpage;
	UserProfile_Help User_Help;

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
	public void Verifying_ContactUS_PopWindow() throws Exception {
		
		log("=========>Started verify login");	
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication("Meiko", "welcome");
		log("=========>Finished verify login");
		User_Help = new UserProfile_Help(driver);
		User_Help.Mouse_over();
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
		log("=========>Started to click on Contact Us option");
		@SuppressWarnings("unused")
		ArrayList<Object> drop_down_values = User_Help.ContantUs();
		log("=========>Clicked on Contact Us option");
		User_Help.VerifyContactUs();
		
	
	}

}
