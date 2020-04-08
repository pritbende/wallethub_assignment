/**
 * 
 */
package com.wallethub.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pritesh_Bende
 *
 * 08-Apr-2020
 */
public class FBHomePage {
	
	WebDriver driver;
	private static Logger log = Logger.getLogger(FBHomePage.class);
	
	public FBHomePage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		driver = wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Create Post']")
	WebElement createPost_Btn;
	
	@FindBy(xpath = "//div[@class='_1mf _1mj']")
	WebElement enterPost_Txt;
	
	@FindBy(xpath = "//span[text()='Post']")
	WebElement post_Btn;
	
	@FindBy(xpath = "//a[@title='Profile']")
	WebElement myProfile_Lnk;
	
	@FindBy(xpath = "//div[@data-testid='post_message']")
	List<WebElement> myPost_List;
	
	/**
	 * Create facebook post
	 * @param postText
	 * @throws InterruptedException 
	 */
	public void createPost(String postText) throws InterruptedException {
		log.info("Click Create Post button");
		createPost_Btn.click();
		log.info("Write post");
		enterPost_Txt.sendKeys(postText);
		log.info("Submit post");
		post_Btn.click();
		Thread.sleep(5000);
	}
	
	/**
	 * Get text from latest post
	 * @return text retrived from latest post
	 */
	public String getMyPostText() {
		log.info("Click profile link");
		myProfile_Lnk.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pagelet_timeline_profile_actions")));
		String text = myPost_List.get(0).getText();
		log.info("Text from post: " + text);
		return text;
	}

}
