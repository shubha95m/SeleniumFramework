package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.BaseClass;
import com.Pages.FBPage;
import com.Utilities.BrowserFactory;
import com.Utilities.ConfigDataProvider;
import com.Utilities.Generic;

public class FBLoginTest extends BaseClass {
	
	//WebDriver driver;
	
//	Generic generic = new Generic();
//	ConfigDataProvider config = new ConfigDataProvider();
	
	@Test(priority=1)
	public void loginFB() {
		
		logger = extent.createTest("login to facebook");

		System.out.println("page title is:----------- " +driver.getTitle());
		
		FBPage FBPage = PageFactory.initElements(driver, FBPage.class);
		
		logger.info("Application started");
		
		//FBPage.logintoFB(excel.getCellData("Login", 0, 0), excel.getCellData("Login", 0, 0));
		
		FBPage.logintoFB(config.getDataFromConfig("Username"), config.getDataFromConfig("Password"));
		
		logger.pass("login successfully done");
		
		//FBPage.logintoFB(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 0));
		
	}
	
	@Test(priority=1)
	public void logintoGmailThroughSekuli() {
		
		logger = extent.createTest("login to Gmail Through Sekuli tool");
		
		sekuli.sekuliAction("GmailLink", "Click", "");
		sekuli.sekuliAction("SignInLink", "Click", "");
		sekuli.sekuliAction("Username", "Type", "shubham.sharma157");
		sekuli.sekuliAction("NexttoUN", "Click", "");
		sekuli.sekuliAction("Password", "Type", config.getDataFromConfig("PassWord"));
		sekuli.sekuliAction("NexttoPass", "click", "");
		
		
		
	}
	
//	@Test(priority=1)
//	public void loginToFb() {
//		
//		//FBPage FBPage = PageFactory.initElements(driver, FBPage.class);
//		FBPage fb = new FBPage(driver);
//		
//		BrowserFactory.startApplication(driver, "Chrome", config.getURL());
//		System.out.println("Test method running");
//		generic.funcFielsValueSet(fb.username, "text", config.getDataFromConfig("Username"), "");
//		generic.funcFielsValueSet(fb.password, "text", config.getDataFromConfig("Password"), "");
//		generic.funcFielsValueSet(fb.login, "button", "", "");
//		
//		driver.quit();
//		
//	}

} 
