Feature: Management of Subject Categories
  As an admin,
  I would like to add, edit and delete the items in Subject Categories page
  so that, we can configure Subject Categories' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Subject Categories"

  Scenario: Manage an item in Subject Categories

    When I add Subject in Subject Categories
    Then I should see "Subject Category successfully created" message

    When I update Subject in Subject Categories
    Then I should see "Subject Category successfully updated" message

    When I delete Subject in Subject Categories
    Then I should see "Subject Category successfully deleted" message