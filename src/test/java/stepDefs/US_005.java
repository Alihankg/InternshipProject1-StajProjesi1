package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_005 {
    ContentPage contentPage = new ContentPage();
    @When("I add Position in Positions")
    public void iAddPositionInPositions() {
        contentPage.add();
        contentPage.fillDialogInput("Name", "Alihan Name");
        contentPage.fillDialogInput("Short Name", "Alihan Short Name");
        contentPage.saveAndConfirm();
    }

    @When("I update Position in Positions")
    public void iUpdatePositionInPositions() {
        contentPage.edit();
        contentPage.fillDialogInput("Name", "Updated Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Position in Positions")
    public void iDeletePositionInPositions() {
        contentPage.deleteAndConfirm();
    }
}
