package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getConfig(String dataKey) {
        String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        return prop.getProperty(dataKey);
    }
}
