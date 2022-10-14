package com.telran.fw;

import com.telran.model.Reminder;
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

    public void selectMonth(String month, int number, String type) {
        if (!selectedMonth(month, number, type).equals(month)){
            for (int i = 0; i < number; i++){
                if (type.equals("future")){
                    swipeUp();
                } else if (type.equals("past")) {
                    swipeDown();
                }
            }
        }
    }

    private String selectedMonth(String month, int number, String type){
        return driver.findElement(By.id("date_picker_month")).getText();
    }

    public void tapOnYear() {
        click(By.id("date_picker_year"));
    }

    public void selectYear(String year,String type) {
       if (!selectedYear().equals(year)){
           if (type.equals("future")){
               swipeUpUntilNeededYear(year);
           } else if (type.equals("past")) {
               swipeDownUntilNeededYear(year);
           }
       }
       click(By.id("month_text_view"));
    }

    private void swipeDownUntilNeededYear(String year) {
        while (!selectedYear().equals(year)){
            moveDown(By.className("android.widget.ListView"));
            selectedYear();
        }
    }

    private void swipeUpUntilNeededYear(String year) {
        while (!selectedYear().equals(year)){
            moveUp(By.className("android.widget.ListView"));
            selectedYear();
        }
    }

    private String selectedYear() {
        return driver.findElement(By.id("month_text_view")).getText();
    }

    public void tapOnTime() {
        click(By.id("time"));
        pause(1000);
    }

    public void chooseTimeOfDay(String td) {
        if (td.equals("AM")){
            pressOnTimer(272,1324);
        } else if (td.equals("PM")) {
            pressOnTimer(795,1324);

        }
    }

    public void enterAllData(Reminder reminder) {
        tapOnAddButton();
        fillReminderName(reminder.getText(), reminder.getTimeOut());
        tapOnData();
        pause(reminder.getMillis());
        selectMonth(reminder.getMonth(), reminder.getNumber(), reminder.getType());
        selectDay(reminder.getDay());
        tapOnYear();
        selectYear(reminder.getYear(), reminder.getType1());
        tapOnOk();
        tapOnTime();
        chooseTimeOfDay(reminder.getTd());
        pressOnTimer(reminder.getX(), reminder.getY());
        pressOnTimer(reminder.getX(), reminder.getY());
        tapOnOk();
        selectRepeat();
        clickSaveReminder();

    }
}
