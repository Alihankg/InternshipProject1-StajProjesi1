package stepDefs;

import helpers.selenium.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import managers.PageObjectManager;
import pages.ContentPage;
import pages.NavbarPage;

public class US_002_positive extends SeleniumHelper {

    NavbarPage navbarPage;
    ContentPage contentPage;

    public US_002_positive() {
        navbarPage = PageObjectManager.getNavbarPage();
        contentPage = PageObjectManager.getContentPage();
    }

    @And("the user should be able to add documentation")
    public void theUserShouldBeAbleToAddDocumentation() {
        click(navbarPage.humanResources);
        click(navbarPage.hrSetup);
        click(navbarPage.attestations);
        click(contentPage.add);
        sendKeys(contentPage.dialogName, "Proje1");
        click(contentPage.saveButton);
    }
    @And("the user should be able to edit documentation")
    public void theUserShouldBeAbleToEditDocumentation() {
        click(contentPage.edit);
        sendKeys(contentPage.dialogName, "Proje2");
        click(contentPage.saveButton);
    }
    @Then("the user should be able to delete documentation")
    public void theUserShouldBeAbleToDeleteDocumentation() {
        click(contentPage.delete);
        click(contentPage.confirmDelete);
    }
}
