package com.stepdefinitions;

import com.hooks.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BaseClass {

	@When("Navigate to {string}")
	public void navigateToUrl(String url) {
		driver.get(url);
	}

	@And("Wait for {int} seconds")
	public void waitForSeconds(Integer seconds) {
		try {
			Thread.sleep(seconds*100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Verify page title to be {string}")
	public void verifyPageTitleToBe(String expectedTitle) {
		genericFunctions.verifyPageTitle(expectedTitle);
	}

}
