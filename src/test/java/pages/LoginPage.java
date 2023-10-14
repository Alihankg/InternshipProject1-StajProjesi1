package pages;

import drivers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="[id='mat-input-3']")
    public WebElement username;

    @FindBy(id="[id='mat-input-4']")
    public WebElement password;

    @FindBy(linkText="GİRİŞ YAP")
    public WebElement login;
}
