package com.qa.mercury.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.mercury.util.TestUtil;
import com.qa.mercury.util.Webeventfiringlistener;


public class TestBase {
	
public static Properties prop;
public static WebDriver driver;
Webeventfiringlistener webeventfiringlistener;
EventFiringWebDriver e_driver;

	
	public TestBase(){
	
	
	try {
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\mercury\\configuration\\config.properties");
		prop.load(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
	}

	}
	
	public  void initialize() {
	if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")	+"\\src\\main\\java\\com\\qa\\mercury\\driver\\chromedriver.exe") ;
		driver = new ChromeDriver();
	}
	else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") +"\\src\\main\\java\\com\\qa\\mercury\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	webeventfiringlistener = new Webeventfiringlistener();
	e_driver.register(webeventfiringlistener);
	driver=e_driver;
	
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADTIMEOUT,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
		}
	

}
