@Product
Feature: Product
  As a user
  I want to Choose Product
  So that I can see or buy Product AltaShop

  Scenario: See Product AltaShop
    Given I am on the HomePage AltaShop
    When I don't buy product
    And I click button cart
    Then I get empty cart product

  Scenario: Buying Product AltaShop
    Given I am on the HomePage AltaShop
    When I click button buy product
    And I click button cart
    Then I get purchase amount product

  Scenario: Rating Product AltaShop
    Given I am on the HomePage AltaShop
    When I click button detail product
    Then I get detail rating product