@Rating
Feature: Ratings

  Scenario: Get Product’s Ratings
    Given I set endpoint for get products rating
    When I request get products ratings
    Then I get verify status code is 200