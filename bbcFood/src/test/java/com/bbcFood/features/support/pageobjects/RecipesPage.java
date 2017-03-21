package com.bbcFood.features.support.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class RecipesPage {
	
	private WebDriver driver;
	
	public RecipesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "#sub-heading")
	private WebElement subHeading;
	
	@FindBy (css = "#filter-results")
	public WebElement filterResults;
	

	@FindBys ({
	@FindBy(css =".article.with-image"),
	@FindBy(css = "h3")
	})
	public List<WebElement> resultItemTitle;
	
	
	public List<String> getQueryResults(){
		List<String> resultsListText = new ArrayList<String>();
		for(WebElement item : resultItemTitle) {
			resultsListText.add(item.getText().toLowerCase());
			}
		return resultsListText;
	}
	
	
	public void verifyResultsPage(){
		System.out.println(driver.getTitle());
		
	}
	
}
