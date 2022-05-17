@Product
Feature: Products

  @GetAllProduct
  Scenario: Get All Products
    Given I set endpoint for get list products
    When I request get list products
    Then verify status code is 200

  @GetIdProduct
  Scenario: Get By Id Products
    Given I set endpoint for get by id products
    When I request get products by id
    Then verify status code is 200

  @CreateProduct
  Scenario Outline: Create Product
    Given I set an endpoint for create product
    When I input "<nameProduct>" name product
    Then validate create product status code is <status_code>
    And validate the "<message>" after request create product
    And get idProduct if "<message>" for other request
    Examples:
      |nameProduct |status_code |message  |
      |New         |200         |success  |
      |Empty       |500         |required |

