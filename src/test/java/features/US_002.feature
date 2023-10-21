Feature: Documentation Management

  Scenario: User Management and Documentation Operations
    Given a user logs into the system as an admin
    Then the user should be logged in

    And the user should be able to add documentation
    Given a user has logged into the system as an admin
    When the user selects the "Add Document" option
    Then the user should be able to add documents

    And the user should be able to edit documentation
    When the user selects the "Edit Document" option
    Then the user should be able to edit documents

    And the user should be able to delete documentation
    When the user selects the "Delete Document" option
    Then the user should be able to delete documents