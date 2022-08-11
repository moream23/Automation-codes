package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	//constructor
	Properties pro;
	public ConfigDataProvider() 
	{
		File src=new File("./Configuration/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) 
		{
			System.out.println("not able to load config file>>"+e.getMessage());
		} 
	}
	public String getDataFromConfig(String KeytoSearch) 
	{
		return pro.getProperty(KeytoSearch);
	}
	public String getBrowser() 
	{
		return pro.getProperty("Browser");
	}
	public String getqaURL() 
	{
		return pro.getProperty("qaURL");
	}

}
