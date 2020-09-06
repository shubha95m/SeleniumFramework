package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.AestheticHomePage;
import com.Pages.AestheticrecordLoginPage;
import com.Pages.BaseClass;
import com.Pages.MasterPage;
import com.Pages.PhpTravelsPage;

public class AestheticrecordLoginTest extends BaseClass{
	
	@Test
	public void loginIntoAestheticSite() {
		MasterPage master = new MasterPage(driver, report);
		String userID = config.getDataFromConfig("USER_EMAIL");
		String password = config.getDataFromConfig("PASSWORD");
		String url = config.getDataFromConfig("aestheticLogin");
		
		AestheticrecordLoginPage aesthetic = master.launchAestheticApplication(driver, url);
		
		Assert.assertTrue(aesthetic.isPageloaded(), "Aeshthetic page is not loaded");
		aesthetic.enterUser(userID);
		aesthetic.enterPassword(password);
		AestheticHomePage home = aesthetic.clickOnLoginButtton();
		Assert.assertTrue(home.verifyHomePage(), "Aeshthetic home page is not loaded");
	}

}
