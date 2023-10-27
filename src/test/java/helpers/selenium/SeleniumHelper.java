package helpers.selenium;

import managers.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumHelper {

    public WebDriverWait wait=new WebDriverWait(WebDriverManager.getDriver(), Duration.ofSeconds(20));
    private static final WebDriver driver = WebDriverManager.getDriver();

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) WebDriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    // Assertions
    public void assertTextPresent(WebElement element, String value){
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
    }

    public static void assertElementPresent(WebElement element, String message) {
        Assert.assertTrue(element.isDisplayed(), message);
    }

    public static void assertElementNotPresent(WebElement element, String message) {
        Assert.assertFalse(element.isDisplayed(), message);
    }
}