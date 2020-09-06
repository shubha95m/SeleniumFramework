package com.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Utilities.Reports;

public class AestheticHomePage extends MasterPage{

	public AestheticHomePage(WebDriver driver, Reports report) {
		super(driver, report);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = ".membership-title > span")
	public WebElement dashboard;
	
	public boolean verifyHomePage() {
		report.callLoggerMethod("Verifying home page of Aesthetic site.");
		if (waitForElementLoad(dashboard)) {
			report.reportPassEvent(driver, "Verified AestheticHomePage successfully.");
			return true;
		} else {
			report.reportPassEvent(driver, "AestheticHomePage is not loaded yet.");
			return false;
		}
		
	} 

}
