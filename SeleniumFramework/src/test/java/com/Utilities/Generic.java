package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic {
	
	static WebDriver driver;
	
	public void funcFielsValueSet(WebElement element, String actionOn, String inpuyForTextbox, String textForDropdown) {
		
		if (actionOn.equalsIgnoreCase("TEXT")) {
			
			//explicitWait(element);
			
			element.clear();
			
			element.sendKeys(inpuyForTextbox);
			
		}
		
		else if (actionOn.equalsIgnoreCase("BUTTON") || 
				actionOn.equalsIgnoreCase("RADIO") || 
				actionOn.equalsIgnoreCase("CHECKBOX")) {
			
			element.click();
			
		}
		
		else if (actionOn.equalsIgnoreCase("DROPDOWN")) {
			
			Select select = new Select(element);
			
			select.selectByVisibleText(textForDropdown);
			
		}
		
	}
	
	public static void explicitWait(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		element = wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}

}
