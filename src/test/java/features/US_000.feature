Feature: Login Functionality
  As a user, I want to be able to log in 'test.mersys.io' as an admin,
  so that I can access to manager functionalities by successfully logging into the system.

  Scenario: User logs in to the system as the admin
    Given I am on the login page
    When I enter the valid credentials
    Then I should be logged in successfully