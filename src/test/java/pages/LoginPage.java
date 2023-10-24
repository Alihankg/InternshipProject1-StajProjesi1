package pages;

import drivers.Driver;
import helpers.SeleniumShortcuts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends SeleniumShortcuts {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(css="input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css="input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(xpath="(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;

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

    public void deleteItem(String searchText) {
        sendKeys(searchInput, searchText);
        click(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));

        click(deleteImageBtn);
        click(deleteDialogBtn);
    }
}

