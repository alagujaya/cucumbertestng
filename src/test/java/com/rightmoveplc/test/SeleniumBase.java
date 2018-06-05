package com.rightmoveplc.test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;

import java.util.HashMap;


public class SeleniumBase {

    public static WebDriver driver;
    public static Scenario scenario;
    private BrowserSelection browserSelection = new BrowserSelection();

    public static WebDriver getDriver() {
        return driver;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    @Before()
    public void prepare(Scenario scenario) {
        driver = browserSelection.select();
        this.scenario = scenario;
    }

    @After
    public void cleanUp() {
        
        try {

           driver.close();
           driver.quit();

        } catch (Exception e) {
        	
            System.out.print("Driver already closed");
        
        }
    }
}
