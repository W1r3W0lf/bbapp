package com.wolf.wire.babyapplication;

import java.time.LocalTime;
import java.util.Stack;
import java.util.Timer;

public class Feeding {

    enum feedingType{
        Breast, Bottle
    }

    private boolean needsFeeding = false;
    private Timer timer;
    private int formula_O2;
    LocalTime timeFeed;

    public Feeding() {
        timeFeed = getTimeFeed();
        formula_O2 = getFormula_O2();
    }

    public boolean isNeedsFeeding() {
        if (needsFeeding)
        {
            setTimeFeed(java.time.LocalTime.now());
            setFormula_O2(this.formula_O2);
            return needsFeeding;
        }
        else
            return needsFeeding;
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



}
