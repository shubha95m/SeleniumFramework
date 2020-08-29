package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Utilities.Generic;

public class CheckoutProductPage {
	
	@FindBy(xpath=".//li[@class='clearfix']/a")
	public List<WebElement> searchResult;
	
	@FindBy(xpath=".//span[text()='Add to cart']")
	public WebElement addCartButton;
	
	@FindBy(xpath=".//a[contains(@title,'Proceed to checkout')]")
	public WebElement proceedCheckoutButtonFromCart;
	
	@FindBy(xpath="(.//a[contains(@title,'Proceed to checkout')])[2]")
	public WebElement proceedCheckoutButtonFromSummary;
	
	@FindBy(xpath=".//input[@type='checkbox']")
	public WebElement agreeCheckbox;
	
	@FindBy(xpath="(.//span[contains(text(),'Proceed to checkout')])[2]")
	public WebElement proceedCheckAfterAgreeCheckAndAddress;
	
	@FindBy(xpath=".//a[contains(@title,'Pay by bank wire')]")
	public WebElement paymentOption;
	
	@FindBy(xpath=".//span[contains(text(),'I confirm my order')]")
	public WebElement confirmOrder;
	
	WebDriver driver;


	public CheckoutProductPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

}
