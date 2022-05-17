@Transaction
Feature: Transactions

  @GetAllTransaction
  Scenario: Get All Transactions
    Given I set endpoint for get all transactions
    When I request get detail all transactions
    Then I verify status code get transactions is 200

  @GetIdTransaction
  Scenario: Get By Id Transactions
    Given I set endpoint for get by id transactions
    When I request get transactions by id
    Then I verify status code get transactions is 200
    And validate the data transactions by id detail valid

  @PostValidTransaction
  Scenario Outline: POST - Create Transactions valid
    Given I set an endpoint for create transaction
    When I input <ProductId> and <Quantity>
    Then I validate status code is <status_code>
    And validate the "<message>" after request transaction valid
    Examples:
      |ProductId |Quantity |status_code |Message  |
      |100       |10       |200         |success  |

  @PostInvalidTransaction
  Scenario Outline: POST - Create Transactions Invalid
    Given I set an endpoint for create transaction
    When I input "<productId>" and "<quantity>"
    Then I validate status code is <status_code>
    And validate the "<message>" after request transaction invalid
    Examples:
      |productId |quantity |status_code |message  |
      |test      |test     |400         |required |
      |          |test     |400         |required |
      |test      |         |400         |required |
      |          |         |400         |required |


