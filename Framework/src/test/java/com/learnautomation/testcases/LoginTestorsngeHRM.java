package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.learnautomation.pages.Baseclass;
import com.learnautomation.pages.LoginPage;

public class LoginTestorsngeHRM extends Baseclass{
	
	@Test
	public void loginAPP() 
	{
		logger=report.createTest("login guru 99");
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
		logger.info("starting application");
		loginpage.loginorangehrm(excel.getstringData("Login", 0, 0),excel.getstringData("Login", 0, 1));
		logger.pass("login success");
	}

}
