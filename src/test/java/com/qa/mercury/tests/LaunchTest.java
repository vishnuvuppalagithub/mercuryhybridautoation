package com.qa.mercury.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.mercury.base.TestBase;
import com.qa.mercury.pages.HomePage;
import com.qa.mercury.pages.LaunchPage;

public class LaunchTest extends TestBase{
	
	LaunchPage launchpage;


	//Calling base constructor using super in the inheriteted constructor
	public LaunchTest()
	{
		super();
	}
	
	
	@BeforeTest
public void setup() {
		initialize();
		launchpage=new LaunchPage();
	}
	
	@Test(priority=1)
	public void validatepagetitleTest()
	{
		String homepagetitle=driver.getTitle();
		Assert.assertEquals("Welcome: Mercury Tours", homepagetitle);
		
	}
	
	@Test(priority=2)
	public void validatepagelogoTest()
	{
		
		Assert.assertTrue(launchpage.validatelogo(),"Expected Page not launched ");
		}


	
	
	@AfterTest
	public void teardown() {
	driver.quit();
	}
	
	
}
