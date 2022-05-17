@Logout
Feature: Logout
  As a user
  I want to Logout Account
  So that I can change Account AltaShop

  Scenario Outline: Success Logout
    Given I am login account page
    And I Input "<email>" email
    And I Input "<password>" password
    And I Click login button
    When I Click button account
    And I choose button logout
    Then I get success logout

    Examples:
      |       email      |password|
      |hakim001@gmail.com|Valid@01|


