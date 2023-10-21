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

    public void deleteItem(String searchText) {
        sendKeys(searchInput, searchText);
        click(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));

        click(deleteImageBtn);
        click(deleteDialogBtn);
    }
}

