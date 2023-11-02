package pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(css="input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css="input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css="span[_ngcontent-ng-c1814038856]")
    public WebElement dashboardText;

    public void navigateToLoginPage(){
        navigateTo(ConfigFileReader.getApplicationURL());
    }

    public void enterUsername(){
        sendKeys(this.username, ConfigFileReader.getAdminUsername());
    }

    public void enterPassword(){
        sendKeys(this.password, ConfigFileReader.getAdminPassword());
    }

    public void clickLoginButton(){
        click(this.loginButton);
    }

    public void assertLogin(){
        assertElementPresent(dashboardText, "Login failed.");
    }



    @FindBy(id = "[id='mat-input-11']")
    public WebElement KullaniciAdi;

    @FindBy(id = "[id='mat-input-12']")
    public WebElement Parola;

    @FindBy(linkText = " GİRİŞ YAP ")
    public WebElement GirisYap;
}
