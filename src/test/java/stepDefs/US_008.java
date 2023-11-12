package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_008 {
    ContentPage contentPage = new ContentPage();
    @When("I add Department in Departments")
    public void iAddDepartmentInDeparments() {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogInput("Name", "Alihan Name");
        contentPage.fillDialogInput("Code", "Alihan Code");
        contentPage.saveAndConfirm();
    }

    @When("I update Department in Departments")
    public void iUpdateDepartmentInDeparments() {
        contentPage.edit();
        contentPage.fillDialogInput("Name", "Updated Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Department in Departments")
    public void iDeleteDepartmentInDeparments() {
        contentPage.deleteAndConfirm();
    }
}
