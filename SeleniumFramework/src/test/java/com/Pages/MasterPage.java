package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.Generic;
import com.Utilities.Reports;


public class MasterPage {
	
	public WebDriver driver;
	public Reports report;
	public Generic generic = new Generic();
	
	public MasterPage(WebDriver driver, Reports report) {
		this.driver = driver;
		this.report = report;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickElement (WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.click();
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} return false;
	}
	
	public boolean uploadFile (WebElement element, String path) {
		
		try {
			if (element.isDisplayed()) {
				element.sendKeys(path);;
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} return false;
		
	}
	
	public boolean clearElement (WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.clear();
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} return false;
	}
	
	public boolean enterElementValue (WebElement element, String value) {
		try {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(value);
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} return false;
	}
	
	public boolean selectElementByValue (WebElement element, String value) {
		try {
			if (element.isDisplayed()) {
				Select select = new Select(element);
				select.selectByValue(value);
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} return false;
	}
	
	public String getElementValue (WebElement element) {
		try {
			if (element.isDisplayed()) {
				return element.getText();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} return null;
	}
	
	public boolean waitForElementLoad(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean waitForVisibleElement(WebElement element) {
		try {
			System.out.println("inside try");
			WebDriverWait wait = new WebDriverWait(driver,35);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception ex) {
			System.out.println("inside catch");
			return false;
		}
	}
	
	public boolean waitForElementLoad(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public PhpTravelsPage launchApplication(WebDriver driver, String url) {
		try {
			driver.navigate().to(url);
			
			if (waitForElementLoad(By.xpath(".//input[@name='username']")))
				report.reportPassEvent(driver, "Launched Application");
			else
				report.reportFailEvent(driver, "Unable to launch the application");
		} catch (Exception ex) {
			report.reportWarningEvent(driver, ex.getMessage());
		} return new PhpTravelsPage(driver, report);
	}
	
}
