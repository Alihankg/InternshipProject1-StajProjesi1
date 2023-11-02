package stepDefs;

import helpers.cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pages.LoginPage;

public class US_000 {
    TestContext testContext;
    LoginPage loginPage;

    public US_000(TestContext context) {
        testContext = context;
        loginPage = PageObjectManager.getLoginPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
        loginPage.enterUsername();
        loginPage.enterPassword();
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        loginPage.assertLogin();
    }

}
