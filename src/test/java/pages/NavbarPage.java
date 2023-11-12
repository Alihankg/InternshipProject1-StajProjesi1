package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import static helpers.selenium.SeleniumHelper.*;
// Under Construction
public class NavbarPage extends PageObject {

    public void navigateToPage(String text) {
        WebElement element = findFolderByText(text);
        navigateToUpperPage(element);
        click(element);
    }

    private void navigateToUpperPage(WebElement element) {
        WebElement upperFolder = getUpperFolder(element);

        while (upperFolder != null && !upperFolder.getTagName().equals("a")) {
            click(upperFolder);
            upperFolder = getUpperFolder(upperFolder);
        }
    }

    public WebElement getUpperFolder(WebElement element) {
        try {
            return element.findElement(By.xpath("/ancestor::div[1]/preceding-sibling::a"));
        } catch (NoSuchElementException ignored) {
            return null;
        }
    }

    // Helpers
    public WebElement findFolderByText(String text) {
        String xpath = String.format("//span[text()='%s']/parent::a", text);
        return driver.findElement(By.xpath(xpath));
    }
}
