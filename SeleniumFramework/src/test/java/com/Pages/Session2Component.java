package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Session2Component {
	
	@FindBy(name = "username")
    private WebElement usernameField;
	
	@FindBy(id = "next-step")
    private WebElement nextButton;
	
	@FindBy(name = "password")
    private WebElement passwordField;	
    
    @FindBy(xpath = ".//span[text()='Sign in']")
    private WebElement signInButton;
    
    @FindBy(id = "nav-main")
    private WebElement navMainIcon;
    
    public void enterUserName(String usernameValue) {
    	usernameField.sendKeys(usernameValue);
    }
    
    public void clickOnNextButton() {
    	nextButton.click();
    }
    
    public void enterPassword(String passwordValue) {
    	passwordField.sendKeys(passwordValue);
    }
    
    public void clickOnSignInButtonButton() {
    	signInButton.click();
    }
    
    public boolean verifyHomePageIsLoaded() {
    	return navMainIcon.isDisplayed();
    }

}
