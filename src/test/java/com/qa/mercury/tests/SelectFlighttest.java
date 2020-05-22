package com.qa.mercury.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.mercury.base.TestBase;
import com.qa.mercury.pages.HomePage;
import com.qa.mercury.pages.LaunchPage;
import com.qa.mercury.pages.SelectfightPage;

public class SelectFlighttest extends TestBase{
	
	HomePage homepage;
	SelectfightPage selectfightPage;
	public SelectFlighttest() {
		super();
	}

	
@BeforeMethod
public 	void setup() {
	initialize();
	LaunchPage launchpage= new LaunchPage();
	homepage =	launchpage.login(prop.getProperty("username"), prop.getProperty("password"));
	selectfightPage = homepage.roundtrip("2", "Paris", "London", "May", "20", "June", "21","Business");
}

@Test(priority=1)
public void verifytitleTest()
{
	Assert.assertEquals(selectfightPage.verifyhomepage(), "Select a Flight: Mercury Tours", " SelectPage not launched ");
}

@Test(priority=2)
public void seletflightTest()
{
	ArrayList<String> towards =new ArrayList<String>();
	towards= selectfightPage.towardsjourney();
	Iterator<String> i =towards.iterator();
	while(i.hasNext()) {
		System.out.println("The journey details are " + i.next());
	}
	selectfightPage.bookseletedflight();
	
}

@Test(priority=3)
public void clickhighrate()
{
	selectfightPage.clickhighfare();
	
}


@AfterMethod
public void teardown()
{
	driver.quit();
}


}
