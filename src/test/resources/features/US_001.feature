Feature: Position Manage

  Scenario: Login with valid username and password

    Given I am on the login page
    When I enter the valid credentials
    And I click the login button
    Then I should be logged in successfully
    And Navigate to Position Categories

    When Create a New Position Category
    Then Success message should be displayed

    When User delete the "name"
    Then Success message should be displayed