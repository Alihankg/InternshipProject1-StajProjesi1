package stepDefs;

import helpers.selenium.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NavbarPage;

public class US_008 {
    SeleniumHelper sh = new SeleniumHelper();
    NavbarPage np = new NavbarPage();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        sh.navigateTo("https://test.mersys.io");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        sh.click(np.setup);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        sh.click(np.schoolsetup);

    }

    @And("enter into document types")
    public void enterIntoDocumentTypes() {
        sh.click(np.departments);
    }

    @Then("Create Citizenship")
    public void createCitizenship() {
        sh.click(np.table);
        sh.click(np.button7);
        sh.sendKeys(np.name, "osman");
        sh.sendKeys(np.code, "2");
        sh.click(np.save);
    }



    @Then("edit the name later")
    public void editTheNameLater() {
        sh.click(np.edit);
        sh.sendKeys(np.name, "osman yusuf");
        sh.click(np.save);
    }

    @Then("delete the contact")
    public void deleteTheContact() {
        sh.click(np.deletes);
        sh.click(np.deleteConfirm);
    }



}
