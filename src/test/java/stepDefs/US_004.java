package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_004 {

    ContentPage contentPage = new ContentPage();

    @When("I add Field in Fields")
    public void iAddFieldInFields() {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogInput("Name", "Alihan Field");
        contentPage.fillDialogInput("Code", "Alihan Code");
        contentPage.select("Field Type", "Logical");
        contentPage.saveAndConfirm();
    }

    @When("I update Field in Fields")
    public void iUpdateFieldInFields() {
        contentPage.edit();
        contentPage.fillDialogInput("Name", "Updated Alihan Field");
        contentPage.select("Field Type", "Text");
        contentPage.saveAndConfirm();
    }

    @When("I delete Field in Fields")
    public void iDeleteFieldInFields() {
        contentPage.deleteAndConfirm();
    }
}
