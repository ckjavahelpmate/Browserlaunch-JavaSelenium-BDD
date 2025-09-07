package com.hooks;

import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.genericlibrary.GenericFunctions;
import com.utils.DriverManager;

import io.cucumber.java.Scenario;


public class BaseClass {
	protected WebDriver driver ;
	protected GenericFunctions genericFunctions ;
	protected JsonNode data ;
	public BaseClass(Scenario scenario) {
		driver = DriverManager.getDriver();
		genericFunctions = new GenericFunctions(driver);
		data = DataUtility.getScenarioData();
	}
	
	
}
