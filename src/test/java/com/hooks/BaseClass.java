package com.hooks;

import org.openqa.selenium.WebDriver;

import com.genericlibrary.GenericFunctions;
import com.utils.DriverManager;

public class BaseClass {
	protected WebDriver driver;
	protected GenericFunctions genericFunctions;

	public BaseClass() {
		driver = DriverManager.getDriver();
		genericFunctions = new GenericFunctions(driver);

	}

}
