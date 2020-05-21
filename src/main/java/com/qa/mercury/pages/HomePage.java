package com.qa.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.mercury.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'SIGN-OFF')]")
	WebElement signofflink;
	
	@FindBy(xpath="//input[@value='roundtrip' and @name='tripType']")
	WebElement roundradio;
	

	
@FindBy(xpath="//select[@name='passCount']")
	WebElement passengers;

@FindBy(xpath="//select[@name='fromPort']")
WebElement departure;

@FindBy(xpath="//select[@name='toPort']")
WebElement arrival;

@FindBy(xpath="//select[@name='fromMonth']")
WebElement frommonth;

@FindBy(xpath="//select[@name='fromDay']")
WebElement fromdate;

@FindBy(xpath="//select[@name='toMonth']")
WebElement returnmonth;

@FindBy(xpath="//select[@name='toDay']")
WebElement returndate;
	
@FindBy(xpath="//input[@name='findFlights']")	
WebElement searchbutton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean signoff() {
		return signofflink.isDisplayed();
	}
	
	public void signoffclick() {
		signofflink.click();
			}
	
	public SelectfightPage roundtrip(String passengerno,String departcity, String arrivalcity, String departmonth,String fromdate2, String tomonth, String todate,String flightclass) {
		
		roundradio.click();
		Select pass= new Select(passengers);
		pass.selectByVisibleText(String.valueOf(passengerno));
		departure.sendKeys(departcity);
		arrival.sendKeys(arrivalcity);
		frommonth.sendKeys(departmonth);
		fromdate.sendKeys(String.valueOf(fromdate2));
		returnmonth.sendKeys(tomonth);
		returndate.sendKeys(String.valueOf(todate));
		driver.findElement(By.xpath("//input[@value='"+flightclass+"']")).click();
		System.out.println("Cliking the continue");
		searchbutton.click();
		return new SelectfightPage();
	}
	

	





	

}
