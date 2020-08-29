package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchDressPage {
	
	@FindBy(xpath=".//input[@id='search_query_top']")
	public WebElement searchArea;
	
	@FindBy(xpath=".//button[@name='submit_search']")
	public WebElement searchbutton;
	
	@FindBy(xpath=".//li[@class='clearfix']/div/div/span[1]")
	public List<WebElement> searcResultAsPerSearchedKeyword;
	
	@FindBy(xpath=".//li[@class='clearfix']/div/div/span[2]")
	public List<WebElement> searcAdditionalResultAsPerSearchedKeyword;
	
	@FindBy(xpath=".//span[contains(text(),'results have been found')]")
	public WebElement searcResultCountAsPerWabPage;
	
	WebDriver driver;
	
	public SearchDressPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

}
