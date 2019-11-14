package com.test.automation.FMSV12_Japan.dashboard;

/**
 * @author nagarjuna
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.FMSV12_Japan.excelReader.Excel_Reader;
import com.test.automation.FMSV12_Japan.testBase.TestBase;
import com.test.automation.FMSV12_Japan.uiActions.LoginPage;
import com.test.automation.FMSV12_Japan.uiActions.UserProfile_DropDown;

public class TC104_Verify_UserProfileMenu extends TestBase {

	
	LoginPage loginpage;
	UserProfile_DropDown up;

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
	public void userProfile(String loginid, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this not to run");
		}
		log("=========>Started User Profile Dropdown");
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication(loginid, password);
		up = new UserProfile_DropDown(driver);
		up.Mouse_over();
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(" 英語");
		list.add(" 日本語");
		list.add(" パスワード変更 ");
		list.add(" 全画面表示 ");
		list.add(" ヘルプ");
		list.add(" お問い合わせ");
		list.add(" ログアウト ");
		list.add(" Action");
		list.add(" Another action");
		list.add(" Something else here");
		list.add(" New release v1.2 30% 40% Complete");
		list.add(" Separated link");
		up = new UserProfile_DropDown(driver);
		ArrayList<Object> drop_down_values = up.verify_drop_down();
		System.out.println("List Values are " + drop_down_values);
		Assert.assertEquals(drop_down_values, list);
		log("=========>Finished User Profile Dropdown");
	}

}











	
 

                        




    






