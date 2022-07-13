package com.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.BaseClass;
import com.Pages.MasterPage;
import com.Pages.PhpTravelsPage;

public class PhpTravelLoginTest extends BaseClass{
	
	@Test
	public void loginIntoPhpTravel() {
		MasterPage master = new MasterPage(driver, report);
		
		PhpTravelsPage php = master.launchApplication(driver, config.getURL());
		System.out.println("--------"+Thread.currentThread().getId());
		
		/*
		 * php.enterUser("user@phptravels.com"); php.enterPassword("demouser");
		 * php.clickOnLoginButtton();
		 */
	}
	
	@Test
	public void loginIntoPhpTravel2() {
		MasterPage master = new MasterPage(driver, report);
		
		PhpTravelsPage php = master.launchApplication(driver, config.getURL());
		System.out.println("--------"+Thread.currentThread().getId());
	}
	
	@Test
	public void loginIntoPhpTravel3() {
		MasterPage master = new MasterPage(driver, report);
		
		PhpTravelsPage php = master.launchApplication(driver, config.getURL());
		System.out.println("--------"+Thread.currentThread().getId());
	}
	

}
