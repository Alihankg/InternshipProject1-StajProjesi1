package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_010 {
    ContentPage contentPage = new ContentPage();
    @When("I add Grade Level in Grade Levels")
    public void iAddGradeLevelInGradeLevels() {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogInput("Name", "Alihan Name");
        contentPage.fillDialogInput("Short Name", "Alihan Short Name");
        contentPage.fillDialogInput("Order", "1");
        contentPage.fillDialogInput("Max Application Count", "10");
        contentPage.select("Next Grade", "violet _ i");
        contentPage.saveAndConfirm();
    }

    @When("I update Grade Level in Grade Levels")
    public void iUpdateGradeLevelInGradeLevels() {
        contentPage.edit();
        contentPage.fillDialogInput("Name", "Updated Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Grade Level in Grade Levels")
    public void iDeleteGradeLevelInGradeLevels() {
        contentPage.deleteAndConfirm();
    }
}
