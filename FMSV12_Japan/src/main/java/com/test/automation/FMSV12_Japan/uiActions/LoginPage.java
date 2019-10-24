package com.test.automation.FMSV12_Japan.uiActions;

/**
 * @author nagarjuna
 *
 */

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

public class LoginPage extends TestBase {

	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	static WebDriver driver;

	/*
	 * @FindBys({
	 * 
	 * @FindBy(id = "username"),
	 * 
	 * @FindBy(xpath = "//*[@id=\"usernamee\"]") }) WebElement loginId;
	 */

	@FindAll({ @FindBy(id = "username"), @FindBy(xpath = "//*[@id='usernamee']") })
	WebElement loginId;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement loginPassword;

	@FindBy(css = "button[type='submit']")
	WebElement submitButton;

	@FindBy(css = "a[id='forget-password']")
	WebElement forgotPass;

	@FindBy(css = "input[id='email']")
	WebElement email;
	
	@FindBy(css = "body > div.content > form.forget-form > div.form-actions > button.btn.green.pull-right")
	WebElement forgotpassSubmitButton;
	
	@FindBy(css = "body > div.content > form.forget-form > div.form-group.has-error > span")
	WebElement emailisrequired;
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication1(String loginid, String password, String xpath, String expected_message)
			throws InterruptedException {

		log.info("Login page Title: " + driver.getTitle());
		test.log(LogStatus.INFO, "Login page Title: " + driver.getTitle());
		loginId.clear();
		loginId.sendKeys(loginid);
		log("Entered login id====>>" + loginid + " and object is" + loginId.toString());
		test.log(LogStatus.INFO, "Entered login id is====>>" + loginid);
		loginPassword.clear();
		loginPassword.sendKeys(password);
		log("Entered password====>>" + password + " and object is" + loginPassword.toString());
		test.log(LogStatus.INFO, "Entered password is====>>" + password);
		expliciteWait(submitButton, 20);
		submitButton.click();
		log("Clicked on submit button is" + submitButton.toString());
		test.log(LogStatus.INFO, "Clicked on submit button");
		log("Button text: " + submitButton.getAttribute("innerHTML"));
		test.log(LogStatus.INFO, "Button text: " + submitButton.getAttribute("innerHTML"));
		

	}

	public void loginToApplication(String loginid, String password) throws InterruptedException {

		loginId.clear();
		loginId.sendKeys(loginid);
		log("Entered login id====>>" + loginid + " and object is" + loginId.toString());
		test.log(LogStatus.INFO, "Entered login id is====>>" + loginid);
		loginPassword.clear();
		loginPassword.sendKeys(password);
		log("Entered password====>>" + password + " and object is" + loginPassword.toString());
		test.log(LogStatus.INFO, "Entered password is====>>" + password);
		expliciteWait(submitButton, 20);
		submitButton.click();
		log("Clicked on submit button is" + submitButton.toString());
		test.log(LogStatus.INFO, "Clicked on submit button");
		

	}

	public void remeberMe() {
		WebElement Checkbox = driver.findElement(By.cssSelector("div[class='checker']"));
		if (Checkbox.isEnabled()) {
			Checkbox.click();
		} else {
			System.out.println("Checked 'Remember Me' checkbox as it is unchecked.");
		}
		log("Checked 'Remember Me' checkbox as it is unchecked" + Checkbox.toString());
		test.log(LogStatus.INFO, "Checked 'Remember Me' checkbox as it is unchecked" + Checkbox.toString());
		//return LoginPage;
	}

	public void forgotPassword() {
		forgotPass.click();
		log("Clicked on forgot password hyper link id====>>" + forgotPass + " and object is" + forgotPass.toString());
		test.log(LogStatus.INFO, "Clicked on forgot password hyper link id====>>" + forgotPass);
		//expliciteWait(forgotpassSubmitButton, 40);
		forgotpassSubmitButton.click();
		log("Clicked on submit button id====>>" + forgotpassSubmitButton + " and object is" + forgotpassSubmitButton.toString());
		test.log(LogStatus.INFO, "Clicked on submit button id====>>" + forgotpassSubmitButton);
		String actual_error= driver.findElement(By.cssSelector("body > div.content > form.forget-form > div.form-group.has-error > span")).getText();
	    String expected_error="Eメールは必須です。";
	    Assert.assertEquals(actual_error, expected_error);
	}  
	
	public void forgotPassword1() {
	    email.clear();
	    email.sendKeys("12345@info");
	    log("Entered invaid email id====>>" + email + " and object is" + email.toString());
		test.log(LogStatus.INFO, "Entered invaid email id is====>>" + email);
		forgotpassSubmitButton.click();
		log("Clicked on submit button id====>>" + forgotpassSubmitButton + " and object is" + forgotpassSubmitButton.toString());
		test.log(LogStatus.INFO, "Clicked on submit button id====>>" + forgotpassSubmitButton);
	    String actual_error1= driver.findElement(By.cssSelector("body > div.content > form.forget-form > div.form-group.has-error > span")).getText();
	    String expected_error1="Please enter a valid Email-id";
	    Assert.assertEquals(actual_error1, expected_error1);
	}
	public void forgotPassword2() {
	    email.clear();
	    email.sendKeys("nagarjuna@infotracktelematics.com");
	    log("Entered invaid email id====>>" + email + " and object is" + email.toString());
		test.log(LogStatus.INFO, "Entered invaid email id is====>>" + email);
		forgotpassSubmitButton.click();
		log("Clicked on submit button id====>>" + forgotpassSubmitButton + " and object is" + forgotpassSubmitButton.toString());
		test.log(LogStatus.INFO, "Clicked on submit button id====>>" + forgotpassSubmitButton);
	    String actual_error2= driver.findElement(By.cssSelector("body > div.content > form.login-form > div.alert.alert-danger > span")).getText();
	    String expected_error2="Your EmailId (nagarjuna@infotracktelematics.com)has not been configured.";
	    Assert.assertEquals(actual_error2, expected_error2);
	
	}

	public static void verify_error_message(String xpathExpression, String expected_message) {
		String actual_msg = driver.findElement(By.xpath(xpathExpression)).getText();
		Assert.assertEquals(actual_msg, expected_message);
	}

	public boolean getLoginSuccess() {

		try {
			driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[2]/span")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public void log(String data) {

		log.info(data);
		Reporter.log(data);
	}

}
