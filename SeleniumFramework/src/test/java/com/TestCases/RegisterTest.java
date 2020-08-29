package com.TestCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.Pages.BaseClass;
import com.Pages.CheckoutProductPage;
import com.Pages.InvoiceDownloadPage;
import com.Pages.LoginPage;
import com.Pages.RegisterPage;
import com.Pages.SearchDressPage;
import com.Utilities.Generic;
import com.Utilities.Helper;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class RegisterTest extends BaseClass{

	@Test(priority=1)
	public void registration() { 
		try {
		
			RegisterPage reg = PageFactory.initElements(driver, RegisterPage.class);
			String email = Generic.returnMailId();
			config.setDataIntoConfig("emailUser", email);

			logger = extent.createTest("Registration process started");

			driver.get(config.getDataFromConfig("testURL"));

			logger.info("URL launched");
			System.out.println("URL launched");

			generic.funcFielsValueSet(driver, reg.signInLink, "link", "", "");
			logger.info("login link clicked");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.emailId, "text", email, "");
			logger.info("email entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.registerButton, "button", "", "");
			logger.info("email registration button clicked");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.titleMr, "radio", "", "");
			logger.info("name title clicked");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.firstName, "text", config.getDataFromConfig("firstName"), "");
			logger.info("firstname entred");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.lastName, "text", config.getDataFromConfig("lastName"), "");
			logger.info("lastname entred");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.password, "text", config.getDataFromConfig("password"), "");
			logger.info("password entred");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.dayDrpdn, "dropdown", "", config.getDataFromConfig("day"));
			logger.info("birth day is selected");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.monthDrpdn, "dropdown", "", config.getDataFromConfig("month"));
			logger.info("birth month is selected");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.yearsDrpdn, "dropdown", "", config.getDataFromConfig("year"));
			logger.info("birth year is selected");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			for(int i=0; i<reg.checkbox.size(); i++) {

				reg.checkbox.get(i).click();
				logger.info("checkbox xlicked at position of :"+i);
				logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			}

			generic.funcFielsValueSet(driver, reg.firstNameAddLine, "text", config.getDataFromConfig("firstName"), "");
			logger.info("firstname for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.lastNameAddLine, "text", config.getDataFromConfig("lastName"), "");
			logger.info("lastname for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.company, "text", config.getDataFromConfig("company"), "");
			logger.info("company for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.addressLine1, "text", config.getDataFromConfig("addLine1"), "");
			logger.info("address line1 for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.addressLine2, "text", config.getDataFromConfig("addLine2"), "");
			logger.info("address line for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.city, "text", config.getDataFromConfig("city"), "");
			logger.info("city for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.stateDrpdn, "dropdown", "", config.getDataFromConfig("state"));
			logger.info("state for address is selected");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.postcode, "text", config.getDataFromConfig("postCode"), "");
			logger.info("postcode for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.countryDrpdn, "dropdown", "", config.getDataFromConfig("country"));
			logger.info("country for address is selected");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.otherInfo, "text", config.getDataFromConfig("other"), "");
			logger.info("Additional comment for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.phoneNo, "text", config.getDataFromConfig("phone"), "");
			logger.info("phone number for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.mobileNo, "text", config.getDataFromConfig("mobile"), "");
			logger.info("mobile number for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.alias, "text", config.getDataFromConfig("alias"), "");
			logger.info("alias for address is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, reg.submitAccount, "button", "", "");
			logger.info("Register button is clicked for registration");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			String validationActual = reg.signOnValidation.getText();
			String valFromexpected = config.getDataFromConfig("firstName")+" "+config.getDataFromConfig("lastName");

			if (generic.waitForElement(reg.signOnValidation) && 
					validationActual.equals(valFromexpected)) {

				logger.info("Registration Validation Completed");
				logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
				System.out.println("Registration Validation Completed");
			}
			else {

				logger.info("Registration Validation failed, kindly check your validation point");
				logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
				System.out.println("Registration Validation failed, kindly check your validation point");
			}

			generic.funcFielsValueSet(driver, reg.signOutLink, "link", "", "");
			logger.info("Registration process done and apllication signed out successfully");
			System.out.println("Registration process done and apllication signed out successfully");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			logger.pass("registration test is passed");
		} catch (Exception e) {
			e.printStackTrace();
	
		}
	
	}

	@Test(priority=2)
	public void login() {
		try {
			RegisterPage reg = PageFactory.initElements(driver, RegisterPage.class);
			LoginPage log = PageFactory.initElements(driver, LoginPage.class);

			logger = extent.createTest("login process started");

			driver.get(config.getDataFromConfig("TestURL"));

			logger.info("URL launched");

			generic.funcFielsValueSet(driver, log.signInLink, "link", "", "");
			logger.info("login link clicked");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			
			generic.funcFielsValueSet(driver, log.userEmail, "text", config.getDataFromConfig("emailUser"), "");
			logger.info("userEmail entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			
			generic.funcFielsValueSet(driver, log.password, "text", config.getDataFromConfig("password"), "");
			logger.info("password entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			
			generic.funcFielsValueSet(driver, log.loginButton, "button", "", "");
			logger.info("login button clicked");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			String validationActual = reg.signOnValidation.getText();
			String valFromexpected = config.getDataFromConfig("firstName")+" "+config.getDataFromConfig("lastName");

			if (generic.waitForElement(reg.signOnValidation) && 
					validationActual.equals(valFromexpected)) {

				logger.info("Registration Validation Completed");
				logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
				System.out.println("Registration Validation Completed");
			}
			else {

				logger.info("login Validation failed, kindly check your validation point");
				logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
				System.out.println("login Validation failed, kindly check your validation point");
			}

			logger.pass("login test is passed");

		}catch(Exception e) {
			logger.fail("test failed, find logs here in console, please find logs in console");
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Test(priority=3)
	public void searchDressKeyword() {
		try {
			SearchDressPage sd = PageFactory.initElements(driver, SearchDressPage.class);

			logger = extent.createTest("'Dress' Keyword search process is started");

			generic.funcFielsValueSet(driver, sd.searchArea, "text", config.getDataFromConfig("searchKeyword"), "");
			logger.info("'searched keyword' is entered");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));
			
			generic.funcFielsValueSet(driver, sd.searchbutton, "button", "", "");
			logger.info("search button is clicked for searching 'searched keyword'");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			int searchedCount = sd.searcResultAsPerSearchedKeyword.size();
			int addiCount = sd.searcAdditionalResultAsPerSearchedKeyword.size();
			int actualCount = searchedCount-addiCount;
			System.out.println("actualCount is: "+actualCount);
			String input = sd.searcResultCountAsPerWabPage.getText();
			int countAsPerWebPage = generic.findSingleNumericInString(input);
			System.out.println("countAsPerWebPage is: "+countAsPerWebPage);

			Assert.assertEquals(countAsPerWebPage, actualCount);

			logger.info("keyword searched and validated with asser");

			logger.pass("search keyword test is passed");

		}catch(Exception e) {
			logger.fail("test failed, find logs here in console, please find logs in console");
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Test(priority=4)
	public void checkoutProduct() {
		try {
			CheckoutProductPage cp = PageFactory.initElements(driver, CheckoutProductPage.class);

			logger = extent.createTest("product checkout process is started");

			generic.funcFielsValueSet(driver, cp.searchResult.get(0), "link", "", "");
			logger.info("clicked on one of the search result");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			generic.funcFielsValueSet(driver, cp.addCartButton, "link", "", "");
			logger.info("add to cart button is clicked");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, cp.proceedCheckoutButtonFromCart, "link", "", "");
			logger.info("checkout process is done from cart section");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, cp.proceedCheckoutButtonFromSummary, "link", "", "");
			logger.info("checkout process is done from summary section");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, cp.proceedCheckAfterAgreeCheckAndAddress, "link", "", "");
			logger.info("checkout process is done from address section");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, cp.agreeCheckbox, "link", "", "");
			logger.info("t&c agreed");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, cp.proceedCheckAfterAgreeCheckAndAddress, "link", "", "");
			logger.info("procced to checkout button is pressed after agreed on t&c");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, cp.paymentOption, "link", "", "");
			logger.info("payment option selected");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, cp.confirmOrder, "link", "", "");
			logger.info("order is confirmed by clicking on confirmOrder button");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			logger.pass("add to cart and checkout test is passed");

		}catch(Exception e) {
			logger.fail("test failed, find logs here in console, please find logs in console");
			System.out.println(e);
			e.printStackTrace();
		}

	}

	@Test(priority=5)
	public void downloadInvoice() throws Exception {
		try {
			InvoiceDownloadPage id = PageFactory.initElements(driver, InvoiceDownloadPage.class);

			logger = extent.createTest("Invoice download process is started");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));

			generic.funcFielsValueSet(driver, id.backToOrder, "link", "", "");
			logger.info("navigated to oreder section");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, id.downloadInvoice, "link", "", "");
			logger.info("invoice downloaded");
			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver));


			generic.funcFielsValueSet(driver, id.failure, "link", "", "");

			logger.pass("Invoice test is passed");


		}catch(Exception e) {
			logger.fail("test failed, find logs here in console, please find logs in console");
			logger.log(Status.FAIL, e, MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			System.out.println(e);
			e.printStackTrace();
		}
	}
}


