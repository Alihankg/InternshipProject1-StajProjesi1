package stepDefs;

import drivers.Driver;
import drivers.MyFunc;
import helpers.SeleniumShortcuts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.NavbarPage;

public class documenttypes {

    SeleniumShortcuts ss = new SeleniumShortcuts();
    NavbarPage np = new NavbarPage();
    LoginPage lp = new LoginPage();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        Driver.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        ss.sendKeys(lp.username, "turkeyts");
        ss.sendKeys(lp.password, "TechnoStudy123");
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        ss.click(lp.login);
        ss.click(lp.txtTechnoStudy);
    }

    @Then("go to document types")
    public void gotodocumenttypes() {
        ss.click(np.setup);
        ss.click(np.parameters);
        ss.click(np.documentTypes);
    }

    @When("Create a Citizenship")
    public void CreateaCitizenship() {
        ss.click(np.button7);
        ss.sendKeys(np.name, "ahmet");
        ss.click(np.stage);
        ss.click(np.button);
        new Actions(Driver.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
        ss.click(np.save);
    }

    @Then("name should be corrected later")
    public void nameshouldbecorrectedlater() {
        MyFunc.Bekle(2);
        ss.click(np.edit);
        ss.sendKeys(np.name, "Ahmet Yılmaz");
        ss.click(np.save);
    }

    @Then("contact should then be able to be deleted")
    public void contactShouldThenBeAbleToBeDeleted() {
        MyFunc.Bekle(2);
        ss.click(np.delete);
        ss.click(np.deleteConfirm);
    }
}
