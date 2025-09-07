package com.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/food",
		glue = { "com.stepdefinitions", "com.hooks" },
				plugin = {"summary", "html:reports/food-report.html"},
		monochrome = true)
public class FoodRunner extends AbstractTestNGCucumberTests {

}
