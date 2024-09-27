package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static AndroidDriver driver;

    public static void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
        capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
        capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
        capabilities.setCapability("app", ConfigReader.getConfigValue("app.path"));
        capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
        capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
//        capabilities.setCapability("orientation","LANDSCAPE");
//        capabilities.setCapability("autoGrandException","true");
        capabilities.setCapability("gps","true");

//        driver = new AndroidDriver(capabilities);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.lockDevice();
//        driver.unlockDevice();
//        driver.setLocation(new Location(15.390971,73.878052,100));
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
