package com.qa.mercury.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.qa.mercury.base.TestBase;

public class Webeventfiringlistener extends TestBase implements WebDriverEventListener
{

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigating to URL:"+ url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigated to URL:"+ url);
		
	}

	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		
	}

	
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		
	}

	
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
		
	}

	
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
		
	}

	
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
		
	}

	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		
	}

	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to click on element" + element.toString());
	}

	
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
		
	}

	
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
		
	}

	
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Element value changed to: " + element.toString());
		
	}

	
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured: " + throwable);
		try {
			TestUtil.takescreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("About to  extract text from element:" + element.toString());
	}

	
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		System.out.println("Text extracted is:" + text + "from: element" + element.toString());
		
		
	}
	

}
