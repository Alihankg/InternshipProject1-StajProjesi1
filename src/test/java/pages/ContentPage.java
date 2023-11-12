package pages;

import static helpers.selenium.SeleniumHelper.*;

import helpers.StringHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
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

    @FindBy(xpath = "//table//div[text()=' # ']")
    public WebElement sortHashtag;

    @FindBy(xpath = "//table//tr[1]/td[2]")
    public WebElement nameAt1;

    @FindBy(xpath = "//mat-option/span")
    public List<WebElement> options;

    public void sort(){
        click(sortHashtag);
    }

    // CRAD methods
    public void add() {
        click(add);
    }

    public void edit(){
        click(edit);
    }

    public void deleteAndConfirm(){
        click(delete);
        click(confirmDelete);
    }

    public void saveAndConfirm(){
        click(saveButton);
        assertContainsText(nameAt1, previousText);
    }

    // Form
    private WebElement getSelectField(String name){
        return driver.findElement(By.xpath("//ms-dialog-content//span[text()='%s']/ancestor::mat-select".formatted(name)));
    }

    public void select(String selectName, String... selected){
        WebElement select = getSelectField(selectName);
        click(select);
        for (String s: selected){
            for (WebElement o: options){
                waitUntilElementIsDisplayedAndClickable(o);
                if (o.getText().equals(s)) {
                    click(o);
                    break;
                }
            }
        }
        escape();
    }

    public void fillDialogField(String fieldName, String text){
        WebElement element = null;
        switch (fieldName){
            case "Name", "Short Name", "Code" -> {
                element = driver.findElement(By.xpath("//ms-dialog-content//ms-text-field/input[@data-placeholder='%s']".formatted(fieldName)));
                previousText = text;
            }
            case "Description" -> {
                element = driver.findElement(By.xpath("//ms-dialog-content//textarea[@formcontrolname='%s']".formatted(StringHelper.textToCamelCase(fieldName))));
            }
        }
        sendKeys(element, text);
    }

    // Search
    public void searchWith(Map<String, String> inputs){
        for (Map.Entry<String, String> input : inputs.entrySet()){
            fillSearchInput(input.getKey(), input.getValue());
        }
        click(searchButton);
    }

    private void fillSearchInput(String inputName, String text){
        WebElement input = driver.findElement(By.xpath(String.format("//ms-browse-search//ms-text-field/input[@data-placeholder='%s']", inputName)));
        sendKeys(input, text);
    }

    // Wait
    public void waitUntilDialogDisplayed(){
        waitUntilElementIsDisplayed(dialog);
    }

    // Assertions
    public void assertMessageDisplayedAndClose(String text){
        assertContainsText(toastMessage, text);
        click(toastClose);
    }
}
