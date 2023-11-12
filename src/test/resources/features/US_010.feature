Feature: Management of Grade Levels
  As an admin,
  I would like to add, edit and delete the items in Grade Levels page
  so that, we can configure Grade Levels' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Grade Levels"

  Scenario: Manage an item in Grade Levels

    When I add Grade Level in Grade Levels
    Then I should see "Grade Level successfully created" message

    When I update Grade Level in Grade Levels
    Then I should see "Grade Level successfully updated" message

    When I delete Grade Level in Grade Levels
    Then I should see "Grade Level successfully deleted" message