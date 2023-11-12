package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_007 {
    ContentPage contentPage = new ContentPage();
    @When("I add Location in Locations")
    public void iAddLocationInLocations() {
        contentPage.add();
        contentPage.fillDialogField("Name", "Alihan Name");
        contentPage.fillDialogField("Short Name", "Alihan Short Name");
        contentPage.fillDialogField("Capacity", "10");
        contentPage.select("Location Type", "Laboratory");
        contentPage.saveAndConfirm();
    }

    @When("I update Location in Locations")
    public void iUpdateLocationInLocations() {
        contentPage.edit();
        contentPage.fillDialogField("Name", "Updated Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Location in Locations")
    public void iDeleteLocationInLocations() {
        contentPage.deleteAndConfirm();
    }
}
