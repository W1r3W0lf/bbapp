package com.wolf.wire.babyapplication;

public class Diaper {
    public Diaper(boolean change, int size) {
        this.change = change;
        this.size = size;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private boolean change;
    private int size;

    enum diaperType {
        pee, poop, both;

        diaperType() {
        }
    }
}
