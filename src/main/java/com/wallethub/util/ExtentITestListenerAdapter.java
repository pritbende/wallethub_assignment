/**
 * 
 */
package com.wallethub.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Pritesh_Bende
 *
 * 08-Apr-2020
 */
public class ExtentITestListenerAdapter {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports setExtent() {

		if(extent == null) {
			// location of the report
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/ExtentReport.html");
			htmlReporter.config().setDocumentTitle("Extent Report"); // Tile of report
			htmlReporter.config().setReportName("WalletHub Project"); // Name of the report
			htmlReporter.config().setTheme(Theme.STANDARD);
	
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("User Name", "Pritesh Bende");
			extent.setSystemInfo("Enviorment", "Local");
			extent.setSystemInfo("HostName", "Pritesh-PC");
			
			return extent;
		}
		else
			return extent;
	}

}
