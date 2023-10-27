
Feature: Purchase Order 
  I want to purchase a product in the ecommerce website

Background:
Given I landed on the ecommerce page

@Regression
    Scenario Outline: Posistive Scenario
    Given I logged in with username <email> and password <password>
    When I add product <productname> to the cart
    And checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the confirmationPage

    Examples: 
      | email                  | password  | productname   |
      | reddy.shilpa@gmail.com |  Dob@1908 | IPHONE 13 PRO |
    
