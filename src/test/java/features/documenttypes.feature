#turkeyts
#TechnoStudy123

Feature: document types functionality

  Scenario: Login with valid username and password

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

    And go to document types
    When Create a Citizenship
    Then name should be corrected later
    Then contact should then be able to be deleted

