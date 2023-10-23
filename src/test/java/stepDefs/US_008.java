package stepDefs;

import helpers.WaitHelpers;
import helpers.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.NavbarPage;

public class US_008 {
    SeleniumHelper sh = new SeleniumHelper();
    NavbarPage np = new NavbarPage();
    private WebElement driver;

    @And("enter into document types")
    public void enterIntoDocumentTypes() {
        sh.click(np.setup);
        sh.click(np.schoolsetup);
        sh.click(np.departments);
    }

    @Then("Create Citizenship")
    public void createCitizenship() {
        sh.click(np.button7);
        sh.sendKeys(np.name, "osma");
        sh.sendKeys(np.code, "2");
        sh.click(np.save);
    }



    @Then("edit the name later")
    public void editTheNameLater() {
        WaitHelpers.wait(2);

        WebElement nameElement = driver.findElement(By.name("osman"));
        nameElement.click();
        nameElement.clear();
        nameElement.sendKeys("yusuf za");
//        ss.click(np.edit);
//        ss.sendKeys(np.name, "yusuf Yılmaz");
//        ss.click(np.save);
    }

    @Then("delete the contact")
    public void deleteTheContact() {
        WaitHelpers.wait(2);
        WebElement nameElement = driver.findElement(By.name("ali Yılmaz"));
        nameElement.click();
        nameElement.sendKeys("ali Yılmaz");
        sh.click(np.deletes);
        sh.click(np.deleteConfirm);
    }
}
