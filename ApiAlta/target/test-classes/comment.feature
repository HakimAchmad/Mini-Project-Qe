@Comment
Feature: Comment

  @GetComment
  Scenario: Get Product’s Comments
    Given I set endpoint for get comment by id
    When I request get comment products by id
    Then I verify status code comment is 200

  @PostComment
Scenario Outline: POST - Create Comment
    Given I set an endpoint for create comment
    When I input "<Comment>"
    Then I validate comment status code is <status_code>
    And validate the "<Message>" after request comment
    Examples:
      |Comment  |status_code |Message  |
      |True     |200         |success  |
      |Empty    |500         |error    |


