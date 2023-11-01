package stepDefs;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class US_000 {
    WebDriver driver = DriverManager.getDefaultDriver();
    LoginPage lp = new LoginPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get(ConfigFileReader.getApplicationURL());
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
//        String username = ConfigFileReader.getAdminUsername(),
//                password = ConfigFileReader.getAdminPassword();
        System.out.println("Buraya geldik!");
        lp.enterPassword("TechnoStudy123");
        lp.enterUsername("turkeyts");
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
