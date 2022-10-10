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

    @Test
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


}
