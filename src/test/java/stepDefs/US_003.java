package stepDefs;

import helpers.selenium.SeleniumHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.NavbarPage;

public class US_003 {

    SeleniumHelper sh = new SeleniumHelper();
    NavbarPage np = new NavbarPage();
    LoginPage lp = new LoginPage();

    @Then("go to document types")
    public void gotodocumenttypes() {
        sh.click(np.setup);
        sh.click(np.parameters);
        sh.click(np.documentTypes);
    }

    @When("Create a Citizenship")
    public void CreateaCitizenship() {
        sh.click(np.button7);
        sh.sendKeys(np.name, "ahmet");
        sh.click(np.stage);
        sh.click(np.button);
        new Actions(DriverManager.getDefaultDriver()).sendKeys(Keys.ESCAPE).build().perform();
        sh.click(np.save);
    }

    @Then("name should be corrected later")
    public void nameshouldbecorrectedlater() {
        sh.threadWait(2);
        sh.click(np.edit);
        sh.sendKeys(np.name, "Ahmet Yılmaz");
        sh.click(np.save);
    }

    @Then("contact should then be able to be deleted")
    public void contactShouldThenBeAbleToBeDeleted() {
        sh.threadWait(2);
        sh.click(np.delete);
        sh.click(np.deleteConfirm);
    }
}
