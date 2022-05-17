@Login
Feature: Login
  As an User
  I want to get detail user
  So that I can manage account user

  Scenario Outline: POST - Authentication Login
    Given I set an endpoint for login user
    And I input "<email>" with "<password>"
    When I request detail account email user
    Then validate status code is <status_code>
    And validate the "<message>" after request login
   And get token if "<message>" for other request
    Examples:
      |email              |password |status_code |message  |
      |hakim001@gmail.com |Valid@01 |200         |success  |
      |                   |Valid@01 |400         |required |
      |hakim001@gmail.com |         |400         |required |
      |                   |         |400         |required |
      |hakim001@gmail.com |Valid@   |400         |required |