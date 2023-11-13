package pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static helpers.selenium.SeleniumHelper.*;

public class LoginPage extends PageObject {

    @FindBy(css="input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css="input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(xpath="//span[text()=' Dashboard ']")
    public WebElement dashboardText;

    public void navigateToLoginPage(){
        navigateTo(ConfigFileReader.getApplicationURL());
    }

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
        assertElementPresent(dashboardText);
    }
}