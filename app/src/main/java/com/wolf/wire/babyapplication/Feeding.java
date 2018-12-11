package com.wolf.wire.babyapplication;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Feeding {

    enum feedingType{
        Breast, Bottle
    }

    private int formula_O2; //What type of feeding took place

    private feedingType feedingType;

    private Date feedingTime; //When a feeding takes place

    private Timer timer; //See Javadoc for setTimer for notes about this object


    /**
     * Basic Constructor sets null values for formula, feedingTime and timer.
     */
    public Feeding() {
        formula_O2 = 0;
        feedingTime = null;
        timer = null;
    }


    /**
     * Will be used on the submit of a new feeding. Sets the current time as the
     * Feeding time and uses the responses from the user to submit formula amount
     * and the feeding type that occured.
     * @param formula_O2 The amount of formula used
     * @param feedingTypeResponse The type of feeding
     */
    public void setFeeding(int formula_O2, feedingType feedingTypeResponse) {
        setFeedingTime();
        this.formula_O2 = formula_O2;
        this.feedingType = feedingTypeResponse;
    }


    /**
     * Getter for the formula type on a feeding object.
     * @return
     */
    public int getFormula_O2() {
        return formula_O2;
    }


    /**
     * Sets the feedingTime to the current time instance
     * for the feeding.
     */
    public void setFeedingTime() {
        feedingTime = Calendar.getInstance().getTime();
    }


    /**
     * Getter for the Date object feedingTime in order to getDate()
     * for reference by the User.
     * @return
     */
    public Date getFeedingTime() { return feedingTime; }


    /**
     * Still working on getting this to relate to a button..
     * I might try using an alarmManager object which will make comparison
     * and recording of a timer easier. Also it would already have the alarm
     * option for the time scheduled by user.
     * @param timer
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
