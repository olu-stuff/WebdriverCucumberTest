package com.bbcFood.features.support.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CollectionsPage {

	WebDriver driver;

	public CollectionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#the-collection")
	public WebElement verifyCollectionPage;

	@FindBy(css = "#column-1>h1")
	public WebElement categoryTitle;

	@FindBy(css = ".with-image>h3>a>img")
	public List<WebElement> thumbImg;

	@FindBy(css = ".with-image>h3>a")
	public List<WebElement> itemTitle;

	@FindBy(css = ".chef-name")
	public List<WebElement> itemAuthor;

	@FindBys({ @FindBy(css = "#the-collection"), 
		@FindBy(css = "ul"), 
		@FindBy(css = "li"), 
		@FindBy(css = "h3"),
		@FindBy(css = "img"), })
	private List<WebElement> CollectionList;

	public List<String> CollectionItemsAllText() {
		ArrayList<String> title = new ArrayList<String>();
		for (WebElement items : CollectionList) {
			title.add(items.getText().toLowerCase());
		}
		return title;
	}

	public int noOfCollectionRecipes() {
		int p = CollectionList.size();
		return p;
	}


	public List<WebElement> getItemImg2() {
		ArrayList<WebElement> itemImg = new ArrayList<WebElement>();
		for (WebElement item : CollectionList)
			itemImg.add(item);
		return itemImg;
	}

	public List<String> getItemTitle() {
		ArrayList<String> itemTitle = new ArrayList<String>();
		for (WebElement item : CollectionList) {
			itemTitle.add(item.getText().toLowerCase());
		}
		return itemTitle;
	}

	public List<String> getItemRecipeAuthor() {
		ArrayList<String> authorList = new ArrayList<String>();
		for (WebElement alist : itemAuthor) {
			authorList.add(alist.getText().toLowerCase());
		}
		return authorList;
	}

}
