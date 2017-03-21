package com.bbcFood.features.steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bbcFood.features.support.pageobjects.HomePage;
import com.bbcFood.features.support.pageobjects.RecipesPage;
import com.bbcFood.features.support.util.DriverFactory;
import com.bbcFood.features.support.util.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;

public class HomePageSteps extends DriverFactory {
	
	
	WebDriverWait wait = new WebDriverWait(getDriver(),20);	
	

	@When("^I use the quick search to find \"([^\"]*)\" recipe$")
	public void iUseTheQuickSearchToFindRecipe(String pSearch) throws Throwable {
	    new HomePage(getDriver()).useQRecipeFinderToSearch(pSearch);
	}

	@Then("^I should see a Results Page with a list of recipe matching \"([^\"]*)\" search query$")
	public void searchResultContain(String query) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(new RecipesPage(getDriver()).filterResults));
		new RecipesPage(getDriver()).verifyResultsPage();
		
		RecipesPage recipesPage = new RecipesPage(getDriver());
		assertTrue(recipesPage.getQueryResults().get(0).contains(query));
		assertTrue(recipesPage.getQueryResults().get(0).contains(query));
	   
	}
		   
	
}

