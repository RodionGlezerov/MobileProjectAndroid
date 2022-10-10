package com.telran.remindly.tests;

import com.telran.fw.AppManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {

    protected static AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
    }

    /*public void click(By locator) {
        app.driver.findElement(locator).click();
    }*/

//    public void pause(int i) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }



    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }


    //{
    //  "platformName": "Android",
    //  "appium:platformVersion": "8.0",
    //  "appium:deviceName": "qa32_mob",
    //  "appium:appPackage": "com.blanyal.remindly",
    //  "appium:appActivity": "com.blanyal.remindme.MainActivity"
    //}

}
