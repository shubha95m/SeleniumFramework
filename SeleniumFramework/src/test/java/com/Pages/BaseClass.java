package com.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Utilities.BrowserFactory;
import com.Utilities.ConfigDataProvider;
import com.Utilities.DataProvider;
import com.Utilities.Helper;
import com.Utilities.SekuliFunction;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public DataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports extent;
	public ExtentTest logger;
	public SekuliFunction sekuli;
	
	@BeforeSuite
	
	public void objectFactory() {
		excel = new DataProvider();
		config = new ConfigDataProvider();
		sekuli = new SekuliFunction();
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports/FbLogin"+Helper.getCurrentDateTime()+".html"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void setup() {
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		System.out.println("Browser and URL are up and running");
		
	}
	
	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws Exception{
		
		if(result.getStatus()==ITestResult.FAILURE || result.getStatus()==ITestResult.SUCCESS || result.getStatus()==ITestResult.SKIP) {
		
		Helper.captureScreenshot(driver);
		
		//logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(""));
		logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
		
		}
		
		extent.flush();
	}

}

