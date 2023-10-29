package pages;

import helpers.selenium.SeleniumHelper;
import managers.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class PageObject extends SeleniumHelper {

    public PageObject() {
        PageFactory.initElements(new AjaxElementLocatorFactory(WebDriverManager.getDriver(), 20), this);
    }
}
