/**
 * 
 */
package com.wallethub.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.wallethub.util.ExtentITestListenerAdapter;


/**
 * @author Pritesh_Bende
 *
 * 08-Apr-2020
 */
public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	private static Logger log = Logger.getLogger(BaseTest.class);
	public static ExtentReports extent; 
	
	/**
	 * Constructor
	 */
	public BaseTest() {
		
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Setup the browser and navigate to url
	 */
	public static void init(String url) {
		
		String browser = prop.getProperty("browser");
		extent = ExtentITestListenerAdapter.setExtent();
		switch (browser) {
		case "chrome":
			log.info("************Initializing browser: " + browser + "************");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver(options);
			break;
			
		default:
			System.out.println("Invalid browser specified");
			break;
		}
		
		driver.manage().window().maximize();
		log.info("Navigating to url: " + url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	/**
	 * This will terminate browser instance
	 */
	public static void tearDown() {
		extent.flush();
		if(driver!=null)
			driver.quit();
	}

}
