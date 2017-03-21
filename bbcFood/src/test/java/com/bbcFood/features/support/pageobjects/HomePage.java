package com.bbcFood.features.support.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#search-keywords")
	private WebElement recipeFinderSearchbox;

	@FindBy(css = "#search-submit")
	private WebElement sumbitSearch;

	@FindBy(css = "#heading a")
	public WebElement pageTitle;

	public void verifyPage(){
		String actText = pageTitle.getText().toLowerCase();
		if(actText.equals("food")){
			System.out.println("on bbc Food landing page");
		}else{
		System.out.println("This is NOT bbc Food landing page");
		}
	}

	public void useQRecipeFinderToSearch(String fSearch) {
		recipeFinderSearchbox.sendKeys(fSearch);
		sumbitSearch.click();

	}

}
