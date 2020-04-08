/**
 * 
 */
package com.wallethub.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.wallethub.base.BaseTest;

/**
 * @author Pritesh_Bende
 *
 *         08-Apr-2020
 */
public class TestUtil extends BaseTest {

	/**
	 * Takes screenshot whenever called
	 * 
	 * @throws IOException
	 */
	public static String takeScreenshot(ITestResult result) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// Convert web driver instance to Take Screenshot interface and call
		// getScreenshotAs method to create image file
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String base64 = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		String destination = System.getProperty("user.dir") + "/screenshots/" + result.getName() + "_" + dateName
				+ ".png";
		File destinationFile = new File(destination);
		try {
			FileUtils.copyFile(srcFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destination;
	}

}
