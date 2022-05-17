@Register
Feature: Register
  As an User
  I want to get create user
  So that I can update registration account

  Scenario Outline: POST - Authentication Register
    Given I set an endpoint for create new user
    And I input "<fullname>" with "<email>" and "<password>"
    When I request detail email
    Then I validate the status code is <status_code>
    Examples:
      |fullname|email              |password |status_code |
      |Hakim01  |New               |Valid@01 |200         |
      |Hakim01  |hakim001@gmail.com|         |400         |
      |Hakim01  |                  |Valid@01 |400         |
      |         |hakim001@gmail.com|Valid@01 |400         |
      |         |                  |         |400         |
      |Hakim01  |Same              |Valid@01 |400         |