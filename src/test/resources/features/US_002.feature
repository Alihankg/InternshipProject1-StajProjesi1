Feature: Documentation Management

  Background:
    Given I am logged in as an admin in the dashboard

  Scenario: User Management and Documentation Operations
    And the user should be able to add documentation
    And the user should be able to edit documentation
    Then the user should be able to delete documentation