Feature: Management of Fields
  As an admin,
  I would like to add, edit and delete the items in Fields page
  so that, we can configure Fields' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Fields"

  Scenario: Manage an item in Fields

    When I add Field in Fields
    Then I should see "Field successfully created" message

    When I update Field in Fields
    Then I should see "Field successfully updated" message

    When I delete Field in Fields
    Then I should see "Field successfully deleted" message