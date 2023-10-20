package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;

public class Driver{

    private static final ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get()==null)
            threadBrowserName.set("chrome");

        if (threadDriver.get()==null) {
            switch (threadBrowserName.get()) {
                case "firefox" -> threadDriver.set(new FirefoxDriver());
                case "safari" -> threadDriver.set(new SafariDriver());
                case "edge" -> threadDriver.set(new EdgeDriver());
                default -> threadDriver.set(new ChromeDriver());
            }
        }

        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return threadDriver.get();
    }

    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get()!=null) {
            threadDriver.get().quit();
            threadDriver.set(null);
        }
    }
}