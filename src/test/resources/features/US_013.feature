@SmokeTest
Feature: Management of Pages' functionality in the navbar
  As an admin,
  I would like to add, edit and delete the items in each page
  so that, we can configure Position Categories' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard

  Scenario Outline: Manage an item in its belonging page

    Given I've navigated to <page>
    When I add a new item with following credentials:
      | <add_fields> |
    Then There should be (<page> item successfully "created") message

    When I update the item with following credentials:
      | <edit_fields> |
    Then There should be (<page> item successfully "updated") message

    When I delete the item
    Then There should be (<page> item successfully "deleted") message

    Examples: Pages and Fields
      | page                | add_fields            | edit_fields                   |
      | Position Categories | Name = My PC          | Name = My Updated PC          |
      | Attestations        | Name = My Attestation | Name = My Updated Attestation |