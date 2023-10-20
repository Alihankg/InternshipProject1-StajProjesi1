package stepDefs;

import drivers.Driver;
import drivers.MyFunc;
import helpers.SeleniumShortcuts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.NavbarPage;

public class AC_08 {
    SeleniumShortcuts ss = new SeleniumShortcuts();
    NavbarPage np = new NavbarPage();
    private WebElement driver;

    @And("enter into document types")
    public void enterIntoDocumentTypes() {
        ss.click(np.setup);
        ss.click(np.schoolsetup);
        ss.click(np.departments);
    }

    @Then("Create Citizenship")
    public void createCitizenship() {
        ss.click(np.button7);
        ss.sendKeys(np.name, "osma");
        ss.sendKeys(np.code, "2");
        ss.click(np.save);
    }



    @Then("edit the name later")
    public void editTheNameLater() {
        MyFunc.Bekle(2);

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
        MyFunc.Bekle(2);
        WebElement nameElement = driver.findElement(By.name("ali Yılmaz"));
        nameElement.click();
        nameElement.sendKeys("ali Yılmaz");
        ss.click(np.deletes);
        ss.click(np.deleteConfirm);
    }
}
