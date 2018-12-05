package com.wolf.wire.babyapplication;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Diaper {

    // Full refers to if the diaper is full or not
    private boolean full;

    private int size;

    enum diaperType {
        pee, poop, both;

        diaperType() {
        }
    }

    private Date diaper_ChangeTime;

    private diaperType filledWith;



    // Separated these three as we may replace it with one object for a timer
    private Date scheduled_DiaperTimer;
    private Timer set_Timer;
    private TimerTask resultant_Task;
    // Alarm Manager object might be more efficient



    /**
     * Takes in a size of the diaper and sets the
     * size for the Baby it belongs to.
     * @param size
     */
    public Diaper(int size){
        full = false;
        this.size = size;
        filledWith = null;
    }


    /**
     * Will record the date time in which the diaper is full
     * and record the size of the new diaper.
     * @param size
     */
    public void change(int size) {
        if (isFull()) {
            setDate();
            this.size = size;

            full = false;

            if (filledWith != null)
                filledWith = null;
        }
    }


    /**
     * Returns what the diaper was filledwith.
     * @return
     */
    public diaperType getFilledWith() { return filledWith; }


    /**
     * The setter for what the diaper is filledwith
     * from enum diapertype.
     * @param filledWith
     */
    public void setFilledWith(diaperType filledWith) {
        full = true;
        this.filledWith = filledWith;
    }


    /**
     * Getter for the boolean full if the diaper is full
     * or not.
     * @return
     */
    public boolean isFull() {
        return full;
    }


    /**
     * Sets the boolean full on whether the diaper is
     * full or not.
     * @param full
     */
    public void setFull(boolean full) {
        this.full = full;
    }


    /**
     * Getter for the size of the diaper
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the diaper to the passed size object
     * from the User
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Sets the dateTime object to the current time of the change.
     */
    public void setDate() {
        diaper_ChangeTime = Calendar.getInstance().getTime();
    }


    /**
     * Getter for the date time object saved in the
     * history of the diaper changes.
     * @return
     */
    public Date getDate() {
        return diaper_ChangeTime;
    }


    /**
     * Will be used to set a future diaper date time for
     * future diaper timer.
     * @param user_Preference
     */
    public void setScheduled_DiaperTimer(Date user_Preference) {
        this.scheduled_DiaperTimer = user_Preference;
    }


    /**
     * Getter for the scheduled Diaper Date time object.
     * @return
     */
    public Date getScheduled_DiaperTimer() {
        return scheduled_DiaperTimer;
    }


    /**
     * Will be used to set a timer by the user for a
     * future diaper change to be expected.
     */
    public void setFuture_timer() {
        set_Timer.schedule(resultant_Task, scheduled_DiaperTimer);
    }


    /**
     * This resultant_Task is what will happen when the timer goes
     * off for a future diaper timer. Will be included in
     * stretch to include an alert for user.
     * @param resultant_Task
     */
    public void setResultant_Task(TimerTask resultant_Task) {
        this.resultant_Task = resultant_Task;
    }
}
