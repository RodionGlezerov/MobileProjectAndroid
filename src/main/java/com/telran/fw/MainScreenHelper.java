package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainScreenHelper extends HelperBase {
    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public String isNoReminderPresent() {
        return driver.findElement(By.id("com.blanyal.remindly:id/no_reminder_text")).getText();
    }

    public String isLicensesPresent() {
        return driver.findElement(By.id("com.blanyal.remindly:id/licenses_text_view")).getText();
    }


    public int getTotalReminders() {
        List<WebElement> id = driver.findElements(By.id("thumbnail_image"));
        int idCount = id.size();
        System.out.println("Total reminder quantity: " + idCount);
        return idCount;
    }
}
