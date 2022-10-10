package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppManager {
    AppiumDriver driver;

    DesiredCapabilities capabilities;

    MainScreenHelper mainScreen;

    ReminderHelper reminder;


    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "qa32_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.blanyal.remindly");
        capabilities.setCapability("appActivity", "com.blanyal.remindme.MainActivity");
        capabilities.setCapability("app", "/Users/rodionglezerov/Desktop/Tools/com.blanyal.remindly_2_apps.evozi.com.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        mainScreen = new MainScreenHelper(driver);
        reminder = new ReminderHelper(driver);

    }

    public ReminderHelper getReminder() {
        return reminder;
    }

    public MainScreenHelper getMainScreen()  {
        return mainScreen;
    }

    public void stop() {
        driver.quit();
    }
}
