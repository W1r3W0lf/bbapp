package com.wolf.wire.babyapplication;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Feeding {

    enum feedingType{
        Breast, Bottle
    }

    private int formula_O2; //What type of feeding took place

    private Date feedingTime; //When a feeding takes place


    /**
     * Basic Constructor sets null values.
     */
    public Feeding() {
        formula_O2 = 0;
        feedingTime = new Date();
    }

    /**
     * Calls the setter for feedingTime when button submit is
     * pressed for a current feeding.
     */
    public void needsFeeding() {
            setFeedingTime();
        }

    /**
     * Correlates to the formula value from the seekbar in the
     * feeding registration from user.
     * @param formula_O2
     */
    public void setFormula_O2(int formula_O2) {
        this.formula_O2 = formula_O2;
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

    public Date getDate() {return feedingTime;}
    public void setDate(Date date) {feedingTime = date;}

}
