Feature: Sale Property Search for an area
  As a buyer
  I want to view all available properties for an area which are available to buy

  Scenario: Search sales
  	Given I am on homepage
  	When I search for house sales in my area
  	Then I should see all available properties in that area
  	And sort the properties by Newest Listed
  	And select first nonFeatured property