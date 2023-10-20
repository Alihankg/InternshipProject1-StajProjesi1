Feature: AC_08 functionality

  Scenario: Login with valid username and password

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

    And enter into document types
    Then Create Citizenship
    Then edit the name later
    Then delete the contact

