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

    public Diaper(int size){
        full = false;
        this.size = size;
        filledWith = null;
    }

    public void change(int size){
        Date date = new Date();
        setDate(date);
        full = false;
        this.size = size;
        filledWith = null;
    }

    public diaperType getFilledWith() { return filledWith; }

    public void setFilledWith(diaperType filledWith) {
        full = true;
        this.filledWith = filledWith;
    }


    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public void setFuture_timer() {
        future_timer.schedule(task, future_Diaper);
    }

    public void setDate(Date date) {
        history_Diaper = date;
    }

    public Date getDate() {
        return history_Diaper;
    }

    public void setFuture_Diaper(Date future_Diaper) {
        this.future_Diaper = future_Diaper;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }
}
