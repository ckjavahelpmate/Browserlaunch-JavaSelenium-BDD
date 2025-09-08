package com.hooks;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.utils.CleanUtils;
import com.utils.DriverManager;
import com.utils.ScreenshotUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	@BeforeAll
	public static void createReport() {
		CleanUtils.cleanFolder("screenshots");
		CleanUtils.cleanFolder("downloads");
	}

	@Before
	public void beforeScenario() {
		ChromeOptions options = new ChromeOptions();
		DriverManager.launchBrowser(new ChromeDriver(options));
	}

	@After
	public void closeBrowser(Scenario scenario) {
		String testcaseName = getFeatureName(scenario) + scenario.getName();
		if (scenario.getStatus().toString().equals("FAILED")) {
			String filename = ScreenshotUtils.takeScreenshot(testcaseName);
			System.out.println(filename);
			try {
				ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		DriverManager.closeBrowser();
	}

	private String getFeatureName(Scenario scenario) {
		String uri = scenario.getUri().toString(); // e.g., "file:src/test/resources/features/login.feature"
		String[] parts = uri.split("[/.]");
		String feature = parts[parts.length - 2] + "_";

		return feature;
	}

}
