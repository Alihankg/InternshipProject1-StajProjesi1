package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_012 {
    ContentPage contentPage = new ContentPage();
    @When("I add Nationality in Nationalities")
    public void iAddNationalityInNationalities() {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogField("Name", "Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I update Nationality in Nationalities")
    public void iUpdateNationalityInNationalities() {
        contentPage.edit();
        contentPage.fillDialogField("Name", "Update Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Nationality in Nationalities")
    public void iDeleteNationalityInNationalities() {
        contentPage.deleteAndConfirm();
    }
}
