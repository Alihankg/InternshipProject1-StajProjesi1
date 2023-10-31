package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DefaultPage extends PageObject {

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;

    @FindBy(xpath="(//*[@data-placeholder='Short Name'])[2]")
    public WebElement shrtName;

    @FindBy(xpath="//ms-save-button/button")
    public WebElement saveButton;

    @FindBy(xpath="//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath="//input[@id='ms-text-field-0']")
    public WebElement searchBtn;

    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchPicBtn;

    @FindBy(xpath="//ms-delete-button//button")
    public WebElement deletePicBtn;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement deleteBtn;

    @FindBy(xpath="//button[@class='mat-mdc-tooltip-trigger mdc-icon-button mat-mdc-icon-button mat-accent mat-mdc-button-base ng-star-inserted']")
    public WebElement editPicBtn;

    @FindBy(xpath = "(//div[@class='mdc-switch__icons ng-star-inserted'])[2]")
    public WebElement swtchActivty;


    @FindBy(xpath="//mat-form-field//input[@data-placeholder='Name']")
    public WebElement searchInput;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement deleteDialogBtn;
    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(linkText = "Human Resources")
    public WebElement HumanResources;

    @FindBy(css = "[class='nav-link-title ng-tns-c2089661534-16 ng-star-inserted']")
    public WebElement HumanSetup;

    @FindBy(css = "[class='nav-link ng-star-inserted active accent']")
    public WebElement Attestations;

    @FindBy(xpath = "(//span[@class='mat-ripple mat-mdc-button-ripple'])[6]")
    public WebElement toAdd;

    @FindBy(css = "[formcontrolname='name']")
    public WebElement AddName;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-persistent-ripple mdc-button__ripple'])[4]")
    public WebElement AddSave;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[12]")
    public WebElement editDocumentation;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[12]")
    public WebElement KDelete;

    @FindBy(xpath="(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;

    public void deleteItem(String searchText) {
        sendKeys(searchInput, searchText);
        click(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));

        click(deleteImageBtn);
        click(deleteDialogBtn);
    }
}
