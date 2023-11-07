package stepDefs;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pages.LoginPage;

public class US_000 {
    LoginPage loginPage;

    public US_000() {
        loginPage = PageObjectManager.getLoginPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
        String adminUsername = ConfigFileReader.getAdminUsername(),
                adminPassword = ConfigFileReader.getAdminPassword();
        loginPage.enterUsername(adminUsername);
        loginPage.enterPassword(adminPassword);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        loginPage.assertLogin();
    }

    @Given("I am logged in as an admin in the dashboard")
    public void iAmLoggedInAsAnAdminInTheDashboard() {
        iAmOnTheLoginPage();
        iEnterTheValidCredentials();
        iClickTheLoginButton();
        iShouldBeLoggedInSuccessfully();
    }
}
