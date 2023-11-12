Feature: Management of Locations
  As an admin,
  I would like to add, edit and delete the items in Locations page
  so that, we can configure Locations' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Locations"

  Scenario: Manage an item in Locations

    When I add Location in Locations
    Then I should see "Location successfully created" message

    When I update Location in Locations
    Then I should see "Location successfully updated" message

    When I delete Location in Locations
    Then I should see "Location successfully deleted" message