Feature: AC_08 functionality

  Background:
    Given I am on the login page
    When I enter the valid credentials
    And I click the login button
    Then I should be logged in successfully

  Scenario: Login with valid username and password
    And enter into document types
    Then Create Citizenship
    Then edit the name later
    Then delete the contact

