package pages;

import drivers.Driver;
import helpers.SeleniumShortcuts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SeleniumShortcuts {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Kullanıcı Adı']")
    public WebElement username;

    @FindBy(xpath="//input[@placeholder='Parola']")
    public WebElement password;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    public WebElement login;

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;

    @FindBy(xpath="//ms-save-button/button")
    public WebElement saveButton;

    @FindBy(css="span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement txtTechnoStudy;

    @FindBy(xpath="//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath="//input[@id='ms-text-field-0']")
    public WebElement searchBtn;

    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchPicBtn;

    @FindBy(xpath="(//ms-delete-button//button)[1]")
    public WebElement deletePicBtn;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement deleteBtn;


}
