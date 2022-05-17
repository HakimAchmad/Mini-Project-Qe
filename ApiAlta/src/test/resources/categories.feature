@Category
Feature: Categories

  @GetAllCategory
  Scenario: Get All Categories
    Given I set endpoint for get list categories
    When I request get list categories
    Then I verify status code is 200

  @GetIdCategory
  Scenario: Get By Id Categories
    Given I set endpoint for get by id categories
    When I request get categories by id
    Then I verify status code is 200

  @PostCategory
  Scenario Outline: POST - Create Categories
    Given I set an endpoint for create categories
    When I input "<nameCategories>" name categories
    Then validate create category status code is <status_code>
    Examples:
      |nameCategories    |status_code |
      |New               |200         |
      |Empty             |500         |
