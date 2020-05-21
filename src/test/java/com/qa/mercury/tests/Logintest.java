package com.qa.mercury.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.mercury.base.TestBase;
import com.qa.mercury.pages.HomePage;
import com.qa.mercury.pages.LaunchPage;

public class Logintest extends TestBase{
	
	LaunchPage launchpage;
	HomePage homepage;
	
	public Logintest() {
		super();
	}
	
		
@BeforeTest 
	public void setup()
	{
	initialize();
	launchpage =new LaunchPage();
	}


@Test(priority=1)
public void LoginTest()
{
	homepage = launchpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
@AfterTest
public void teardown() {
driver.quit();
}
	

}
