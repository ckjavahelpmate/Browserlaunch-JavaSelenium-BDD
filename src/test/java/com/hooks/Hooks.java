package com.hooks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
//		if (scenario.getStatus().toString().equals("FAILED")) {
		scenario.attach(ScreenshotUtils.takeScreenshot(), "image/png", "");
//		}
		DriverManager.closeBrowser();
	}

}
