
Feature: Search and place the order for products
  

@Offers
  Scenario Outline: Search order on main page
    Given User is on home page
    When user search with name <vegetable> on home page and extract name from there
    And user serach short name <vegetable> in offer page and extract name from there
    Then compare name extracted from both pages 
    
   Examples:
   |vegetable|
   |tom      |
   |pota     |


 