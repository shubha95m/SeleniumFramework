package com.Utilities;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.PhpTravelsPage;

public class Generic{

	public WebDriver driver;
	
	public void funcFielsValueSet(WebDriver driver, WebElement element, String actionOn, String inpuyForTextbox, String textForDropdown) {
		System.out.println("entered in generic");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		element = wait.until(ExpectedConditions.visibilityOf(element));
		
		if (actionOn.equalsIgnoreCase("TEXT")) {
			
			element.clear();
			
			element.sendKeys(inpuyForTextbox);
			
		}
		
		else if (actionOn.equalsIgnoreCase("BUTTON") || 
				actionOn.equalsIgnoreCase("RADIO") || 
				actionOn.equalsIgnoreCase("CHECKBOX") ||
				actionOn.equalsIgnoreCase("LINK")) {
			System.out.println("action type is " +actionOn);
			
			element.click();
			
		}
		
		else if (actionOn.equalsIgnoreCase("DROPDOWN")) {
			
			Select select = new Select(element);
			
			select.selectByVisibleText(textForDropdown);
			
		}
		
	}

	public void explicitWait(WebDriver driver, WebElement element) {

		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		element = wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean waitForElement(WebElement e) {
		try {
			e.isDisplayed();
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public static String returnMailId() {
		String email = "";
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) 
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		email = generatedString + "@gmail.com";

		System.out.println(email);

		return email;
	}

	public int findSingleNumericInString(String string) {
		int number=0;

		for(int i=0; i<string.length(); i++) {

			char n = string.charAt(i);
			if(Character.isDigit(n)) {
				
				number = Character.getNumericValue(n);
			}
		}
		System.out.println("number is: "+number);
		return number;

	}
}
