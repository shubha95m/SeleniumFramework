package com.TestCases;

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
		
		php.enterUser("user@phptravels.com");
		php.enterPassword("demouser");
		php.clickOnLoginButtton();
	}
	

}
