Feature: Management of Positions
  As an admin,
  I would like to add, edit and delete the items in Positions page
  so that, we can configure Positions' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Positions"

  Scenario: Manage an item in Positions

    When I add Position in Positions
    Then I should see "Position successfully created" message

    When I update Position in Positions
    Then I should see "Position successfully updated" message

    When I delete Position in Positions
    Then I should see "Position successfully deleted" message