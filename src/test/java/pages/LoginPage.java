package pages;

import drivers.Driver;
import helpers.SeleniumHelper;
import org.openqa.selenium.By;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends SeleniumHelper {

    public LoginPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getDriver(), 20), this);
    }

    @FindBy(css="input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css="input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css="span[_ngcontent-ng-c1814038856]")
    public WebElement dashboardText;

    @FindBy(css="span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement txtTechnoStudy;

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

    public void enterUsername(String username){
        sendKeys(this.username, username);
    }

    public void enterPassword(String password){
        sendKeys(this.password, password);
    }

    public void clickLoginButton(){
        click(this.loginButton);
    }

    public void assertLogin(){
        assertElementPresent(dashboardText, "Login failed.");
    }
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

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[12]")
    public WebElement editDocumentation;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[12]")
    public WebElement KDelete;

    public void deleteItem(String searchText) {
        sendKeys(searchInput, searchText);
        click(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));

        click(deleteImageBtn);
        click(deleteDialogBtn);
    }
}
