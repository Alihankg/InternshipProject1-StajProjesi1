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
    Then the result message should contain 'successfully created'

    When I update the item with following credentials:
      | <edit_fields> |
    Then the result message should contain 'successfully updated'

    When I delete the item
    Then the result message should contain 'successfully deleted'

    Examples: Pages and Fields
      | page                | add_fields                                                                                                | edit_fields                       |
      | Position Categories | Name = My PC                                                                                              | Name = My Updated PC              |
      | Attestations        | Name = My Attestation                                                                                     | Name = My Updated Attestation     |
      | Document Types      | Name = My DT, Stage = Employment + Contract, Description:= My desc                                        | Name = My Updated DT              |
      | Fields              | Name = My Field, Code = Field Code, Field Type = Logical                                                  | Name = My Updated Field           |
      | Positions           | Name = My Position, Short Name = My Short Name                                                            | Name = My Updated Name            |
      | Subject Categories  | Name = My Subject, Code = My Subject Code                                                                 | Name = My Updated Subject         |
      | Locations           | Name = My Location, Short Name = Short Location, Capacity = 10, Location Type = Laboratory                | Name = My Updated Location        |
      | Departments         | Name = My Department, Code = Department Code                                                              | Name = My Updated Department      |
      | Bank Accounts       | Name = My Account, IBAN = My IBAN, Currency = KGS, Integration Code = My Code                             | Name = My Updated Account         |
      | Grade Levels        | Name = My Level, Short Name = Short Level, Order = 1, Max Application Count = 10, Next Grade = violet _ i | Name = My Updated Level           |
      | Discounts           | Description = My Discount, Priority = 1, Integration Code = My Code                                       | Description = My Updated Discount |
      | Nationalities       | Name = My Nationality                                                                                     | Name = My Updated Nationality     |