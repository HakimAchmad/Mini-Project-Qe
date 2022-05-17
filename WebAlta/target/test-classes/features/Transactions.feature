@Transactions
Feature: Transactions
  As a user
  I want to Transactions Product
  So that I can manage Transactions product in AltaShop

  Scenario Outline: Transactions Success
    Given I am login account
    And I Input "<Email>" Email
    And I Input "<Password>" Password
    And I click button login
    And I click buy product
    When I choose button cart
    And I choose button plus
    And I click button pay
    Then I get success transaction

    Examples:
      |       Email      |Password|
      |hakim001@gmail.com|Valid@01|


  Scenario: Failed Transactions
    Given I am on the HomePage
    And I click buy product
    When I choose button cart
    And I choose button plus
    And I click button pay
    Then I get redirect login page
