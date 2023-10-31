package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DefaultPage;

public class US_002_positive {

    DefaultPage lp=new DefaultPage();

    @And("the user should be able to add documentation")
    public void theUserShouldBeAbleToAddDocumentation() {
        lp.click(lp.HumanResources);
        lp.click(lp.HumanSetup);
        lp.click(lp.Attestations);
        lp.click(lp.toAdd);
        lp.sendKeys(lp.AddName, "Proje1");
        lp.AddSave.click();
        
    }
    @And("the user should be able to edit documentation")
    public void theUserShouldBeAbleToEditDocumentation() {
        lp.sendKeys(lp.editDocumentation, "Proje2");
        lp.AddSave.click();
    }
    @Then("the user should be able to delete documentation")
    public void theUserShouldBeAbleToDeleteDocumentation() {
        lp.click(lp.KDelete);
    }
}
