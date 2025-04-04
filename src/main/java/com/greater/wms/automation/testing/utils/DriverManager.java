package com.greater.wms.automation.testing.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedHashMap;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        PropertiesReader properties = new PropertiesReader("properties.yml");
        String driverKey = ((LinkedHashMap<?, ?>)properties.getProperty("driver")).get("key").toString();
        String driverPath = ((LinkedHashMap<?, ?>)properties.getProperty("driver")).get("path").toString();

        if (driver == null) {
            System.setProperty(driverKey, driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void setup() {
    }
}