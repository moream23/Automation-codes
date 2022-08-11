package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class Baseclass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupsuite() 
	{
		// to create log use reporter .log 
		Reporter.log("setting up and Test is getting ready", true);
	 excel=new ExcelDataProvider();
	 config=new ConfigDataProvider();
	 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/crm"+Helper.getCurrentDateTime()+".html"));
	 report=new ExtentReports();
	 report.attachReporter(extent);
	 Reporter.log("setting up and Test can be started", true);
	}
	@BeforeClass
	public void setup() 
	{
		Reporter.log("Trying to start browser and getting application ready", true);
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getqaURL());
		Reporter.log("Trying to start browser and getting application started", true);
	}
	@AfterClass
	public void teardown() 
	{ 
		Reporter.log("setting up and Test is getting ready", true);
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void Teardown(ITestResult result) throws IOException 
	{
		Reporter.log("Test is about to end ", true);
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			Helper.capturescreenshot(driver);
			logger.fail("Test Failed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.fail("Test passed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) 
		{
			logger.fail("Test skipped ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test completed report generated ", true);
	}
}
