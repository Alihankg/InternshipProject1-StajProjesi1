package stepDefs;

import io.cucumber.java.en.When;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static helpers.selenium.SeleniumHelper.*;
import pages.ContentPage;

public class US_003 {

    ContentPage contentPage = new ContentPage();

    // Special case: enter the description
    private void fillDescription(String description){
        WebElement element = DriverManager.getDefaultDriver().findElement(By.xpath("//mat-label[text()='Description']/ancestor::span/preceding-sibling::*"));
        sendKeys(element, description);
    }

    @When("I add Document in Document Types")
    public void iAddDocumentInDocumentTypes() {
        contentPage.sort();contentPage.sort();
        contentPage.add();
        contentPage.fillDialogInput("Name", "Alihan");
        contentPage.select("Stage", "Student Registration", "Examination");
        fillDescription("Some description about Alihan");
        contentPage.saveAndConfirm();
    }

    @When("I update Document in Document Types")
    public void iUpdateDocumentInDocumentTypes() {
        contentPage.edit();
        contentPage.fillDialogInput("Description", "Some updated description about Alihan");
        fillDescription("Some updated description about Alihan");
        contentPage.saveAndConfirm();
    }

    @When("I delete Document in Document Types")
    public void iDeleteDocumentInDocumentTypes() {
        contentPage.deleteAndConfirm();
    }
}
