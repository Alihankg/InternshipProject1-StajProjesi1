package stepDefs;

import drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US_002_positive {
    @Given("a user logs into the system as an admin")
    public void aUserLogsIntoTheSystemAsAnAdmin() {
        Driver.getDriver().get("https://test.mersys.io/");
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {

        
    }

    @And("the user should be able to add documentation")
    public void theUserShouldBeAbleToAddDocumentation() {
        
    }

    @Given("a user has logged into the system as an admin")
    public void aUserHasLoggedIntoTheSystemAsAnAdmin() {
        
    }

    @When("the user selects the {string} option")
    public void theUserSelectsTheOption(String arg0) {
        
    }

    @Then("the user should be able to add documents")
    public void theUserShouldBeAbleToAddDocuments() {
    }

    @And("the user should be able to edit documentation")
    public void theUserShouldBeAbleToEditDocumentation() {
        
    }

    @Then("the user should be able to edit documents")
    public void theUserShouldBeAbleToEditDocuments() {
        
    }

    @And("the user should be able to delete documentation")
    public void theUserShouldBeAbleToDeleteDocumentation() {
        
    }

    @Then("the user should be able to delete documents")
    public void theUserShouldBeAbleToDeleteDocuments() {
    }
}
