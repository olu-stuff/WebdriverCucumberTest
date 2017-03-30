package com.bbcFood.features.steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bbcFood.features.support.pageobjects.CollectionsPage;
import com.bbcFood.features.support.pageobjects.RecipesPage;
import com.bbcFood.features.support.util.DriverFactory;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RecipesPageSteps extends DriverFactory{
  
  WebDriverWait wait = new WebDriverWait(getDriver(),20); 

  @When("^I any select any collection$")
  public void iAnySelectAnyCollection() throws Throwable {
    new RecipesPage(getDriver()).selectAnyCollection();
  }
  

  @Then("^each collection item should have a thumbnail image$")
  public void eachCollectionItemShouldHaveAThumbnailImage() throws Throwable {
    CollectionsPage collectionsPage = new CollectionsPage(getDriver());
    wait.until(ExpectedConditions.visibilityOf(collectionsPage.verifyCollectionPage));
    
  //  for(int count = 0; count < collectionsPage.noOfCollectionRecipes(); count++){
    //  assertTrue(collectionsPage.getItemImg(count).get(count).isDisplayed());
    //  assertTrue(collectionsPage.getItemTitle(count).isEmpty());
    for(WebElement t : collectionsPage.getItemImg2()){
      assertTrue(t.isDisplayed());
      System.out.println(t);
    }
    
    }
//  }
  

  @Then("^a Title$")
  public void aTitle() throws Throwable {
    CollectionsPage collectionsPage = new CollectionsPage(getDriver());
    for(String text : collectionsPage.getItemTitle()){
      assertFalse(text.isEmpty());
    }
  }
  
  @Then("^a Authors$")
  public void aAuthors() throws Throwable {
    CollectionsPage collectionsPage = new CollectionsPage(getDriver());
    for(String text : collectionsPage.getItemRecipeAuthor()){
      assertFalse(text.isEmpty());
    }
  }

}

