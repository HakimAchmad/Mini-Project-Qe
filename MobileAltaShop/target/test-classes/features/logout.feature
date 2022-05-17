@Logout
Feature: Logout
  As a user
  I want to Logout Account
  So that I can change Account AltaShop

  Scenario Outline: Success Logout
    Given I am on landing page
    And I choose button to login page
    And I Input "<email>" email
    And I Input "<password>" password
    And I Click login button
    When I am on the homepage
    And I choose button logout
    Then I get success logout

    Examples:
      |       email      |password|
      |hakim001@gmail.com|Valid@01|
