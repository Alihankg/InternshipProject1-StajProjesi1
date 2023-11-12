Feature: Management of Attestations
  As an admin,
  I would like to add, edit and delete the items in Attestations page
  so that, we can configure Attestations' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Attestations"

  Scenario: Manage an item in Attestations

    When I add Attestation in Attestations
    Then I should see "Attestation successfully created" message

    When I update Attestation in Attestations
    Then I should see "Attestation successfully updated" message

    When I delete Attestation in Attestations
    Then I should see "Attestation successfully deleted" message