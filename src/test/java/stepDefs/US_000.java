package stepDefs;

import drivers.Driver;
import helpers.SeleniumShortcuts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class US_000 {

    SeleniumShortcuts ss = new SeleniumShortcuts();
    LoginPage lp = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://test.mersys.io/");
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
    }
}
