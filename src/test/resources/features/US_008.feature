Feature: Management of Departments
  As an admin,
  I would like to add, edit and delete the items in Departments page
  so that, we can configure Departments' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Departments"

  Scenario: Manage an item in Departments

    When I add Department in Departments
    Then I should see "Department successfully created" message

    When I update Department in Departments
    Then I should see "Department successfully updated" message

    When I delete Department in Departments
    Then I should see "Department successfully deleted" message