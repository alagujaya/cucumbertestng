package com.rightmoveplc.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {


    @FindBy(id = "searchLocation")
    public WebElement searchTextBox;
    @FindBy(id = "buy")
    public WebElement saleButton;
    @FindBy(id = "rent")
    public WebElement rentButton;
    
    @FindBy(className="strapline-intro")
    public WebElement introLine;    
    @FindBy(className="hero-strapline")
    public WebElement introSubLine;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String strUrl) {
    	try {
            driver.get(strUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public void searchSale(String strText) {
        searchTextBox.click();
        searchTextBox.clear();
        searchTextBox.sendKeys(strText);
        saleButton.click();
    }
    public void searchRent(String strText) {
        searchTextBox.click();
        searchTextBox.clear();
        searchTextBox.sendKeys(strText);
        rentButton.click();
    }
    
    public void headerMenuValidation(String value){
    	List<WebElement> menus = driver.findElements(By.className("globalNav-item"));
    	for (WebElement option : menus) {
    			if(value.equals(option.getText())) {
    	    		System.out.println("Menu option"+value+" is found and its value is"+option.getText()+
    	    				"the current page is"+driver.getCurrentUrl());
    	    		
			 break;
    			}
    		 
		}

    }
    
    public void validateHomePage() {

    	try {
    		//Validate the text box present and able to enter and clear
        	searchTextBox.click();
            searchTextBox.clear();
            searchTextBox.sendKeys("London");
            searchTextBox.clear();
            
            //Validate the 2 Button present and texts are correct
 
            if(saleButton.getText().contentEquals("For sale")) {
            	System.out.println("Sale Button text is correct");
            }else {
            	System.out.println("Sale Button text is not correct"+saleButton.getText());
            }
            
            if(rentButton.getText().contentEquals("To rent")) {
            	System.out.println("Rent Button text is correct");
            }else {
            	System.out.println("Rent Button text is not correct"+rentButton.getText());
            }
            
            if(introLine.getText().contentEquals("Find your happy")) {
            	System.out.println("Intro text is correct");
            }else {
            	System.out.println("Intro text is not correct"+introLine.getText());
            }

            if(introSubLine.getText().contentEquals("Search properties for sale and to rent in the UK")) {
            	System.out.println("INTRO SUB LINE text is correct");
            }else {
            	System.out.println("INTRO SUB LINE text is not correct"+introSubLine.getText());
            }
            
    	}catch(Exception e) {
            System.out.println("Exception in validateHomePage"+e.getMessage());

    	}
    	       
    }

}
