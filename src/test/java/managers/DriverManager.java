package managers;

import dataProvider.ConfigFileReader;
import helpers.selenium.SeleniumHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Locale;

public class DriverManager {

    private static final ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    private static final ThreadLocal<String> threadBrowser = new ThreadLocal<>();

    static {
        threadBrowser.set(ConfigFileReader.getDefaultBrowser());
    }

    public static WebDriver getDefaultDriver() {
        return getDriver(threadBrowser.get());
    }

    public static void setDefaultBrowser(String browser){
        threadBrowser.set(browser);
    }

    public static WebDriver getDriver(String browser) {
        if (threadDriver.get() == null) {
            initializeDriver(browser);
        }
        return threadDriver.get();
    }

    private static void initializeDriver(String browserName){
        if(browserName == null)
            browserName = "chrome";
        WebDriver driver = WebDriverManager.getInstance(browserName).create();
        threadDriver.set(driver);
        setLocalSettings();
        setBrowserSettings();
    }

    private static void setLocalSettings(){
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        System.setProperty("user.language", "EN");
    }

    private static void setBrowserSettings(){
        boolean windowMaximize = ConfigFileReader.getBrowserWindowSize();
        if (windowMaximize)
            threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigFileReader.getImplicitlyWait()));
    }

    public static void quitDriver() {
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        if (threadDriver.get()!=null) {
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }
}