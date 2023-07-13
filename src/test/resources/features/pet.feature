Feature: Manage a pet in the PetStore
  Scenario: List only available pets for sale
    Given that I have available pets
    When I search for all available pets
    Then I receive a list of available pets