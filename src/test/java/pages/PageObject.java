package pages;

import helpers.selenium.SeleniumHelper;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObject extends SeleniumHelper {

    public PageObject() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
}
