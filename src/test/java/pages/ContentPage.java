package pages;

import enums.FieldType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static helpers.selenium.SeleniumHelper.*;

public class ContentPage extends PageObject {

    private static String previousText;

    @FindBy(xpath = "//ms-add-button//button")
    public WebElement add;

    @FindBy(xpath = "//mat-dialog-container")
    public WebElement dialog;

    @FindBy(xpath = "//ms-edit-button//button")
    public WebElement edit;

    @FindBy(xpath = "//ms-delete-button//button")
    public WebElement delete;

    @FindBy(xpath = "//ms-save-button[last()]//button")
    public WebElement saveButton;

    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()=' Delete ']/parent::button")
    public WebElement confirmDelete;

    @FindBy(xpath = "//ms-toaster-message//mat-panel-description/div[contains(text(), 'successfully')]")
    public WebElement toastMessage;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]/ancestor::div[@class='hot-toast-message']/following-sibling::button")
    public WebElement toastClose;

    @FindBy(xpath = "//table//div[text()=' # ']")
    public WebElement sortHashtag;

    @FindBy(xpath = "//table//tr[1]/td[2]")
    public WebElement nameAt1;

    @FindBy(xpath = "//mat-option/span")
    public List<WebElement> options;

    public void sort() {
        click(sortHashtag);
    }

    // ---- CRAD methods ----
    public void add() {
        click(add);
    }

    public void edit() {
        click(edit);
    }

    public void deleteAndConfirm() {
        click(delete);
        click(confirmDelete);
    }

    public void saveAndConfirm() {
        click(saveButton);
        assertContainsText(nameAt1, previousText);
    }

    // ---- Form ----
    public void fillDialogField(String fieldName, String value) {
        waitUntilDialogDisplayed();
        FieldType fieldType = getFieldTypeOf(fieldName);
        String xpath = fieldType.xpath.formatted(fieldName);
        if (fieldType == FieldType.TEXTAREA)
            xpath = fieldType.xpath.formatted(fieldName.substring(0, fieldName.length() - 1));
        WebElement element = driver.findElement(By.xpath(xpath));
        switch (getFieldTypeOf(fieldName)) {
            case TEXTAREA, INPUT -> sendKeys(element, value);
            case CHECKBOX -> {
                click(element);
                if (value.contains("+"))
                    Arrays.stream(value.split("\\+")).forEach(o -> matchAndClickOption(o.trim()));
                else
                    matchAndClickOption(value);
                escape();
            }
            case SELECT -> {
                click(element);
                matchAndClickOption(value);
            }
        }
        // To assert the value of the first row of the first column in the table
        if (fieldName.equals("Name") || fieldName.equals("Description"))
            previousText = value;
    }

    // Form Helpers
    private void matchAndClickOption(String selected) {
        for (WebElement o : options) {
            waitUntilElementIsDisplayedAndClickable(o);
            if (o.getText().equals(selected)) {
                click(o);
                break;
            }
        }
    }

    private FieldType getFieldTypeOf(String fieldName) {
        if (fieldName.contains(":"))
            return FieldType.TEXTAREA;
        switch (fieldName) {
            // Add needed cases as you need
            case "Field Type", "Location Type", "Currency", "Next Grade" -> {
                return FieldType.SELECT;
            }
            case "Stage" -> {
                return FieldType.CHECKBOX;
            }
            default -> {
                return FieldType.INPUT;
            }
        }
    } // Change it as needed

    // Wait
    public void waitUntilDialogDisplayed() {
        waitUntilElementIsDisplayed(dialog);
    }

    // Assertions
    public void assertMessageContainsAndClose(String text) {
        assertContainsText(toastMessage, text);
        click(toastClose);
    }

    // ---- Deprecated Methods ----

    // Form Methods
    @Deprecated
    public void select(String selectName, String selected) {
        WebElement select = driver.findElement(By.xpath("//ms-dialog-content//span[text()='%s']/ancestor::*/preceding-sibling::mat-select".formatted(selectName)));
        click(select);
        matchAndClickOption(selected);
    }

    @Deprecated
    public void fillDialogInput(String fieldName, String text) {
        //mat-label[text()='Description']/ancestor::span/preceding-sibling::*
        //ms-dialog-content//textarea[@formcontrolname='%s']
        waitUntilDialogDisplayed();
        if (fieldName.equals("Name") || fieldName.equals("Description"))
            previousText = text;
        WebElement element = driver.findElement(By.xpath("//ms-dialog-content//input[@data-placeholder='%s']".formatted(fieldName)));
        sendKeys(element, text);
    }

    // If there are more value parameters, it means it's a checkbox
    @Deprecated
    public void fillDialogField(String fieldName, String... selected) {
        WebElement select = driver.findElement(By.xpath("//ms-dialog-content//span[text()='%s']/ancestor::mat-select".formatted(fieldName)));
        select.click();
        for (String s : selected) {
            matchAndClickOption(s);
        }
        escape();
    }

    // Search
    @Deprecated
    public void searchWith(Map<String, String> inputs) {
        for (Map.Entry<String, String> input : inputs.entrySet()) {
            fillSearchInput(input.getKey(), input.getValue());
        }
        click(searchButton);
    }

    @Deprecated
    public void fillSearchInput(String inputName, String text) {
        WebElement input = driver.findElement(By.xpath(String.format("//ms-browse-search//ms-text-field/input[@data-placeholder='%s']", inputName)));
        sendKeys(input, text);
    }

    // Others
    @Deprecated
    public void clearBugToastMessages() {
        List<WebElement> bugToastCloses = driver.findElements(By.xpath("//ms-toaster-message//div[contains(text(), 'Cannot read properties')]" +
                "/ancestor::div[contains(@class, 'hot-toast-message')]/following-sibling::button"));
        if (bugToastCloses.isEmpty())
            return;
        for (WebElement closeButton : bugToastCloses) {
            click(closeButton);
        }
//        click(content);
    }
}
