package pages;

import drivers.Driver;
import helpers.SeleniumShortcuts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavbarPage extends SeleniumShortcuts {

    public NavbarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css="[class='nav-link-title ng-tns-c3380182179-6 ng-star-inserted']")
    public WebElement setup;

    @FindBy(css="[class='nav-link-title ng-tns-c3380182179-7 ng-star-inserted']")
    public WebElement parameters;

    @FindBy(xpath="(//span[@class='nav-link-title ng-star-inserted'])[10]")
    public WebElement documentTypes;

    @FindBy(xpath="(//span[@class='mat-mdc-button-persistent-ripple mdc-icon-button__ripple'])[7]")
    public WebElement button7;

    @FindBy(id="[id='ms-text-field-2']")
    public WebElement name;

    @FindBy(xpath="[id='mat-select-8']")
    public WebElement stage;

    @FindBy(xpath="[class='ng-fa-icon ng-star-inserted']")
    public WebElement save;

    @FindBy(xpath="(//span[@class='mat-mdc-button-persistent-ripple mdc-icon-button__ripple'])[10]")
    public WebElement delete;

    @FindBy(xpath = "//span[@class='nav-link-title ng-tns-c3380182179-15 ng-star-inserted']")
    public WebElement humanResou;

    @FindBy(xpath = "//span[@class='nav-link-title ng-tns-c3380182179-16 ng-star-inserted']")
    public WebElement Setup;

    @FindBy(linkText = "Position Categories")
    public WebElement positionCate;

    @FindBy(xpath = "//a[@href='/employee-position']")
    public WebElement position;




}
