package com.rightmoveplc.test;

/**
 * To initiate and select the  browser(as of now Chrome or Firefox or default firefox)
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSelection {

	public static WebDriver driver;
    public String browser = "chrome";

    public WebDriver select() {

        browser = System.getProperty("browser");
        
        if (browser==null || browser =="") {
        	browser = "chrome";
        }

        if (browser.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver",
        			System.getProperty("user.dir") + "/SupportDrivers/geckodriver");        	
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
        	System.setProperty("webdriver.chrome.driver",
        			System.getProperty("user.dir") + "/SupportDrivers/chromedriver");
            driver = new ChromeDriver();
        } else {
        	System.setProperty("webdriver.chrome.driver",
        			System.getProperty("user.dir") + "/SupportDrivers/chromedriver");
        	driver = new ChromeDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
        
    }

}