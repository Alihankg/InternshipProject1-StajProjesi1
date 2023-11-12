package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static helpers.selenium.SeleniumHelper.*;
// Under Construction
public class NavbarPage extends PageObject {

    private final String pageLocator;
    private final String upperFolderLocator;

    public NavbarPage() {
        this.pageLocator = "//span[text()='%s']/parent::a";
        this.upperFolderLocator = "/ancestor::div[%d]/preceding-sibling::a";
    }

    public void navigateToPage(String name){
        WebElement page = findPageByText(name);
        findAndClickUpperFolder(page, pageLocator.formatted(name), 1);
        click(page);
    }

    // Helpers
    private WebElement findPageByText(String text) {
        String xpath = String.format(pageLocator, text);
        return driver.findElement(By.xpath(xpath));
    }

    private void findAndClickUpperFolder(WebElement element, String baseXpath, int depth){
        WebElement upperFolder = element.findElement(By.xpath(String.format(baseXpath+upperFolderLocator, depth)));
        if (upperFolder.isDisplayed()) {
            click(upperFolder);
        }
        else {
            findAndClickUpperFolder(upperFolder, baseXpath, depth + 1);
            click(upperFolder);
        }
    }
}
