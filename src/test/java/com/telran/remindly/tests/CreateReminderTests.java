package com.telran.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase{

    @Test(enabled = false)
    public void addReminderWithDefaultDataTest(){
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
        app.getReminder().tapOnAddButton();
        app.getReminder().fillReminderName("Test",20);
        app.getReminder().saveReminder(20);
        app.getReminder().pause(4000);
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd +1);
    }

    @Test (enabled = false)
    public void addReminderWithRandomSwipeTest(){

        app.getReminder().tapOnAddButton();
        app.getReminder().fillReminderName("Test",20);
        app.getReminder().pause(3000);
        app.getReminder().tapOnData();
        app.getReminder().pause(1000);
        app.getReminder().swipeUp();
        app.getReminder().selectDay(9);
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder(20);
        app.getReminder().pause(4000);
    }

    @Test
    public void addReminderWithRandomSwipeTestRepeat(){
        app.getReminder().tapOnAddButton();
        app.getReminder().fillReminderName("Test",20);
        app.getReminder().pause(3000);
        app.getReminder().selectRepeat();
        app.getReminder().selectRepeatitionInterval();
        app.getReminder().pause(1000);
        app.getReminder().fillRepeatitionInterval("2",20);
        app.getReminder().pause(2000);
        app.getReminder().tapOnOkRepetitionInterval();
        app.getReminder().swipeUp();
        app.getReminder().typeOfRepetition();
        app.getReminder().ckickDayRepetition();
        app.getReminder().clickSaveReminder();


    }


}
