package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Generic;

public class RegisterPage {
	
	@FindBy(xpath=".//a[contains(text(),'Sign in')]")
	public WebElement signInLink;
	
	/*@FindBy(linkText="Sign in")
	public WebElement signInLink;*/
	
	@FindBy(id="SubmitCreate")
	public WebElement registerButton;
	
	@FindBy(id="email_create")
	public WebElement emailId;
	
	@FindBy(id="uniform-id_gender1")
	public WebElement titleMr;
	
	@FindBy(id="customer_firstname")
	public WebElement firstName;
	
	@FindBy(id="customer_lastname")
	public WebElement lastName;
	
	@FindBy(id="passwd")
	public WebElement password;
	
	@FindBy(xpath=".//select[@id='days']")
	public WebElement dayDrpdn;
	
	@FindBy(xpath=".//select[@id='months']")
	public WebElement monthDrpdn;
	
	@FindBy(xpath=".//select[@id='years']")
	public WebElement yearsDrpdn;
	
	@FindBy(xpath=".//input[@type='checkbox']")
	public List<WebElement> checkbox;
	
	@FindBy(id="firstname")
	public WebElement firstNameAddLine;
	
	@FindBy(id="lastname")
	public WebElement lastNameAddLine;
	
	@FindBy(id="company")
	public WebElement company;
	
	@FindBy(id="address1")
	public WebElement addressLine1;
	
	@FindBy(id="address2")
	public WebElement addressLine2;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="id_state")
	public WebElement stateDrpdn;
	
	@FindBy(id="postcode")
	public WebElement postcode;
	
	@FindBy(id="id_country")
	public WebElement countryDrpdn;
	
	@FindBy(id="other")
	public WebElement otherInfo;
	
	@FindBy(id="phone")
	public WebElement phoneNo;
	
	@FindBy(id="phone_mobile")
	public WebElement mobileNo;
	
	@FindBy(id="alias")
	public WebElement alias;
	
	@FindBy(id="submitAccount")
	public WebElement submitAccount;
	
	@FindBy(partialLinkText="Sign out")
	public WebElement signOutLink;
	
	@FindBy(xpath=".//div[@class='header_user_info']/a/span")
	public WebElement signOnValidation;
	
	WebDriver driver;

	public RegisterPage(WebDriver ldriver) {

		this.driver = ldriver;
	}
	
}
