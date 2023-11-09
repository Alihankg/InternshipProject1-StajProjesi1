package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarPage extends PageObject {

    public WebElement parameters;
    public WebElement schoolsetup;
    public WebElement departments;
    public WebElement humanResources;
    public WebElement hrSetup;
    public WebElement positionCategories;
    public WebElement attestations;

    public NavbarPage() {
        parameters = findFolderByText("Parameters");
        schoolsetup = findFolderByText("School Setup");
        departments = findFolderByText("Departments");
        humanResources = findFolderByText("Human Resources");
        hrSetup = findSetupUnderFolder("Human Resources");
        positionCategories = findFolderByText("Position Categories");
        attestations = findFolderByText("Attestations");
    }

    @FindBy(css = "[class='nav-link-title ng-tns-c3380182179-6 ng-star-inserted']")
    public WebElement setup;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    public WebElement code;

    @FindBy(xpath = "(//span[@class='nav-link-title ng-star-inserted'])[10]")
    public WebElement documentTypes;

    @FindBy(css = "[class='mat-badge mdc-icon-button mat-mdc-icon-button mat-badge-accent mat-unthemed mat-mdc-button-base mat-badge-below mat-badge-after mat-badge-small mat-badge-hidden ng-star-inserted']")
    public WebElement button7;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement name;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[3]")
    public WebElement stage;

    @FindBy(xpath = "(//mat-option[@role='option'])[1]")
    public WebElement button;

    @FindBy(css = "[class='ng-fa-icon ng-star-inserted']")
    public WebElement save;

    @FindBy(xpath = "(//div//ms-edit-button[@table='true'])[1]")
    public WebElement edit;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[13]")
    public WebElement delete;

    @FindBy(xpath = "(//ms-delete-button[@class='ng-star-inserted'])")
    public WebElement deletes;

    @FindBy(xpath = "//span[text()=' Delete ']/parent::button")
    public WebElement deleteConfirm;

    @FindBy(id = "[id='ms-table-1_id']")
    public WebElement table;

    // Helpers
    public WebElement findFolderByText(String text){
        String xpath = getFolderXpath(text);
        return driver.findElement(By.xpath(xpath));
    }

    public String getFolderXpath(String folder){
        return String.format("//span[text()='%s']/parent::a", folder);
    }

    public WebElement findSetupUnderFolder(String text){
        return driver.findElement(By.xpath(getFolderXpath(text)+"/following-sibling::div//span[text()='Setup']/parent::a"));
    }
}
