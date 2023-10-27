Feature: Position Adding

  Scenario: Position Adding
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Positions

    When Create a New Position
    Then Success message should be displayed
    And Edit the position

    When User delete
    Then Success message should be displayed






