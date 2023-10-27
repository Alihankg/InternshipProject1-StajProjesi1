package managers;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.Locale;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static final ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        threadBrowserName.set(fileReaderManager.getConfigReader().getDefaultBrowser());

        if (threadDriver.get()==null) {
            switch (threadBrowserName.get()) {
                case "firefox" -> threadDriver.set(io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().create());
                case "safari" -> threadDriver.set(io.github.bonigarcia.wdm.WebDriverManager.safaridriver().create());
                case "edge" -> threadDriver.set(io.github.bonigarcia.wdm.WebDriverManager.edgedriver().create());
                case "opera" -> threadDriver.set(io.github.bonigarcia.wdm.WebDriverManager.operadriver().create());
                case "chromium" -> threadDriver.set(io.github.bonigarcia.wdm.WebDriverManager.chromiumdriver().create());
                case "ie" -> threadDriver.set(io.github.bonigarcia.wdm.WebDriverManager.iedriver().create());
                case "chrome" -> threadDriver.set(io.github.bonigarcia.wdm.WebDriverManager.chromedriver().create());
            }
        }

        Boolean windowMaximize = fileReaderManager.getConfigReader().getBrowserWindowSize();
        if (windowMaximize)
            threadDriver.get().manage().window().maximize();

        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(fileReaderManager.getConfigReader().getImplicitlyWait()));
        return threadDriver.get();

    }

    public static void quitDriver() {
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        if (threadDriver.get()!=null) {
            threadDriver.get().quit();
            threadDriver.set(null);
        }
    }
}