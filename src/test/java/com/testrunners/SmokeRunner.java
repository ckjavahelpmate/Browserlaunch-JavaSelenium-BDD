package com.testrunners;

import org.testng.annotations.DataProvider;

import com.utils.DataUtility;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.stepdefinitions",
		"com.hooks" }, tags = "@smoke", plugin = { "html:reports/regression-report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)
public class SmokeRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		System.setProperty("dataproviderthreadcount", DataUtility.getProperty("threadCount"));
		return super.scenarios();
	}

}
