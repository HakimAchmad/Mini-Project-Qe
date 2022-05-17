@Login
Feature: Login
  As a user
  I want to login
  So that I can access my homepage AltaShop

  Background:
    Given I am on the landing page
    And I click button to login page
  Scenario Outline: Login scenario
    When I input "<email>" email
    And I input "<password>" password
    And click login button
    Then I get the "<result>"
    Examples:
      |       email      |password|result        |
      |hakim001@gmail.com|Valid@01|Success       |
      |                  |Valid@01|Error Email   |
      |hakim001@gmail.com|        |Error Password|
      |                  |        |Error Email   |
      |a                 |  b     |Error Double  |
