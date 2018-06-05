package com.rightmoveplc.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertySearchResultPage {

	int timeoutInSeconds = 6000;
    WebDriver driver;
    By propertyCard0 = By.xpath("//*[@id=\"l-searchResults\"]/div[1]/div/div[1]/div[4]/div[1]/div[2]");
    By propertyCard1 = By.xpath("//*[@id=\"l-searchResults\"]/div[2]/div/div[1]/div[4]/div[1]/div[2]");
    

    public PropertySearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void propertySearchResultPageValidation() {
    	//To Do
    	//Validate global header
    	//Validate search filter bar
    	//Validate create alert 
    	//Validate page navigation
    	//Validate side bar -Map
    	//Sidebar Search and more
    	
    }
    
    public void selectNonFeaturedProperty() {

        
    	try {

    		Thread.sleep(6000);
            //driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);

    		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

    		
    		WebElement featuredProperty = driver.findElement(By.className("propertyCard-moreInfoFeaturedTitle"));

    		System.out.println("featuredProperty1 value is "+featuredProperty.getText());
 
			if (featuredProperty.getText().isEmpty()) {

				driver.findElement(propertyCard0).click();

			}else {

				driver.findElement(propertyCard1).click();
				
			}
			
    		Thread.sleep(6000);


    	}catch(Exception exception) {

    		System.out.println("Exception in selectNonFeaturedProperty"+exception.getMessage());
    		exception.printStackTrace();
    	}

    }

    public void SortPropertyByValue(String element, String value) {

    	for (int second = 0;second<100; second=second+10) {
			try {
					WebElement select = driver.findElement(By.id(element.toString()));

					List<WebElement> options = select.findElements(By.tagName("option"));
					
					for (WebElement option : options) {

					    if(value.equals(option.getText())) {
					        option.click();
					    }
					    
					}										
					break;
				}
			 catch (Exception exception) {
				System.out.println("Exception SortPropertyByValue");
			}
			
    	}
    	
    }
    
}