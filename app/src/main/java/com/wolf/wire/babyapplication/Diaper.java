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

    private Date date;

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
        date = new Date();
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

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

}
