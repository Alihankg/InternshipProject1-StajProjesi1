package stepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.NavbarPage;

public class US_005_PositionAdd {

    LoginPage lp=new LoginPage();
    NavbarPage np=new NavbarPage();
    @And("Navigate to Positions")
    public void navigateToPositions() {
        np.click(np.humanResou);
        np.click(np.Setup);
        np.wait.until(ExpectedConditions.elementToBeClickable(np.positionCate));
        np.click(np.position);
    }
    String positionName1 ="Company Develop";
    String posiShrtName ="CompDev";
    @When("Create a New Position")
    public void createANewPosition() {
        lp.click(lp.addButton);
        lp.sendKeys(lp.nameInput, positionName1);
        lp.click(lp.shrtName);
        lp.sendKeys(lp.shrtName, posiShrtName);
        lp.click(lp.saveButton);
    }

    String positionName2 ="Company Development";
    @And("Edit the position")
    public void editThePosition() {
        lp.click(lp.searchBtn);
        lp.sendKeys(lp.searchBtn,positionName1);
        lp.click(lp.searchPicBtn);
        lp.wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));
        lp.click(lp.editPicBtn);
        lp.click(lp.nameInput);
        lp.nameInput.clear();
        lp.nameInput.sendKeys(positionName2);
        lp.click(lp.swtchActivty);
        lp.click(lp.saveButton);

    }

    @When("User delete")
    public void userDelete() {
        lp.click(lp.searchBtn);
        lp.sendKeys(lp.searchBtn,positionName2);
        lp.click(lp.searchPicBtn);
        lp.wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));
        lp.click(lp.deletePicBtn);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lp.click(lp.deleteBtn);

    }
}
