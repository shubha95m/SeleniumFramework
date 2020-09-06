package com.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Utilities.Reports;

public class AestheticrecordLoginPage extends MasterPage{

	public AestheticrecordLoginPage(WebDriver driver, Reports report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "UserEmailId")
	public WebElement username;
	@FindBy(name = "password")
	public WebElement password;
	@FindBy(css = ".login-form-submit")
	public WebElement loginButton;
	
	public boolean isPageloaded() {
		report.callLoggerMethod("Waiting for AestheticrecordLoginPage to be loaded.");
		if (waitForElementLoad(username)) {
			report.reportPassEvent(driver, "AestheticrecordLoginPage loaded successfully.");
			return true;
		} else {
			report.reportPassEvent(driver, "AestheticrecordLoginPage is not loaded.");
			return false;
		}
	}
	
	public void enterUser(String user) {
		report.callLoggerMethod("Entering username.");
		try {
			username.sendKeys(user);
		} catch (NoSuchElementException nse) {
			report.reportFailEvent(driver, "Unable to enter userid.");
		}
		report.reportPassEvent(driver, "Username entered successfully.");
	}
	
	public void enterPassword(String pwd) {
		report.callLoggerMethod("Entering password.");
		try {
		password.sendKeys(pwd);
		} catch (NoSuchElementException nse) {
			report.reportFailEvent(driver, "Unable to enter password.");
		}
		report.reportPassEvent(driver, "Password entered successfully.");
	}
	
	public AestheticHomePage clickOnLoginButtton() {
		report.callLoggerMethod("Clicking on login button.");
		try {
			loginButton.click();
		} catch (NoSuchElementException nse) {
			report.reportFailEvent(driver, "Unable to click on login button.");
		}
		report.reportPassEvent(driver, "Clicked on login button successfully.");
		return new AestheticHomePage(driver, report);
	}

}
