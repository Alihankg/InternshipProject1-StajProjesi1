Feature: Management of Nationalities
  As an admin,
  I would like to add, edit and delete the items in Nationalities page
  so that, we can configure Nationalities' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Nationalities"

  Scenario: Manage an item in Nationalities

    When I add Nationality in Nationalities
    Then I should see "Nationality successfully created" message

    When I update Nationality in Nationalities
    Then I should see "Nationality successfully updated" message

    When I delete Nationality in Nationalities
    Then I should see "Nationality successfully deleted" message