package com.Pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;

import com.Utilities.BrowserFactory;
import com.Utilities.ConfigDataProvider;
import com.Utilities.ExcelDataProvider ;
import com.Utilities.Generic;
import com.Utilities.Helper;
import com.Utilities.SekuliFunction;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.Utilities.Reports;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports extent;
	public ExtentTest logger;
	public SekuliFunction sekuli;
	public String strTestName;
	public Reports report;
	public Generic generic;
	
	
	@BeforeTest
	public void objectFactory(ITestContext context) {
		loadTestName(context);
		config = new ConfigDataProvider();
		loadReports();
		excel = new ExcelDataProvider ();
		generic = new Generic();
		//sekuli = new SekuliFunction();
		
//		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports/FbLogin"+Helper.getCurrentDateTime()+".html"));
//		extent = new ExtentReports();
//		extent.attachReporter(reporter);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getDataFromConfig("fbUrl"));
		System.out.println("Browser and URL are up and running");
	}
	
	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(2000);
			report.getScreenshot(driver);
			//logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(""));
			//report.attachedScreenshotInReport();
	
		} catch (Exception e) {
			//do nothing
		} finally {
			BrowserFactory.quitBrowser(driver);
			report.endReport();
		}
	}
	
	private void loadTestName(ITestContext context) {
		try {
		strTestName = context.getName();
		
		if (strTestName.equals("Default test")) {
			List<XmlClass> classes = context.getCurrentXmlTest().getClasses();
			
			String simpleName = classes.get(0).getName();
			strTestName = simpleName.substring(simpleName.lastIndexOf(".")+1);
			
			List<XmlInclude> methods = classes.get(0).getIncludedMethods();
			
			if (methods.isEmpty()) {
				String simpleName1 = classes.get(0).getName();
				strTestName = simpleName1.substring(simpleName.lastIndexOf(".")+1);
			} else {
				strTestName = methods.get(0).getName();
			}
			System.out.println("string test name is: " +strTestName);
			}
		} catch (Exception ex) {
		ex.printStackTrace();
		}
	}
	
	private void loadReports() {
		try {
			report = new Reports(strTestName);
			report.setDriver(driver);
			report.setProp(config);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

