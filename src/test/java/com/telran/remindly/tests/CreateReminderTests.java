package com.telran.remindly.tests;

import com.telran.model.Reminder;
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

    @Test (enabled = false)
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

    @Test (enabled = false)
    public void addReminderWithRandomSwipeTestNew(){
        app.getReminder().tapOnAddButton();
        app.getReminder().fillReminderName("Test",20);
        app.getReminder().tapOnData();
        app.getReminder().pause(2000);
        app.getReminder().selectMonth("DEC",2,"future");
        app.getReminder().selectDay(23);
        app.getReminder().tapOnYear();
        app.getReminder().pause(1000);
        app.getReminder().selectYear("2024","future");
        app.getReminder().tapOnOk();
        app.getReminder().tapOnTime();
        app.getReminder().chooseTimeOfDay("PM");
        app.getReminder().pressOnTimer(535,1194);
        app.getReminder().pressOnTimer(771,786);
        app.getReminder().tapOnOk();
        app.getReminder().selectRepeat();
//        app.getReminder().fillRepeatitionInterval("2",20);
//        app.getReminder().swipeUp();
//        app.getReminder().selectRepeatTime("Month");

        app.getReminder().clickSaveReminder();

//        Assert.assertTrue(app.getReminder().isTitlePresent().contains());

    }

    @Test
    public void addReminderRegressionTest(){
        app.getReminder().enterAllData(new Reminder().setText("Test").setTimeOut(20).setMillis(2000).setMonth("DEC").setNumber(2).setType("future").setDay(23).setYear("2024").setType1("future").setTd("PM").setX(535).setY(1194).setX(771).setY(786));
//        Assert.assertTrue(app.getReminder().isTitlePresent().contains("Test"));
    }


}
