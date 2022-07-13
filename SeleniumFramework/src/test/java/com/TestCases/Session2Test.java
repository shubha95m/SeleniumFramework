package com.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.Session2Component;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Session2Test {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
	/*@Test
	public void session2() throws InterruptedException {*/
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//setup();
		
		Session2Component session2Reference = PageFactory.initElements(driver, Session2Component.class);

		
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 

		System.out.println("test case got started---------------------->");

		
		  driver.get("https://dev3.alpha-sense.com/");
		  System.out.println("url launched---------------------->");
		  
		  driver.findElement(By.name("username")).sendKeys("alertfeedenabled.atester");
		  //session2Reference.enterUserName("alertfeedenabled.atester");
		  System.out.println("username entered---------------------->");
		  
		  driver.findElement(By.id("next-step")).click();
		  //session2Reference.clickOnNextButton();
		  System.out.println("next button clicked---------------------->");
		  
		  driver.findElement(By.name("password")).sendKeys("AlphaAutoPass123!");
		  //session2Reference.enterPassword("AlphaAutoPass123!");
		  System.out.println("password entered---------------------->");
		  
		  driver.findElement(By.xpath(".//span[text()='Sign in']")).click();
		  //session2Reference.clickOnSignInButtonButton();
		  System.out.println("next button clicked---------------------->");
		  
		  Thread.sleep(3000);
		  
		  //Assert.assertTrue(session2Reference.verifyHomePageIsLoaded(), "HomePage is not visible");
		  driver.findElement(By.id("nav-main")).isDisplayed();
		  System.out.println("Signed in successfully---------------------->");
		 
		Thread.sleep(3000);
		driver.close();
		System.out.println("test case got ended---------------------->");

	}
	
	/*
	 * public static void setup() { WebDriverManager.chromedriver().setup(); driver
	 * = new ChromeDriver(); }
	 */

}
