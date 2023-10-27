
Feature: Error Validation
 Error validation in LoginPage

 
@error
  Scenario Outline: Login error
    Given I am on landing page
    When I logged in with usernames <email> and password <password>
    Then "Incorrect email or password." message is displayed on the LoginPage
 
    Examples: 
      | email                  | password  | 
      | reddy.shilpa@gmail.com | abc |

      
      @error
  Scenario Outline: Product error
    Given I am on landing page and I logged in with usernames <email> and password <password>
    When  I add product <productname> to the carts
    And checkout <productname> 
    Then <productname> should be displayed on the checkoutpage
 
       Examples: 
      | email                  | password  | productname   |
      | reddy.shilpa@gmail.com |  Dob@1908 | ADIDAS ORIGINAL |