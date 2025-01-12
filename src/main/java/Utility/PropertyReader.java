package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static Properties properties;

   static {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the value of a property by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public static String getBaseUrl() {
        return getProperty("url");
    }
    public static String getBaseUrl2() {
        return getProperty("Url2");
    }
    public static String getCascadeUrl() {
        return getProperty("cascadeUrl");
    }

    public static String getbrowser() {
        return getProperty("browser");
    }

}
