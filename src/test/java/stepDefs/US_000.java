package stepDefs;

import helpers.cucumber.TestContext;
import managers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class US_000 {
    WebDriver driver = DriverManager.getDriver();
    FileReaderManager fileReaderManager = new FileReaderManager();
    TestContext testContext;
    LoginPage lp;

    public US_000(TestContext context) {
        testContext = context;
        lp = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get(fileReaderManager.getConfigReader().getApplicationURL());
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
        String username = fileReaderManager.getConfigReader().getAdminUsername(), password = fileReaderManager.getConfigReader().getAdminPassword();
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
