@Register
Feature: Register
  As a user
  I want to register
  So that I can create my account AltaShop

  Background:
    Given I am on the register page
  Scenario Outline: Register scenario
    When I input "<fullName>" fullName
    And I input "<Email>" Email
    And I input "<Password>" Password
    And click register button
    Then I Get the "<output>"
    Examples:
       |fullName|Email             |Password|output       |
       |Hakim01 |New               |Valid@01|login page   |
       |Hakim01 |hakim001@gmail.com|        |register page|
       |        |hakim001@gmail.com|Valid@01|register page|
       |Hakim01 |                  |Valid@01|register page|
       |        |                  |        |register page|
