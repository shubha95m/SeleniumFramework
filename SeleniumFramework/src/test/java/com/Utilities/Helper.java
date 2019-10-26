package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.utils.FileUtil;

public class Helper {
	
	public static String screenshotPath="";
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} 
		
		catch (IOException e) {
			System.out.println("unable to take screenshot : "+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate); 
	}

}
