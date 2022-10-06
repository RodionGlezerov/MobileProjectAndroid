package com.telran.remindly.tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    AppiumDriver driver;

    DesiredCapabilities capabilities;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "qa32_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.blanyal.remindly");
        capabilities.setCapability("appActivity", "com.blanyal.remindme.MainActivity");
        capabilities.setCapability("app", "/Users/rodionglezerov/Desktop/Tools/com.blanyal.remindly_2_apps.evozi.com.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }


    //{
    //  "platformName": "Android",
    //  "appium:platformVersion": "8.0",
    //  "appium:deviceName": "qa32_mob",
    //  "appium:appPackage": "com.blanyal.remindly",
    //  "appium:appActivity": "com.blanyal.remindme.MainActivity"
    //}

}
