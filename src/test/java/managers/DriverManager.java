package managers;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Locale;

public class DriverManager {

    private static final ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    private static final FileReaderManager fileReaderManager = new FileReaderManager();

    public static WebDriver getDriver() {
        return getDriver(fileReaderManager.getConfigReader().getDefaultBrowser());
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
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");
    }

    private static void setBrowserSettings(){
        boolean windowMaximize = fileReaderManager.getConfigReader().getBrowserWindowSize();
        if (windowMaximize)
            threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(fileReaderManager.getConfigReader().getImplicitlyWait()));
    }

    public static void quitDriver() {
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        if (threadDriver.get()!=null) {
            threadDriver.get().quit();
            threadDriver.set(null);
        }
    }
}