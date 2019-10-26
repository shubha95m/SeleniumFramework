package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FBPage {
	
	WebDriver driver;
	
	public FBPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(id="email")
	public WebElement username;
	
	@FindBy(id="pass") 
	public WebElement password;
	
	@FindBy(xpath=".//input[@type='submit']") 
	public WebElement login;
	
	public void logintoFB(String un, String pass) {
		
		username.sendKeys(un);
		password.sendKeys(pass);
		login.click();
		
	}

}
