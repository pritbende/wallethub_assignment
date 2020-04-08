/**
 * 
 */
package com.wallethub.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

/**
 * @author Pritesh_Bende
 *
 *         08-Apr-2020
 */
public class TestListener extends ExtentITestListenerAdapter implements ITestListener {

	private static Logger log = Logger.getLogger(TestListener.class);

	public void onTestStart(ITestResult result) {
		log.info("=================Test Started: " + result.getMethod().getMethodName() + "=================");
		test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("=================Test Success: " + result.getMethod().getMethodName() + "=================");
		test.log(Status.PASS, "Test passed");
	}

	public void onTestSkipped(ITestResult result) {
		log.info("=================Test Skipeed: " + result.getMethod().getMethodName() + "=================");
		test.log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailure(ITestResult result) {
		log.error(result.getThrowable());
		log.error("=================Test Failed: " + result.getMethod().getMethodName() + "=================");
		test.log(Status.FAIL, "Test Failed");
		test.error(result.getThrowable());
		MediaEntityModelProvider mediaModel;
		try {
			mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshot(result)).build();
			test.log(Status.FAIL, "Refer Screenshot", mediaModel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
