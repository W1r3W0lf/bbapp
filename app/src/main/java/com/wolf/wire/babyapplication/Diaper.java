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

    private diaperType filledWith;

    public Diaper(int size){
        full = false;
        this.size = size;
        filledWith = null;
    }

    public void change(int size){
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


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
