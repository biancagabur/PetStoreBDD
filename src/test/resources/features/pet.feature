Feature: Manage a pet in the PetStore

  Scenario: List only available pets for sale
    Given that I have available pets
    When I search for all available pets
    Then I receive a list of available pets

  Scenario: List only pending pets
    Given that I have pending pets
    When I search for all pending pets
    Then I receive a list of pending pets

  Scenario: Don't list any pets
    Given that I do not have any sold pets
    When I search for all sold pets
    Then I receive a list of pets of size 0 pets

  Scenario: Check the pending pets number
    Given that I have pending pets
    When I search for all pending pets
    Then I receive a list of pets of size 2 pets

  Scenario Outline: List pets by its selling state
    Given that I do not have any sold pets
    When I search for all <status> pets
    Then I receive a list of pets of size <quantity> pets
    Examples: Pets in stock
    |status|quantity|
    |available|7    |
    |pending  |2    |
    Examples: Pets not in stock
    |status|quantity|
    |sold  |0       |

  Scenario: List pets available for selling
    Given that I have available pets
    When I search for all available pets
    Then I receive a list of pets of size 7 pets available
    And 3 pets have the name Lion

