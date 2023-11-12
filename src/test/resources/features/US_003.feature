Feature: Management of Document Types
  As an admin,
  I would like to add, edit and delete the items in Document Types page
  so that, we can configure Document Types' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Document Types"

  Scenario: Manage an item in Attestations

    When I add Document in Document Types
    Then I should see "Document successfully created" message

    When I update Document in Document Types
    Then I should see "Document successfully updated" message

    When I delete Document in Document Types
    Then I should see "Document successfully deleted" message