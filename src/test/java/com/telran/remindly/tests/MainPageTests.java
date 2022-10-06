package com.telran.remindly.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MainPageTests extends TestBase{

    @Test
    public void launchAppTest(){
        System.out.println("App launch");
        String String_1 = driver.findElement(By.id("com.blanyal.remindly:id/no_reminder_text")).getText();
        assertTrue(String_1.contains("Click on the plus button below to begin creating your reminders!"));
        System.out.println("Text Detected");
        pause(2000);
        checkLicensesTest();

    }

    public void checkLicensesTest(){
        click(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
        pause(1000);
        click(By.className("android.widget.LinearLayout"));
        String String_2 = driver.findElement(By.id("com.blanyal.remindly:id/licenses_text_view")).getText();
        assertTrue(String_2.contains("NOTICES FOR LIBRARIES"));
        System.out.println("Done !");
    }




}
