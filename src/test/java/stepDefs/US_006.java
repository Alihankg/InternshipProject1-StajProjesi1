package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_006 {
    ContentPage contentPage = new ContentPage();

    @When("I add Subject in Subject Categories")
    public void iAddSubjectInSubjectCategories() {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogField("Name", "Alihan Name");
        contentPage.fillDialogField("Code", "Alihan Code");
        contentPage.saveAndConfirm();
    }

    @When("I update Subject in Subject Categories")
    public void iUpdateSubjectInSubjectCategories() {
        contentPage.edit();
        contentPage.fillDialogField("Name", "Updated Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Subject in Subject Categories")
    public void iDeleteSubjectInSubjectCategories() {
        contentPage.deleteAndConfirm();
    }
}
