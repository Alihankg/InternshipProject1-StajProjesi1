package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_003 {

    ContentPage contentPage = new ContentPage();

    @When("I add Document in Document Types")
    public void iAddDocumentInDocumentTypes() throws InterruptedException {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogField("Name", "Alihan");
        contentPage.select("Stage", "Student Registration", "Examination");
        contentPage.fillDialogField("Description", "Some description about Alihan");
        contentPage.saveAndConfirm();
    }

    @When("I update Document in Document Types")
    public void iUpdateDocumentInDocumentTypes() {
    }

    @When("I delete Document in Document Types")
    public void iDeleteDocumentInDocumentTypes() {
    }
}
