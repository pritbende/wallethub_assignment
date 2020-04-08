/**
 * 
 */
package com.wallethub.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pritesh_Bende
 *
 * 08-Apr-2020
 */
public class WalletHubHomePage {
	
	WebDriver driver;
	private static Logger log = Logger.getLogger(WalletHubHomePage.class);
	
	public WalletHubHomePage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		driver = wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='brgm-button brgm-signup']")
	WebElement loginSignUp_Btn;
	
	@FindBy(name = "em")
	WebElement email_Txt;
	
	@FindBy(name = "pw")
	WebElement password_Txt;
	
	@FindBy(xpath = "//span[text()='Login']")
	WebElement login_Btn;
	
	@FindBy(xpath = "//a[@href='/profile/test-insurance-company-13732055i#reviews']")
	WebElement reviews_Link;
	
	@FindBy(xpath = "//*[@class='review-action ng-enter-element']//*[name()='svg']")
	List<WebElement> reviewStar;
	
	@FindBy(xpath = "//*[@class='dropdown second']")
	WebElement dropdown;
	
	@FindBy(xpath = "//*[@class='dropdown second opened']/ul/li")
	List<WebElement> selectType;
	
	@FindBy(xpath = "//*[@class='android']/textarea")
	WebElement writeReview;
	
	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit_Btn;
	
	@FindBy(xpath = "//*[@class='btn rvc-continue-btn']")
	WebElement continue_Btn;
	
	@FindBy(xpath = "(//*[@class='brgm-list-title'])[5]")
	WebElement profile_Menu;
	
	@FindBy(xpath = "//a[@class='brgm-list-it' and text()='Profile']")
	WebElement profile_Btn;
	
	@FindBy(xpath = "//div[@class='pr-rec-container']")
	List<WebElement> myReview_List;
	
	
	/**
	 * This will login to the walletHub account and return homePage object
	 * @param email
	 * @param password
	 * @return
	 */
	public void doLogin(String email, String password) {
		log.info("Enter email");
		loginSignUp_Btn.click();
		email_Txt.sendKeys(email);
		log.info("Enter password");
		password_Txt.sendKeys(password);
		log.info("Click login");
		login_Btn.click();
	}
	
	public void navigateTo(String url) {
		log.info("Navigate to: " + url);
		driver.navigate().to(url);
	}
	
	public void clickReviews() throws InterruptedException {
		log.info("Click reviews");
		reviews_Link.click();
		Thread.sleep(3000);
	}
	
	public void clickRatingStar(int number) {
		log.info("Hove and click on fourth star: ");
		Actions action = new Actions(driver);
		action.moveToElement(reviewStar.get(number-1));
		action.click().build().perform();
	}

	public void selectDropdown(int number) {
		log.info("Select Health Insurance from dropdown");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		dropdown.click();
		selectType.get(number).click();
	}
	
	public void writeReview(String statement) {
		log.info("Enter text in review area");
		writeReview.sendKeys(statement);
		log.info("Click Submit button");
		submit_Btn.click();
	}
	
	public boolean viewMyReview() {
		log.info("Click Profile link");
		Actions action = new Actions(driver);
		action.moveToElement(profile_Menu);
		action.click().build().perform();
		profile_Btn.click();
		int rNumber = myReview_List.size();
		if(rNumber > 0)
			return true;
		else
			return false;
		
	}
}
