package com.telran.remindly.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MainScreenTests extends TestBase{

    @Test
    public void launchAppTest(){
        System.out.println("App launch");
        String String_1 = app.getMainScreen().isNoReminderPresent();
        assertTrue(String_1.contains("Click on the plus button below to begin creating your reminders!"));
        System.out.println("Text Detected");
        app.getMainScreen().pause(2000);
        checkLicensesTest();

    }


    public void checkLicensesTest(){
        clickMoreOptions();
        app.getMainScreen().pause(1000);
        app.getMainScreen().click(By.className("android.widget.LinearLayout"));
        String String_2 = app.getMainScreen().isLicensesPresent();
        assertTrue(String_2.contains("NOTICES FOR LIBRARIES"));
        System.out.println("Done !");
    }

    private void clickMoreOptions() {
        app.getMainScreen().click(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
    }


}
