@Login
Feature: Login
  As a user
  I want to login
  So that I can access my homepage AltaShop

  Background:
    Given I am on the login page
  Scenario Outline: Login scenario
    When I input "<email>" email
    And I input "<password>" password
    And click login button
    Then I get the "<result>"
    Examples:
      |       email      |password|result    |
      |hakim001@gmail.com|Valid@01|home page |
      |                  |Valid@01|login page|
      |hakim001@gmail.com|        |login page|
      |                  |        |login page|
      |a                 |  b     |login page|


