package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends HelperBase {


    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }


    public void tapOnAddButton() {
        click(By.id("add_reminder"));
    }

    public void fillReminderName(String text, int timeOut) {
        waitForElementAndType(By.id("reminder_title"), timeOut, text);
        hideKeyboard();
    }

    public void saveReminder(int timeOut) {
        waitForElementAndClick(By.xpath("//android.widget.TextView[@content-desc='Save Reminder']"), timeOut);
    }

    public void tapOnData() {
        click(By.id("date"));
    }

    public void selectDay(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnOk() {
        click(By.id("ok"));
    }


    public void selectRepeat() {
        click(By.id("repeat_switch"));
    }

    public void selectRepeatitionInterval() {
        click(By.id("RepeatNo"));
    }

    public void fillRepeatitionInterval(String text, int timeOut) {
        waitForElementAndType(By.className("android.widget.EditText"), timeOut, text);
        hideKeyboard();
    }
    public void tapOnOkRepetitionInterval() {
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"));
    }

    public void typeOfRepetition(){
        click(By.id("RepeatType"));
    }

    public void ckickDayRepetition(){
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]"));
    }
    public void clickSaveReminder(){
        click(By.id("save_reminder"));
    }
}
