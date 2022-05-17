@Product
Feature: Product
  As a user
  I want to Choose Product
  So that I can see or buy Product AltaShop

  @SeeProduct
  Scenario: See Product AltaShop
    Given I am on the landing page AltaShop
    When I don't buy product
    And I click button cart
    Then I get cart empty product

  @BuyProduct
  Scenario: Buying Product AltaShop
    Given I am on the landing page AltaShop
    When I click button buy product
    And I click button cart
    Then I get cart there is product