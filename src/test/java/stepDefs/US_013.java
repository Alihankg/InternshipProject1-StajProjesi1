package stepDefs;

import helpers.StringHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContentPage;
import pages.NavbarPage;

public class US_013 {

    ContentPage contentPage = new ContentPage();
    NavbarPage navbarPage = new NavbarPage();

    @Given("I've navigated to {}")
    public void iVeNavigatedTo(String page) {
        navbarPage.navigateToPage(page);
    }

    @When("I add a new item with following credentials:")
    public void iAddANewItemWithFollowingCredentials(String fieldsTable) {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        // Implementation of adding code
        contentPage.saveAndConfirm();
    }

    @When("I update the item with following credentials:")
    public void iUpdateTheItemWithFollowingCredentials(String fieldsTable) {
        contentPage.edit();
        // Implementation of editing code
        contentPage.saveAndConfirm();
    }

    @When("I delete the item")
    public void iDeleteTheItem() {
        contentPage.deleteAndConfirm();
    }

    @Then("There should be \\({} item successfully {string}) message")
    public void thereShouldBeSuccessfullyMessage(String page, String action) {
        String item;
        if (page.equals("Subject Catogories"))
            item = "Subject";
        else
            item = StringHelper.singularize(page);
        String message = item + " successfully " + action;
        contentPage.assertMessageDisplayedAndClose(message);
    }
}
