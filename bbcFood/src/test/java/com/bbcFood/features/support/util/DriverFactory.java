package com.bbcFood.features.support.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver; 
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import com.bbcFood.features.support.util.PropertyReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DriverFactory {

	
	 protected static WebDriver driver;

	 
	    private static void createNewDriverInstance(){
	        String browser = new PropertyReader().readProperty("browser");
	        if(browser.equalsIgnoreCase("firefox")){
	            driver = new FirefoxDriver();
	            driver.manage().window().maximize();
	        }else if(browser.equalsIgnoreCase("chrome")) {
	        	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\olugboyega.aseru\\workspace\\bbcFood\\src\\test\\java\\resources\\drivers\\chromedriver.exe");
	            driver = new ChromeDriver();
	            driver.manage().window().maximize();
	        }else if(browser.equalsIgnoreCase("ie")) {
	            System.setProperty("webdriver.ie.driver", "C:\\Users\\olugboyega.aseru\\workspace\\bbcFood\\src\\test\\java\\resources\\drivers\\IEDriverServer.exe");
	            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	            driver = new InternetExplorerDriver(caps);  
	            driver.manage().window().maximize();
	        }else if(browser.equalsIgnoreCase("edge")){
	        	System.setProperty("webdriver.edge.driver", "C:\\Users\\olugboyega.aseru\\workspace\\bbcFood\\src\\test\\java\\resources\\drivers\\MicrosoftWebDriver.exe");
	        	EdgeOptions options = new EdgeOptions();    
	        	options.setPageLoadStrategy("eager"); 
	        	driver = new EdgeDriver(options);;  
	        	driver.manage().window().maximize();
	        }else if(browser.equalsIgnoreCase("headless")){
	            driver = new HtmlUnitDriver();
	        }else{
	            System.out.println("Cannot read browser type: " + browser);
	        }
	    }

	    public static WebDriver getDriver(){
	        if(driver == null)  {
	          createNewDriverInstance();
	      }
	        return driver;
	    }
	    
	    
	    public static void destroyDriver(){
	        driver.close();
	        driver.quit();
	        driver = null;
	    }
}
