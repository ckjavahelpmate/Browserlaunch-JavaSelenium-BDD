package com.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GenericFunctions {

	private WebDriver driver;

	public GenericFunctions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void verifyPageTitle(String expectePageTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectePageTitle));
	}

}
