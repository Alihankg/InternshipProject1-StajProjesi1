package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_004 {

    ContentPage contentPage = new ContentPage();

    @When("I add Field in Fields")
    public void iAddFieldInFields() {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogField("Name", "Alihan Field");
        contentPage.fillDialogField("Code", "Alihan Code");
        contentPage.select("Field Type", "Logical");
        contentPage.saveAndConfirm();
    }

    @When("I update Field in Fields")
    public void iUpdateFieldInFields() {
        contentPage.edit();
        contentPage.fillDialogField("Name", "Updated Alihan Field");
        contentPage.select("Field Type", "Text");
        contentPage.saveAndConfirm();
    }

    @When("I delete Field in Fields")
    public void iDeleteFieldInFields() {
        contentPage.deleteAndConfirm();
    }
}
