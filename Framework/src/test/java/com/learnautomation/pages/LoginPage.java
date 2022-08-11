package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	 WebDriver driver;
	public LoginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	@FindBy(name="uid")WebElement username;
	@FindBy(name="password")WebElement password;
	@FindBy(name="btnLogin")WebElement loginbtn;
	
	public void loginorangehrm(String uname,String passwd)
	{
		try 
		{
			Thread.sleep(2000);
		}catch (Exception e) 
		{
		
		}
		username.sendKeys(uname);
		password.sendKeys(passwd);
		loginbtn.click();
	}

}
