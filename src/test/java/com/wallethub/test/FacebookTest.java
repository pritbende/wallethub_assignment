package com.wallethub.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wallethub.base.BaseTest;
import com.wallethub.pages.FBHomePage;
import com.wallethub.pages.FBLoginPage;

public class FacebookTest extends BaseTest {

	FBLoginPage lp;
	FBHomePage hp;
	
	@BeforeClass
	public void setup() {
		init(prop.getProperty("FBurl"));
		lp = new FBLoginPage(driver);
	}
	
	@Test(description = "Login to facebook account, create post and verify in profile")
	public void CreateFacebookPost_Test() throws InterruptedException {
		String postText = "This is text from automation";
		hp = lp.doLogin(prop.getProperty("FBemail"), prop.getProperty("FBpassword"));
		hp.createPost(postText);
		
		Assert.assertEquals(hp.getMyPostText(), postText);
	}
	
	@AfterClass
	public void quitBrowser() {
		tearDown();
	}
}
