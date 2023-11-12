Feature: Management of Bank Accounts
  As an admin,
  I would like to add, edit and delete the items in Bank Accounts page
  so that, we can configure Bank Accounts' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Bank Accounts"

  Scenario: Manage an item in Bank Accounts

    When I add Bank Account in Bank Accounts
    Then I should see "Bank Account successfully created" message

    When I update Bank Account in Bank Accounts
    Then I should see "Bank Account successfully updated" message

    When I delete Bank Account in Bank Accounts
    Then I should see "Bank Account successfully deleted" message