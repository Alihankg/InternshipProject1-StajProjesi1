package stepDefs;

import drivers.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.NavbarPage;

public class US_001 {

    LoginPage lp=new LoginPage();
    NavbarPage np=new NavbarPage();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        Driver.getDriver().get("https://test.mersys.io/");
    }

//    @When("Enter username and password and click login button")
//    public void LoginStuff() {
//        lp.sendKeys(lp.username, "turkeyts");
//        lp.sendKeys(lp.password, "TechnoStudy123");
//        lp.click(lp.loginButton);
//    }

    @Then("User should login successfully")
    public void loginSuccessfully() {
        lp.assertTextPresent(lp.txtTechnoStudy,"Techno Study");

    }

    @And("Navigate to Position Categories")
    public void createCategori(){
        np.click(np.humanResou);
        np.click(np.Setup);
        np.wait.until(ExpectedConditions.elementToBeClickable(np.positionCate));
        np.click(np.positionCate);
    }

    @When("Create a New Position Category")
    public void addPosiCategory(){
        lp.click(lp.addButton);
        lp.sendKeys(lp.nameInput, "Evulation");
        lp.click(lp.saveButton);
    }

    @Then ("^Success message should be displayed$")
    public void succesMessage(){
        lp.assertTextPresent(lp.successMessage,"successfully");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String name) {
        lp.click(lp.searchBtn);
        lp.sendKeys(lp.searchBtn,"Evulation");
        lp.click(lp.searchPicBtn);
        lp.wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));
        lp.click(lp.deletePicBtn);
        lp.click(lp.deleteBtn);
    }
}
