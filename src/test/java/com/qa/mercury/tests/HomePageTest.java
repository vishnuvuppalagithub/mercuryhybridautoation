package com.qa.mercury.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.mercury.base.TestBase;
import com.qa.mercury.pages.HomePage;
import com.qa.mercury.pages.LaunchPage;
import com.qa.mercury.pages.SelectfightPage;
import com.qa.mercury.util.TestUtil;

public class HomePageTest extends TestBase {

	LaunchPage launchpage;
	HomePage homepage;
	SelectfightPage selectfightPage;
	String sheet = "flightdetails";

	public HomePageTest() {
		super();
		}

	@BeforeMethod
	public void setup() {
		initialize();
		launchpage = new LaunchPage();
		homepage = launchpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void validatesignoffTest() {
		Assert.assertTrue(homepage.signoff());
	}

	
	@Test(priority = 2, dataProvider = "getdata")
	public void selectflight(int passengerno, String fromcity, String tocity, String frommonth, int fromdate,
			String tomonth, int todate, String classtype) {
		selectfightPage = homepage.roundtrip(passengerno, fromcity, tocity, frommonth, fromdate, tomonth, todate,
				classtype);

	}

	
	@Test(priority = 2, dataProvider = "getdata")
	public void selectflight(HashMap<Object, String> map)
	{
		String passengerno=map.get("Passengers");
		String fromcity=map.get("From City");
		String tocity=map.get("To city");
		String frommonth=map.get("From month");
		String fromdate=map.get("From date");
		String tomonth=map.get("To month");
		String todate=map.get("To date");
		String classtype=map.get("Class");
		
	
		selectfightPage = homepage.roundtrip(passengerno, fromcity, tocity, frommonth, fromdate, tomonth, todate,
				classtype);
		
			
		
	}

	@DataProvider
	public Object[][] getdata1() throws IOException {

		Object[][] data = TestUtil.readdata(sheet);
		return data;

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
