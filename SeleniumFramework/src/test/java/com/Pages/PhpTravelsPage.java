package com.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.Generic;
import com.Utilities.Reports;
import com.aventstack.extentreports.ExtentTest;

public class PhpTravelsPage extends MasterPage{
	
	public PhpTravelsPage(WebDriver driver, Reports report) {
		super(driver, report);
	}

	@FindBy(css = "a#dropdownCurrency:last-of-type > span.ink")
	public WebElement myAccount;
	@FindBy(xpath = ".//a[text()='Login']")
	public WebElement loginLink;
	@FindBy(xpath = ".//input[@name='username']")
	public WebElement username;
	@FindBy(xpath = ".//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = ".//button[@type='submit' and text()='Login']")
	public WebElement loginButton;
	
	public void clickOnMyAccountButton(String user) {
		report.callLoggerMethod("Clicking on my account button.");
		try {
			myAccount.click();
		} catch (NoSuchElementException nse) {
			Assert.fail("Unable to click on myaccount element.");
		}
		report.reportPassEvent(driver, "Clicked on my account successfully.");
	}
	
	public void clickOnLoginLink() {
		report.callLoggerMethod("Clicking on login link.");
		try {
			myAccount.click();
		} catch (NoSuchElementException nse) {
			Assert.fail("Unable to click on myaccount element.");
		}
		report.reportPassEvent(driver, "Clicked on login link successfully.");
	}
	
	public void enterUser(String user) {
		report.callLoggerMethod("Entering username.");
		try {
			username.sendKeys(user);
		} catch (NoSuchElementException nse) {
			Assert.fail("Unable to click on myaccount element.");
		}
		report.reportPassEvent(driver, "Username entered successfully.");
	}
	
	public void enterPassword(String pwd) {
		report.callLoggerMethod("Entering password.");
		try {
		password.sendKeys(pwd);
		} catch (NoSuchElementException nse) {
		Assert.fail("Unable to click on myaccount element.");
		}
		report.reportPassEvent(driver, "Password entered successfully.");
	}

	public void clickOnLoginButtton() {
		report.callLoggerMethod("Clicking on login button.");
		try {
			loginButton.click();
		} catch (NoSuchElementException nse) {
			Assert.fail("Unable to click on myaccount element.");
		}
		report.reportPassEvent(driver, "Clicked on login button successfully.");
	}
}
