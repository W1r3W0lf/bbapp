package com.wolf.wire.babyapplication;

public class Diaper implements History {

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


}
