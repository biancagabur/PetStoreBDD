Feature: Manage a pet in the PetStore
  Scenario: List only available pets for sale
    Given that I have available pets
    When I search for all available pets
    Then I receive a list of available pets

  Scenario: List only pending pets
    Given that I have pending pets
    When I search for all pending pets
    Then I receive a list of pending pets
    And I receive a list of pets of size 2 pets

  Scenario: Don't list any pets
    Given that I do not have any sold pets
    When I search for all sold pets
    Then I receive a list of pets of size 0 pets