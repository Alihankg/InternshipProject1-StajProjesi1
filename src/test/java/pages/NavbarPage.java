package pages;

import drivers.Driver;
import helpers.SeleniumShortcuts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavbarPage extends SeleniumShortcuts {

    public NavbarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[class='nav-link-title ng-tns-c3380182179-6 ng-star-inserted']")
    public WebElement setup;

    @FindBy(css = "[class='nav-link-title ng-tns-c3380182179-7 ng-star-inserted']")
    public WebElement parameters;

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

    @FindBy(xpath = "//span[text()=' Delete ']/parent::button")
    public WebElement deleteConfirm;


}
