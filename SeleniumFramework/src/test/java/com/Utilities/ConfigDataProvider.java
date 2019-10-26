package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File src = new File("./Config/config.properties");	

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
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

}
