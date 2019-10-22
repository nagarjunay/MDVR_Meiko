/**
 * 
 */
package com.test.automation.FMSV12_Japan.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.FMSV12_Japan.testBase.TestBase;

/**
 * @author nagarjuna
 *
 */
public class ColorCodeVerification extends TestBase {
	
	public static final Logger log = Logger.getLogger(ColorCodeVerification.class.getName());

	public static WebDriver driver;

	public ColorCodeVerification(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String ColorVerify(String cssSelector, String cssValue)
	{
		/* This method used to verify color code*/
		WebElement target = driver.findElement(By.cssSelector(cssSelector));
		String colorCode= target.getCssValue(cssValue);
		String hexacolor = Color.fromString(colorCode).asHex();
		return hexacolor;
		
	}

}
