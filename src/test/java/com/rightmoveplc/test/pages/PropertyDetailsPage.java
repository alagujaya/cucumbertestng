package com.rightmoveplc.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PropertyDetailsPage {

    WebDriver driver;
    By Description = By.xpath("//*[@id=\"detailsTabs\"]/ul/li[1]");
	By floorplansTab= By.id("floorplansTab");
	By locationTab= By.id("locationTab");
	By schoolsTab= By.id("schoolsTab");
	By historyMarketTab= By.id("historyMarketTab");

    public PropertyDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void propertyDetailsPageValidation() {
    	//To Do
    	//Validate global header
    	//Validate branch Profile Property Details Header
    	//Validate property header and bedroom and price
    	//Validate photo and photo navigation
    	//Validate secondary Content like back, agent details, property sold near by, save property, notes
    	
    	
    }
    
    public void selectdetailsTabs() {

    	
		driver.findElement(Description).click();
		
		driver.findElement(floorplansTab).click();
		
		driver.findElement(locationTab).click();
		
		driver.findElement(schoolsTab).click();
		
		driver.findElement(historyMarketTab).click();
    	
    }

}
