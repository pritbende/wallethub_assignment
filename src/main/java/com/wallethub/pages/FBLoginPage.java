/**
 * 
 */
package com.wallethub.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.varia.FallbackErrorHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Pritesh_Bende
 *
 * 08-Apr-2020
 */
public class FBLoginPage {
	
	WebDriver driver;
	private static Logger log = Logger.getLogger(FBLoginPage.class);
	
	public FBLoginPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		driver = wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	WebElement email_Txt;

	@FindBy(id = "pass")
	WebElement password_Txt;
	
	@FindBy(id = "loginbutton")
	WebElement login_Btn;
	
	/** Login to Facebook with valid username & password
	 * @param email
	 * @param password
	 * @return
	 */
	public FBHomePage doLogin(String email, String password) {
		log.info("Enter email");
		email_Txt.sendKeys(email);
		log.info("Enter password");
		password_Txt.sendKeys(password);
		log.info("Click login button");
		login_Btn.click();
		return new FBHomePage(driver);
	}
}
