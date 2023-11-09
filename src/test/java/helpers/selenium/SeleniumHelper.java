package helpers.selenium;

import dataProvider.ConfigFileReader;
import managers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    protected final WebDriver driver;
    public final WebDriverWait wait;

    public SeleniumHelper() {
        this.driver = DriverManager.getDefaultDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigFileReader.getImplicitlyWait()));
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDefaultDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    // Assertions
    public void assertTextPresent(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void assertElementPresent(WebElement element) {
        Assert.assertTrue("element isn't displayed", element.isDisplayed());
    }

    public void threadWait(int second) {
        try {
            wait.wait(second*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}