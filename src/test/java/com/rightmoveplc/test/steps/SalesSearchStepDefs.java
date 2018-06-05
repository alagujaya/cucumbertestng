package com.rightmoveplc.test.steps;


import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.rightmoveplc.test.pages.HomePage;
import com.rightmoveplc.test.pages.PropertyDetailsPage;
import com.rightmoveplc.test.pages.PropertySearchResultPage;
import com.rightmoveplc.test.pages.SearchCriteria;

import static com.rightmoveplc.test.SeleniumBase.getDriver;
import static com.rightmoveplc.test.SeleniumBase.getScenario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SalesSearchStepDefs {

    public static Scenario scenario;
    public WebDriver driver;
    public HomePage homePage;
    public SearchCriteria searchCriteria;
    public PropertyDetailsPage propertyDetailsPage;
    public PropertySearchResultPage propertySearchResultPage;

    
    public String url ="http://www.rightmove.co.uk/";
    public String searchArea ="London";
    
    public String radius = "radius";
    public String radiusValue = "Within 3 miles";
    
    public String minPrice = "minPrice";
    public String minPriceValue = "90,000";
    
    public String minBedrooms = "minBedrooms";
    public String minBedroomsValue = "1";
    
    public static String submit = "submit";
    

    public String sortType = "sortType";
    public String sortTypeValue = "Newest Listed";
    

    public SalesSearchStepDefs() {
        driver = getDriver();
        scenario = getScenario();
        homePage = PageFactory.initElements(driver,HomePage.class);
        searchCriteria = PageFactory.initElements(driver,SearchCriteria.class);
        propertySearchResultPage = PageFactory.initElements(driver,PropertySearchResultPage.class);
        propertyDetailsPage = PageFactory.initElements(driver,PropertyDetailsPage.class);
                
    }
    
    @Given("^I am on homepage$")
    public void i_am_on_homepage() throws Throwable {
    	
    	homePage.navigateTo(url);
    	Thread.sleep(6000);
    	
    }

    @When("^I search for house sales in my area$")
    public void i_search_for_house_sales_in_my_area() throws Throwable {
    	
    	homePage.validateHomePage();
    	homePage.headerMenuValidation("Buy");   	
    	homePage.searchSale(searchArea);
    	Thread.sleep(6000);
    	homePage.headerMenuValidation("Rent"); 
    	searchCriteria.validateSearchCriteriaPage(searchArea);
    	searchCriteria.selectRadius(radius, radiusValue);
    	searchCriteria.selectMinBedrooms(minBedrooms, minBedroomsValue);
    	searchCriteria.selectMinPrice(minPrice, minPriceValue);
    	searchCriteria.clickFindPropertiesButton(submit);
    	Thread.sleep(6000);

    }

    @Then("^I should see all available properties in that area$")
    public void i_should_see_all_available_properties_in_that_area() throws Throwable {
    	
    	//propertySearchResultPage.validatePropertySearchResultPage();

    }
    
    @Then("^sort the properties by Newest Listed$")
    public void sort_the_properties_by_Newest_Listed() throws Throwable {
    	
    	propertySearchResultPage.SortPropertyByValue(sortType, sortTypeValue);
    
    }

    @Then("^select first nonFeatured property$")
    public void select_first_nonFeatured_property() throws Throwable {

    	propertySearchResultPage.selectNonFeaturedProperty();
    	propertyDetailsPage.propertyDetailsPageValidation();
    	propertyDetailsPage.selectdetailsTabs();
    	    	
    }

}
