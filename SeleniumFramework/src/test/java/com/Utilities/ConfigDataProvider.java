package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	static File src;
	
	public ConfigDataProvider() {

		src = new File("./Config/config.properties");	

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			System.out.println("Property file loaded");
			System.out.println("checking config value: " +getDataFromConfig("enablePassScreenshot"));
		} 

		catch (Exception e) {
			System.out.println("config file is not reachable : "+e.getMessage());
		}

	}

	public String getBrowser() {

		return pro.getProperty("Browser");
	}

	public String getURL() {

		return pro.getProperty("QaUrl");
	}

	public String getDataFromConfig(String key) {

		return pro.getProperty(key);

	}
	
	public void setDataIntoConfig(String key, String value) {

		pro.setProperty(key, value);
		FileOutputStream writer;
		try {
			writer = new FileOutputStream(src);
			pro.store(writer, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFromConfig(String key) {
		
		pro.remove(key);
		FileOutputStream writer;
		try {
			writer = new FileOutputStream(src);
			pro.store(writer, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
