Feature: Managing a user in the pet store

  @deleteAllUsers
Scenario: Create a user in the pet store in a business way
  When I create a user
  Then the created user was stored