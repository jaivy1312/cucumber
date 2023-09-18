
Feature: Search and place the order for products
  

@Placeorder
  Scenario Outline: place order on main page
    Given User is on home page
    When user search with name <vegetable> on home page and extract name from there
    And user add the "3" quantity of the searched order
    Then user proceeds to checkoutpage and validate <vegetable> in checkoutpage
    And verify user has the ability to apply promo code and placeorder
		
    
   Examples:
   |vegetable|
   |tomato|
   |cabb|


 