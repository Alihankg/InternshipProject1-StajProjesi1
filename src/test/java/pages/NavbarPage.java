package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static helpers.selenium.SeleniumHelper.*;

public class NavbarPage extends PageObject {

    private static final String pageLocator = "//span[text()='%s']/parent::a",
            upperFolderLocator = "/ancestor::div[%d]/preceding-sibling::a";

    public void navigateToPage(String name){
        WebElement page = findPageByText(name);
        findAndClickUpperFolder(pageLocator.formatted(name), 1);
        click(page);
    }

    // Helpers
    private WebElement findPageByText(String text) {
        String xpath = pageLocator.formatted(text);
        return driver.findElement(By.xpath(xpath));
    }

    private void findAndClickUpperFolder(String baseXpath, int depth){
        WebElement upperFolder = driver.findElement(By.xpath(baseXpath+upperFolderLocator.formatted(depth)));
        if (!upperFolder.isDisplayed())
            findAndClickUpperFolder(baseXpath, depth + 1);
        click(upperFolder);
    }
}