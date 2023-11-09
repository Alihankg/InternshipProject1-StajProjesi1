package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContentPage extends PageObject{

    @FindBy(xpath = "//ms-add-button//button")
    public WebElement add;

    @FindBy(xpath = "//ms-edit-button//button")
    public WebElement edit;

    @FindBy(xpath = "//ms-delete-button//button")
    public WebElement delete;

    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()=' Delete ']/parent::button")
    public WebElement confirmDelete;

    @FindBy(xpath = "//ms-toaster-message//mat-panel-description/div")
    public WebElement resultMessage;

    public WebElement dialogInputName(){
        return findInputByTextInDialog("Name");
    }

    public WebElement dialogShortName(){
        return findInputByTextInDialog("Short Name");
    }

    private WebElement findInputByTextInDialog(String text){
        return driver.findElement(By.xpath(String.format("//ms-dialog-content//ms-text-field/input[@data-placeholder='%s']", text)));
    }

    //Assertions
    public void assertMessageDisplayed(){
        assertTextPresent(resultMessage, resultMessage.getText());
    }
}
