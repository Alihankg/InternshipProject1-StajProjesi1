Feature: Management of Pages in navbar
  As an admin,
  I would like to add, edit and delete the items in each page
  so that, we can configure each page's details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to Position Categories

  Scenario: Manage an item in Position Category

    When I add Position Category in Position Categories
    Then I should see "Position Category successfully created" message

    When I update Position Category in Position Categories
    Then I should see "Position Category successfully updated" message

    When I delete Position Category in Position Categories
    Then I should see "Position Category successfully deleted" message