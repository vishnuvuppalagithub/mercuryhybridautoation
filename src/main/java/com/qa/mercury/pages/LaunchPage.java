package com.qa.mercury.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.mercury.base.TestBase;

public class LaunchPage extends TestBase{

	
	@FindBy(xpath="//img[@src='/images/nav/logo.gif']")
	WebElement  mercuryLogo;
	
	
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@name='login']")
	WebElement signbttn;
	

	
	public boolean validatelogo()
	{
		return mercuryLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signbttn.click();
		return new HomePage();
				
	}
	
		public LaunchPage()
	{
		PageFactory.initElements(driver, this);
	}
		
}
