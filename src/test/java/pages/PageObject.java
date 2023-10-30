package pages;

import helpers.selenium.SeleniumHelper;
import managers.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class PageObject extends SeleniumHelper {

    public PageObject() {
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), 20), this);
    }
}
