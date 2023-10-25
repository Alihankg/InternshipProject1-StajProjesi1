package stepDefs;

import drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class US_000 {
    LoginPage lp = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://test.mersys.io/");
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
        String username = "turkeyts", password = "TechnoStudy123";
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
