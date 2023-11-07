Feature: Position Categories Management
  As an admin,
  I would like to add, edit and delete the Position Categories under Human Resources Setings,
  so that, thanks to the Position Categories Management, we can configure the human resources details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard

  Scenario: Login with valid username and password

    And Navigate to Position Categories

    When Create a New Position Category
    Then Success message should be displayed

    When User delete the "name"
    Then Success message should be displayed