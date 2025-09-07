package com.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/socialmedia",
		glue = { "com.stepdefinitions", "com.hooks" },
				plugin = {"summary", "html:reports/socialmedia-report.html"},
		monochrome = true)
public class SocialMediaRunner extends AbstractTestNGCucumberTests {

}
