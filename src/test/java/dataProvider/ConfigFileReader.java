package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private static final String PROPERTY_FILE = "src/test/java/configs/Configuration.properties";
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream(new File(PROPERTY_FILE))) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading Configuration.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null && !value.isEmpty()) {
            return value;
        } else {
            throw new RuntimeException(key + " not specified in the Configuration.properties file.");
        }
    }

    public static long getImplicitlyWait() {
        return Long.parseLong(getProperty("implicitlyWait"));
    }

    public static String getApplicationURL() {
        return getProperty("url");
    }

    public static String getAdminUsername() {
        return getProperty("adminUsername");
    }

    public static String getAdminPassword() {
        return getProperty("adminPassword");
    }

    public static String getDefaultBrowser() {
        return getProperty("defaultBrowser");
    }

    public static boolean getBrowserWindowSize() {
        return Boolean.parseBoolean(getProperty("windowMaximize"));
    }
}
