@Order
Feature: Order
  As a user
  I want to Order Product
  So that I can manage my order product in AltaShop

  Scenario Template: Preparation Order
    Given I am login account AltaShop
    And I enter "<Email>" Email
    And I enter "<Password>" Password
    And I click login button
    And I choose buy product
    When I click button cart
    Examples:
      |       Email      |Password|
      |hakim001@gmail.com|Valid@01|


  Scenario: Add amount order Product
    And I click button plus
    Then I get add amount order

  Scenario: Minus amount order Product
    And I click button minus
    Then I get minus amount order
