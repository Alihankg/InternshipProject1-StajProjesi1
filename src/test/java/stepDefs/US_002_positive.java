package stepDefs;

import drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class US_002_positive {

    LoginPage lp=new LoginPage();

    @Given("a user logs into the system as an admin")
    public void aUserLogsIntoTheSystemAsAnAdmin() {
        Driver.getDriver().get("https://test.mersys.io/");
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
    lp.sendKeys(lp.username, "turkeyts");
    lp.sendKeys(lp.password, "TechnoStudy123");
    lp.click(lp.loginButton);
        
    }

    @And("the user should be able to add documentation")
    public void theUserShouldBeAbleToAddDocumentation() {
        lp.click(lp.HumanResources);
        lp.click(lp.HumanSetup);
        lp.click(lp.Attestations);
        lp.click(lp.toAdd);
        lp.sendKeys(lp.AddName, "Proje1");
        lp.AddSave.click();
        
    }


    @And("the user should be able to edit documentation")
    public void theUserShouldBeAbleToEditDocumentation() {
        lp.sendKeys(lp.editDocumentation, "Proje2");
        lp.AddSave.click();

        
    }

    @Then("the user should be able to delete documentation")
    public void theUserShouldBeAbleToDeleteDocumentation() {
        lp.click(lp.KDelete);
    }


}
