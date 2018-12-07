package com.wolf.wire.babyapplication;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Diaper {

    enum diaperType {
        pee, poop, both;

        diaperType() {
        }
    }

    // full refers to if the diaper is full or not
    private boolean full;
    private int size;

    private Date history_Diaper;
    private Date future_Diaper;
    private Timer future_timer;
    private TimerTask task;

    private diaperType filledWith;

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
     * and record the sixe of the new diaper.
     * @param size
     */
    public void change(int size){
        Date date = new Date();
        setDate(date);
        full = false;
        this.size = size;
        filledWith = null;
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
     * Will be used to set a timer by the user for a
     * future diaper change to be expected.
     */
    public void setFuture_timer() {
        future_timer.schedule(task, future_Diaper);
    }

    /**
     * Takes in the date time object the diaper was
     * changed and saves it as history.
     * @param date
     */
    public void setDate(Date date) {
        history_Diaper = date;
    }

    /**
     * Getter for the date time object saved in the
     * history of the diaper changes.
     * @return
     */
    public Date getDate() {
        return history_Diaper;
    }

    /**
     * Will be used to set a future diaper date time for
     * future diaper timer.
     * @param future_Diaper
     */
    public void setFuture_Diaper(Date future_Diaper) {
        this.future_Diaper = future_Diaper;
    }

    /**
     * Getter for the scheduled Diaper Date time object.
     * @return
     */
    public Date getFuture_Diaper() {
        return future_Diaper;
    }

    /**
     * This task is what will happen when the timer goes
     * off for a future diaper timer. Will be included in
     * stretch to include an alert for user.
     * @param task
     */
    public void setTask(TimerTask task) {
        this.task = task;
    }
}
