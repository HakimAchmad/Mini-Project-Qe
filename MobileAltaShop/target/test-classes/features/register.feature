@Register
Feature: Register
  As a user
  I want to register
  So that I can create my account AltaShop

  Background:
    Given I am on the Landing page
    And I choose button to Login page
    And I Click text register
  Scenario Outline: Register scenario
    When I input "<fullName>" fullName
    And I input "<Email>" Email
    And I input "<Password>" Password
    And click register button
    Then I Get the "<output>"
    Examples:
       |fullName|Email             |Password|output        |
       |Hakim01 |New               |Valid@01|Success       |
       |Hakim01 |hakim001@gmail.com|        |Error Password|
       |        |hakim001@gmail.com|Valid@01|Error Name    |
       |Hakim01 |                  |Valid@01|Error Email   |
       |        |                  |        |Error Email   |
       |Hakim01 |hakim001@gmail.com|Valid@01|Error ALL     |
