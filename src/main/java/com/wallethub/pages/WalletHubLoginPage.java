/**
 * 
 */
package com.wallethub.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pritesh_Bende
 *
 * 08-Apr-2020
 */
public class WalletHubLoginPage {
	
	WebDriver driver;
	private static Logger log = Logger.getLogger(WalletHubLoginPage.class);
	
	public WalletHubLoginPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		driver = wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "em")
	WebElement email_Txt;
	
	@FindBy(name = "pw")
	WebElement password_Txt;
	
	@FindBy(xpath = "//span[text()='Login']")
	WebElement login_Btn;
	
	
	
	/**
	 * This will login to the walletHub account and return homePage object
	 * @param email
	 * @param password
	 * @return
	 */
	public WalletHubHomePage doLogin(String email, String password) {
		log.info("Enter email");
		email_Txt.sendKeys(email);
		log.info("Enter password");
		password_Txt.sendKeys(password);
		log.info("Click login");
		login_Btn.click();
		return new WalletHubHomePage(driver);
	}

}
