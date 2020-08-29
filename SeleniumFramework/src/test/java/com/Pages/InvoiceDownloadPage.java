package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Utilities.Generic;

public class InvoiceDownloadPage {
	
	@FindBy(xpath=".//a[contains(@title,'Back to orders')]")
	public WebElement backToOrder;
	
	@FindBy(xpath=".//a[contains(@title,'Invoice')]")
	public WebElement downloadInvoice;
	
	@FindBy(xpath=".//a[@title='It should fail']")
	public WebElement failure;

	WebDriver driver;

	public InvoiceDownloadPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

}
