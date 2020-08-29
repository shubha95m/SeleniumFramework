package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Utilities.Generic;

public class LoginPage {

	@FindBy(xpath=".//a[contains(text(),'Sign in')]")
	public WebElement signInLink;
	
	@FindBy(xpath=".//input[@id='email']")
	public WebElement userEmail;
	
	@FindBy(xpath=".//input[@id='passwd']")
	public WebElement password;
	
	@FindBy(xpath=".//button[contains(@id,'SubmitLogin')]")
	public WebElement loginButton;
	
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

}
