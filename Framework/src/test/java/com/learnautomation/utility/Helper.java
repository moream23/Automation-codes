package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//screenshot .alert,frame,windows,sync issues,javascript executer
	public static String capturescreenshot(WebDriver driver) 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshot/guru99"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src,new File(screenshotpath));
			System.out.println("screenshot captured");
		} catch (IOException e) {
			System.out.println("unable to capture screenshot"+e.getMessage());
		}
		return screenshotpath;
	}
		public static String getCurrentDateTime() 
		{
			DateFormat customFormat=new SimpleDateFormat("MM_dd_yyy_HH_mm_ss");
			Date currentDate=new Date();
			return customFormat.format(currentDate);
			
		}
	
}
