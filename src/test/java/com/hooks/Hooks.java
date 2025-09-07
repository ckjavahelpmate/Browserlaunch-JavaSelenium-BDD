package com.hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import com.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void launchBrowser() {
		DriverManager.launchBrowser(new ChromeDriver());
	}

	@After
	public void closeBrowser() {
		DriverManager.closeBrowser();
	}

}
