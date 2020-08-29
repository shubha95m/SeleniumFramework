package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.Generic;
import com.Utilities.Reports;

public class FBPage extends MasterPage{
	
	public FBPage(WebDriver driver, Reports report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	
	@FindBy(id="email")
	public WebElement username;
	
	@FindBy(id="pass") 
	public WebElement password;
	
	@FindBy(xpath=".//button[@type='submit']") 
	public WebElement login;
	
	public void logintoFB(String un, String pass) {
		
		generic.funcFielsValueSet(driver, username, "text", un, "");
		//username.sendKeys(un);
		
		//generic.funcFielsValueSet(driver, password, "text", pass, "");
		password.sendKeys(pass); 
		
		generic.funcFielsValueSet(driver, login, "button", "", "");
		//login.click();
		
	}                                                                                                                                                                                                                                      

}
