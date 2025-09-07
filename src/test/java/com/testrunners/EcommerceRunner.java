package com.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/ecommerce",
		glue = { "com.stepdefinitions", "com.hooks" },
		
		monochrome = true)
public class EcommerceRunner extends AbstractTestNGCucumberTests {

}
