Feature: Position Manage

  Scenario: Login with valid username and password

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Position Categories
    When Create a New Position Category
    Then Success message should be displayed
    When User delete the "name"
    Then Success message should be displayed