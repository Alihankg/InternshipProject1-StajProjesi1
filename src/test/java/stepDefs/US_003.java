package stepDefs;

import drivers.Driver;
import helpers.WaitHelpers;
import helpers.SeleniumHelper;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.NavbarPage;

public class US_003 {

    SeleniumHelper sh = new SeleniumHelper();
    NavbarPage np = new NavbarPage();
    LoginPage lp = new LoginPage();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        Driver.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        sh.sendKeys(lp.username, "turkeyts");
        sh.sendKeys(lp.password, "TechnoStudy123");
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        sh.click(lp.loginButton);
        sh.click(lp.txtTechnoStudy);
    }

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
        new Actions(Driver.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
        sh.click(np.save);
    }

    @Then("name should be corrected later")
    public void nameshouldbecorrectedlater() {
        WaitHelpers.wait(2);
        sh.click(np.edit);
        sh.sendKeys(np.name, "Ahmet Yılmaz");
        sh.click(np.save);
    }

    @Then("contact should then be able to be deleted")
    public void contactShouldThenBeAbleToBeDeleted() {
        WaitHelpers.wait(2);
        sh.click(np.delete);
        sh.click(np.deleteConfirm);
    }
}
