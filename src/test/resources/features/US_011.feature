Feature: Management of Discounts
  As an admin,
  I would like to add, edit and delete the items in Discounts page
  so that, we can configure Discounts' details more efficiently for the school management.

  Background:
    Given I am logged in as an admin in the dashboard
    And I've navigated to "Discounts"

  Scenario: Manage an item in Discounts

    When I add Discount in Discounts
    Then I should see "Discount successfully created" message

    When I update Discount in Discounts
    Then I should see "Discount successfully updated" message

    When I delete Discount in Discounts
    Then I should see "Discount successfully deleted" message