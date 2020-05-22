package com.qa.mercury.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.mercury.base.TestBase;

public class SelectfightPage extends TestBase {

		
	@FindBy(xpath="//td[@class='title']//font[contains(text(),'DEPART')]")
	WebElement departlabel;

	@FindBy(xpath="//font[contains(text(),'RETURN')]")
	WebElement returnlabel;
	
	@FindBy(xpath="//table//table//table//table//table[1]//tbody[1]//tr[1]//td[1]//table[1]//tbody[1]//tr[2]//td[1]//b[1]//font[1]")
	WebElement towardsjourney;
	
	@FindBy(xpath="//table[2]//tbody[1]//tr[1]//td[1]//table[1]//tbody[1]//tr[2]//td[1]//b[1]//font[1]")
	WebElement returnjourney;
	
	@FindBy(xpath="//html//body//div//table//tbody//tr//td[2]//table//tbody//tr[4]//td//table//tbody//tr//td[2]//table//tbody//tr[5]//td//form//table[1]//tbody//tr")
	List<WebElement>  rowpath;
	
	
	String start_xpath="//table//table//table//table//table[1]//tbody[1]//tr[";
	String last_xpath="]//td[1]//font[1]//font[1]";
	String rstart="//table//table//table//table//table[1]//tbody[1]//tr[";
	String rend="]//td[1]//input";
	
	
	@FindBy(name="reserveFlights")
	WebElement reserve;
	
	
	public int rowsize() {
		return rowpath.size();
	}
	
	public String verifyhomepage() {
		return driver.getTitle();
	}
	
	
	//public void clickhighfare(int rowcount,String  start_xpath, String last_xpath,String rstart, String rend )
	//Select the highest fare in the towards jounrney
	public void clickhighfare()	
	{
		int value = 0;
		int xpathvalue = 0;
		for (int i=4;i<rowsize();i=i+2) {
		String stringextract = driver.findElement(By.xpath(start_xpath+i+last_xpath)).getText();
		//Extracting digits from string
		String numbers=stringextract.replaceAll("[^0-9]", "");
		//Convert String to integer
		int prices=Integer.parseInt(numbers);
		System.out.println("Priniting prices" + prices);
		if (value<prices)
		{
			value=prices;
			xpathvalue=i;
		}
		}
		int radiobuttonno=xpathvalue-1;
		System.out.println("the maximum flight fare is:" + value);
		driver.findElement(By.xpath(rstart+radiobuttonno+rend)).click();
	}
	
	
	public ArrayList<String> journey(String journey )
	{
		
		String[] s= journey.split("\\s");
		ArrayList<String> towardslist = new ArrayList<String>();
		for (int i=0;i<s.length;i++) {
			if (!s[i].equalsIgnoreCase("to"))
				{
				towardslist.add(s[i]);	
				}
			
		}
		return towardslist;
		
		
	
	}
	
	public ArrayList<String> returnjourney()
	{
		return journey(returnjourney.getText());
	}
	
	public ArrayList<String> towardsjourney()
	{
		return journey(towardsjourney.getText());
	}
	
	public BookflightPage bookseletedflight()
	{
		reserve.click();
		return new BookflightPage();
		
	}
	
	
	public SelectfightPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	

	}


