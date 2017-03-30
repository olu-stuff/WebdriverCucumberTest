package com.bbcFood.features.steps;

import com.bbcFood.features.support.pageobjects.HomePage;
import com.bbcFood.features.support.util.DriverFactory;
import com.bbcFood.features.support.util.PropertyReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StartingSteps extends DriverFactory {

	String url = new PropertyReader().readProperty("url");

	@Before
	public void beforeScenario() {
		new DriverFactory().getDriver();
		// System.out.println("this will run before the actual scenario");
	}

	@After
	public void afterScenario() {
		new DriverFactory().destroyDriver();
		// System.out.println("this will run after scenario is finished, even if
		// it failed");
	}

	@Given("^am on the BBC food hompage$")
	public void amOnTheBBCFoodHompage() throws Throwable {
		getDriver().get(url);
		new HomePage(getDriver()).verifyPage();
	}

	@When("^I click on the Recipes tab$")
	public void iClickOnTheRecipesTab() throws Throwable {
	//	new HomePage(getDriver()).foodMainMenu.get(1).click();
	}

}
