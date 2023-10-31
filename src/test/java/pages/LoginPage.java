package pages;

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

}
