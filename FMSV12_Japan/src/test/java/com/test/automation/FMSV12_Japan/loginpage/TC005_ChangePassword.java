package com.test.automation.FMSV12_Japan.loginpage;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.ChangePassword;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;

/**
 * @author nagarjuna
 *
 */

public class TC005_ChangePassword extends TestBase {

	public static final Logger log = Logger.getLogger(TC005_ChangePassword.class.getName());

	LoginPage loginpage;
	ChangePassword cp;

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

	@SuppressWarnings("unused")
	@Test(dataProvider = "getDataFromExcel")
	public void changePassword(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started to click on Change Password option");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		cp = new ChangePassword(driver);
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
		ArrayList<Object> drop_down_values = cp.Click_ChangePassword();
		log("=========>Clicked on Change password option");
		Thread.sleep(3000);
		cp.changepassword_validation();
	}

}