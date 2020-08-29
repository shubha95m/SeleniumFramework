package com.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	WebDriver driver;
	
	public static WebDriver startApplication (WebDriver driver, String Browser, String appurl) {
		
		if (Browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			
			driver=new ChromeDriver();
			
		}
		
		else if(Browser.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			driver=new FirefoxDriver();
			
		}
		
		else if(Browser.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			
			driver=new InternetExplorerDriver();
			
		}
		
		else {
			System.out.println("Broser not initiated, please give correct browser name>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get(appurl);
		
		System.out.println("URL get executed");
		
		return driver;
		
	}
	
	public static WebDriver startApplication (WebDriver driver, String Browser) {
		
		if (Browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			
			driver=new ChromeDriver();
			
		}
		
		else if(Browser.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			driver=new FirefoxDriver();
			
		}
		
		else if(Browser.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			
			driver=new InternetExplorerDriver();
			
		}
		
		else {
			System.out.println("Broser not initiated, please give correct browser name>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
		
	}
	
	

}
