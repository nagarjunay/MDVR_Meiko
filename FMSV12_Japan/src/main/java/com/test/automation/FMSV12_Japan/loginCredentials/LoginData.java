package com.test.automation.FMSV12_Japan.loginCredentials;

/**
 * @author nagarjuna
 *
 */

import java.util.HashMap;

public class LoginData {

	public static HashMap<String, String> credentials() {
		HashMap<String, String> loginData = new HashMap<String, String>();
		loginData.put("LoginCredentials", "Test_test1");
		loginData.put("LoginCredentials1", " _Test");
		return loginData;
	}
}
