package pages;

import static helpers.selenium.SeleniumHelper.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ContentPage extends PageObject{

    private static String previousText;

    @FindBy(xpath = "//ms-add-button//button")
    public WebElement add;

    @FindBy(xpath = "//mat-dialog-container")
    public WebElement dialog;

    @FindBy(xpath = "//ms-edit-button//button")
    public WebElement edit;

    @FindBy(xpath = "//ms-delete-button//button")
    public WebElement delete;

    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;

    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()=' Delete ']/parent::button")
    public WebElement confirmDelete;

    @FindBy(xpath = "//ms-toaster-message//mat-panel-description/div")
    public WebElement toastMessage;

    @FindBy(xpath = "//button[contains(@class, 'hot-toast-close-btn')]")
    public WebElement toastClose;

    @FindBy(xpath = "//table//tr[1]/td[2]")
    public WebElement nameAt1;

    // CRAD methods
    public void add() {
        click(add);
    }
    public void edit(){
        click(edit);
    }
    // Optional
    public void searchWith(Map<String, String> inputs){
        for (Map.Entry<String, String> input : inputs.entrySet()){
            fillSearchInput(input.getKey(), input.getValue());
        }
        click(searchButton);
    }
    public void deleteAndConfirm(){
        click(delete);
        click(confirmDelete);
    }
    public void saveAndConfirm(){
        click(saveButton);
        assertContainsText(nameAt1, previousText);
    }

    private void fillSearchInput(String inputName, String text){
        WebElement input = driver.findElement(By.xpath(String.format("//ms-browse-search//ms-text-field/input[@data-placeholder='%s']", inputName)));
        sendKeys(input, text);
    }

    public void fillInput(String inputName, String text){
        WebElement input = driver.findElement(By.xpath(String.format("//ms-dialog-content//ms-text-field/input[@data-placeholder='%s']", inputName)));
        sendKeys(input, text);
        previousText = text;
    }

    @Deprecated
    public void waitUntilDialogDisplayed(){
        waitUntilElementDisplayed(dialog);
    }

    //Assertions
    public void assertMessageDisplayedAndClose(String text){
        assertContainsText(toastMessage, text);
        click(toastClose);
    }
}
