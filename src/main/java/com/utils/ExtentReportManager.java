package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	private static ExtentReports extentReports ;
	private static ThreadLocal<ExtentTest> tests = new ThreadLocal<>();
	
	
	public static void createExtentReport() 
	{
		String path = "reports/extent-report.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setDocumentTitle("Automation suite Result");
		extentSparkReporter.config().setReportName("Automation Execution Result");
		extentSparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Executed Suite", "Automation suite");
	}
	
	
	public static void createTest(String testname) {
		ExtentTest test = extentReports.createTest(testname);
		tests.set(test);
	}

	public static void info(String message) {
		tests.get().log(Status.INFO, message);
	}

	public static void pass(String message) {
		tests.get().log(Status.PASS, message);
	}

	public static void fail(String message) {
		tests.get().log(Status.FAIL, message);
	}

	public static void skip(String message) {
		tests.get().log(Status.SKIP, message);
	}

	public static void addScreenshot(String path) {
		tests.get().addScreenCaptureFromPath(path);
	}

	public static void publishReport() {
		extentReports.flush();
	}

}
