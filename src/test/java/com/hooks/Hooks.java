package com.hooks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.utils.CleanUtils;
import com.utils.DriverManager;
import com.utils.ExtentReportManager;
import com.utils.ScreenshotUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	@BeforeAll
	public static void createReport() {
		CleanUtils.cleanFolder("screenshots");
		CleanUtils.cleanFolder("downloads");
		ExtentReportManager.createExtentReport();
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new"); // mod
		DriverManager.launchBrowser(new ChromeDriver(options));
		System.out.println(getFeatureName(scenario) + scenario.getName() + " :: Test Started");
		ExtentReportManager.createTest(getFeatureName(scenario) + scenario.getName());
	}

	@After
	public void closeBrowser(Scenario scenario) {
		String testcaseName = getFeatureName(scenario) + scenario.getName();
		switch (scenario.getStatus()) {
		case PASSED:
			ExtentReportManager.pass(testcaseName + " Passed");
			break;

		case FAILED:
			String path = ScreenshotUtils.takeScreenshot(testcaseName);
			ExtentReportManager.addScreenshot(path);
			ExtentReportManager.fail(testcaseName + " Failed");
			break;

		case SKIPPED:
			ExtentReportManager.skip(testcaseName + " Skipped");
			break;

		default:
			ExtentReportManager.skip(testcaseName + " Unknown/Other status");
		}
		DriverManager.closeBrowser();
	}

	@AfterAll
	public static void publishReport() {
		ExtentReportManager.publishReport();
	}

	private String getFeatureName(Scenario scenario) {
		String uri = scenario.getUri().toString(); // e.g., "file:src/test/resources/features/login.feature"
		String[] parts = uri.split("[/.]");
		String feature = parts[parts.length - 2] + "_";

		return feature;
	}

}
