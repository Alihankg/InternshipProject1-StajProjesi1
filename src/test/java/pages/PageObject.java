package pages;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObject {
    WebDriver driver;
    public PageObject() {
        driver = DriverManager.getDefaultDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
}
