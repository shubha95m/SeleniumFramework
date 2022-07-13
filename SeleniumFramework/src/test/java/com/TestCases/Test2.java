package com.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static WebDriver driver;

	public static void main(String args[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 

		System.out.println("test case got started---------------------->");

		
		  driver.get("https://dev3.alpha-sense.com/");
		  System.out.println("url launched---------------------->");
		  
		  driver.findElement(By.name("username")).sendKeys("alertfeedenabled.atester");
		  System.out.println("username entered---------------------->");
		  
		  driver.findElement(By.id("next-step")).click();
		  System.out.println("next button clicked---------------------->");
		  
		  driver.findElement(By.name("password")).sendKeys("AlphaAutoPass123!");
		  System.out.println("password entered---------------------->");
		  
		  driver.findElement(By.xpath(".//span[text()='Sign in']")).click();
		  System.out.println("next button clicked---------------------->");
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(By.id("nav-main")).isDisplayed();
		  System.out.println("Signed in successfully---------------------->");
		 
		Thread.sleep(3000);
		driver.close();
		System.out.println("test case got ended---------------------->");
	}

	/*
	 * @Test public void test() {
	 * 
	 * }
	 */

	// java download
	// selenium
	// maven framework --> dependencies or jar framework
}
