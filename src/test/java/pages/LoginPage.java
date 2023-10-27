package pages;

import managers.WebDriverManager;
import helpers.selenium.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends SeleniumHelper {

    public LoginPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(WebDriverManager.getDriver(), 20), this);
    }

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
