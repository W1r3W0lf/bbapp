package com.wolf.wire.babyapplication;

import java.time.LocalTime;
import java.util.Stack;
import java.util.Timer;

public class Feeding implements History {

    private boolean needsFeeding = false;
    private Timer timer;
    private int formula_O2;
    private Stack<Feeding> feedingHistory;
    LocalTime timeFeed;

    public Feeding() {
        timeFeed = getTimeFeed();
        formula_O2 = getFormula_O2();
    }

    enum feedingType{
        Breast, Bottle
    }

    public void setFormula_O2(int formula_O2) {
        this.formula_O2 = formula_O2;
    }

    public int getFormula_O2() {
        return formula_O2;
    }

    public void setTimeFeed(LocalTime time) {
        timeFeed = time;
    }

    public LocalTime getTimeFeed() {
        return timeFeed;
    }

    public void setNeedsFeeding(boolean needsFeeding) {
        this.needsFeeding = needsFeeding;
    }

    public boolean isNeedsFeeding() {
        if (needsFeeding)
        {
            setTimeFeed(java.time.LocalTime.now());
            setFormula_O2(this.formula_O2);
            save();
            return needsFeeding;
        }
        else
            return needsFeeding;
    }

    @Override
    public void save() {
        feedingHistory.push(this);
    }
}
