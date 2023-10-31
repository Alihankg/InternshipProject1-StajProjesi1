package stepDefs;

import dataProvider.ConfigFileReader;
import helpers.cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class US_000 {
    ConfigFileReader configFileReader = FileReaderManager.getInstance().getConfigReader();
    WebDriver driver = DriverManager.getDefaultDriver();
    TestContext testContext;
    LoginPage lp;

    public US_000(TestContext context) {
        testContext = context;
        lp = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get(configFileReader.getApplicationURL());
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
        String username = configFileReader.getAdminUsername(),
                password = configFileReader.getAdminPassword();
        lp.enterUsername(username);
        lp.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        lp.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        lp.assertLogin();
    }

}
