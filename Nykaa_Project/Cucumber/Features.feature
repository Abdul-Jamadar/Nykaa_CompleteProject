@tag
Feature: Logging in and Add Items to cart on Nykaa shopping website.
   I want to use this template for my feature file
   
   
  Background:
  Given I landed on Nykaa HomePage
  
  @FullTest
  Scenario Outline: Login and add items to cart.
    Given Logged in with phonenumber <phonenumber>
    Then I verify my login with username <username>
    When I add items <items> with itemsCount <itemsCount> in cart
    Then I visit the cart and verify the items present in it

    Examples: 
      | phonenumber  | username | items  				|itemsCount|
      | 9822782485 	 | Abdul    | Face Masks		|3				 |
     	| 9822782485 	 | Abdul    | Face Serum		|1				 |
