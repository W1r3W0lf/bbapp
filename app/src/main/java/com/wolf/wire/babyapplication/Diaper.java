package com.wolf.wire.babyapplication;

public class Diaper {

    enum diaperType {
        pee, poop, both;

        diaperType() {
        }
    }

    // full refers to if the diaper is full or not
    private boolean full;
    private int size;

    public Diaper(int size){
        this.full = false;
        this.size = size;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
