package com.rightmoveplc.test.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCriteria {

	    WebDriver driver;
	    @FindBy(id = "headerTitle")
	    public WebElement headerTitle;

	    public SearchCriteria(WebDriver driver) {	    	
	        
	    	this.driver = driver;
	    	
	    }
	    
	    public void validateSearchCriteriaPage(String strText) {
	    	
	    	if(headerTitle.getText().contains(strText)) {
            	System.out.println("Header Title do not contain"+strText);
            }else {
            	System.out.println("Header Title do not contain"+strText+"the value of the header title"+headerTitle.getText());
            }

	    }

	    public void selectRadius(String element, String value) {

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
					System.out.println("Exception selectRadius");
				}
				
			}
	    	
	    	//idendifyAndSelectDropDown(radius, radiusValue);

	    }

	    public void selectMinPrice(String element, String value) {

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
					System.out.println("Exception selectMinPrice");
				}
				
			}
	    	
	    	//idendifyAndSelectDropDown(radius, radiusValue);

	    }
	    
	    public void selectMinBedrooms(String element, String value) {
	    	
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
					System.out.println("Exception selectMinBedrooms");
				}
				
			}
	    	
	    	//idendifyAndSelectDropDown(radius, radiusValue);

	    }
	    
	    public void clickFindPropertiesButton(String element) {
	    	
			try {
						driver.findElement(By.id(element)).click();
						
			} catch (Exception exception) {

				System.out.println("Exception clickFindPropertiesButton");

			}			
			
	    }
	    
}
