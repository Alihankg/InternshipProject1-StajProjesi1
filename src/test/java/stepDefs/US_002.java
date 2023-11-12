package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;
import static helpers.selenium.SeleniumHelper.*;

public class US_002 {

    ContentPage contentPage = new ContentPage();

    @When("I add Attestation in Attestations")
    public void iAddAttestationInAttestations() {
        click(contentPage.toastClose);
        contentPage.add();
        contentPage.waitUntilDialogDisplayed();
        contentPage.fillDialogField("Name", "Attestation");
        contentPage.saveAndConfirm();
    }

    @When("I update Attestation in Attestations")
    public void iUpdateAttestationInAttestations() {
        contentPage.edit();
        contentPage.fillDialogField("Name", "Attestation 2");
        contentPage.saveAndConfirm();
    }

    @When("I delete Attestation in Attestations")
    public void iDeleteAttestationInAttestations() {
        contentPage.deleteAndConfirm();
    }
}
