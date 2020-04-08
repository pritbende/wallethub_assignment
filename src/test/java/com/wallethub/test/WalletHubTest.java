package com.wallethub.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wallethub.base.BaseTest;
import com.wallethub.pages.WalletHubHomePage;

public class WalletHubTest extends BaseTest {

	WalletHubHomePage whp;
	
	@BeforeClass
	public void setup() {
		init(prop.getProperty("WHurl"));
		whp = new WalletHubHomePage(driver);
	}
	
	@Test(description = "Login to WalletHub account and post a review and verfiy via Profile")
	public void reviewSubmitSuccess_Test() throws InterruptedException {
		String reviewText = "This is the review for Health Insurance. This is the review for Health Insurance. "
				+ "This is the review for Health Insurance. This is the review for Health Insurance. "
				+ "This is the review for Health Insurance. ";
		whp.doLogin(prop.getProperty("WHemail"), prop.getProperty("WHpassword"));
//		whp.clickReviews();
//		whp.clickRatingStar(4);
//		whp.selectDropdown(1);
//		whp.writeReview(reviewText);
		Thread.sleep(5000);
		
		Assert.assertTrue(whp.viewMyReview());
	}
	
	@AfterClass
	public void quitBrowser() {
		tearDown();
	}
}
