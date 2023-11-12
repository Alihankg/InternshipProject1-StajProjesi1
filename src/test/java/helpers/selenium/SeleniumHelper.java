package helpers.selenium;

import dataProvider.ConfigFileReader;
import managers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    private static final WebDriver driver;
    private static final WebDriverWait wait;

   static {
        driver = DriverManager.getDefaultDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigFileReader.getImplicitlyWait()));
    }

    public static void navigateTo(String url){
        driver.navigate().to(url);
    }

    public static void click(WebElement element) {
        waitUntilElementIsClickable(element);
        scrollToElement(element);
        element.click();
    }

    public static void sendKeys(WebElement element, String text) {
       waitUntilElementIsClickable(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDefaultDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    // Assertions
    public static void assertElementPresent(WebElement element) {
        Assert.assertTrue("element isn't displayed", element.isDisplayed());
    }

    public static void assertContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
    }

    // Wait
    public static void waitUntilElementDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}