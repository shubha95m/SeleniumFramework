package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class Reports{

	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentHtmlReporter htmlReport;
	public ExtentReports eReport;
	public ExtentTest logger;
	public String strTestName, reportFolderName, reportPath;
	private Boolean enableScreenshotForPassFlagIS=true;//new Boolean(config.getDataFromConfig("enablePassScreenshot"));
	private Boolean enableScreenshotForFailFlagIS=true;//Boolean.valueOf(config.getDataFromConfig("enableFailScreenshot"));
	private Boolean enableScreenshotForWarningFlagIS=true;//Boolean.valueOf(config.getDataFromConfig("enableWarningScreenshot"));

	public Reports(String strTestName) {
		try {
			this.strTestName = strTestName;
			reportFolderName = strTestName + "_" + fn_getDateTime();
			reportPath = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + reportFolderName;	
			//ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports/" + strTestName + "/"+ strTestName + fn_getDateTime()+".html"));
			//eReport = new ExtentReports();
			//eReport.attachReporter(htmlReport);
			
			
			new File(reportPath).mkdirs();
			
			htmlReport = new ExtentHtmlReporter(new File(reportPath + File.separator + strTestName + fn_getDateTime() + ".html"));
			htmlReport.config().setDocumentTitle(strTestName);
			htmlReport.config().setReportName(strTestName);
			
			eReport  = new ExtentReports();
			eReport.attachReporter(htmlReport);
			
			logger = eReport.createTest(strTestName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setProp(ConfigDataProvider config) {
		this.config = config;
	}
	
	public void callLoggerMethod(String logerMessage) {
		logger.info(logerMessage);
	}
	
	public void attachedScreenshotInReport() {
		try {
			logger.addScreenCaptureFromPath(getScreenshot(driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reportPassEvent(WebDriver driver, String details) {
		try {
			if (enableScreenshotForPassFlagIS) {
				logger.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
				attachedScreenshotInReport();
			}
			else
				logger.pass(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reportFailEvent(WebDriver driver, String details) {
		try {
			if (enableScreenshotForFailFlagIS) {
				logger.fail(details, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
				attachedScreenshotInReport();
			}
			else
				logger.fail(details);
			Assert.fail(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reportWarningEvent(WebDriver driver, String details) {
		try {
			if (enableScreenshotForWarningFlagIS) {
				logger.warning(details, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
				attachedScreenshotInReport();
			}
			else
				logger.warning(details);
			Assert.fail(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String fn_getDateTime() {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss");
			Date date = Calendar.getInstance().getTime();
			String currentDate = dateFormat.format(date);
			return currentDate;
		} catch (Exception ex) {
			ex.printStackTrace();
		} return null;
	}
	
	public String getScreenshot(WebDriver driver) {
		String screenshotPath="";
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+fn_getDateTime()+".png";
			FileHandler.copy(src, new File(screenshotPath));
			return screenshotPath;
		} catch (Exception ex) {
			ex.printStackTrace();
		} return null;
	}
	
	public void endReport() {
		eReport.flush();
	}
}
