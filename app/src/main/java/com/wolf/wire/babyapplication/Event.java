package com.wolf.wire.babyapplication;

import java.util.Date;

public class Event {

    enum eventType{
        Diaper, Feeding
    }

    private String babyName;
    private Date evenetDate;
    private eventType myType;


    Event(String babyName, Date evenetDate, eventType myType){
        this.babyName = babyName;
        this.evenetDate = evenetDate;
        this.myType = myType;
    }

    public String getString(){
        StringBuilder message = new StringBuilder(babyName);
        message.append(" needs");
        if (myType == eventType.Diaper){
            message.append(" Diaper ");
        } else {
            message.append(" Feeding ");
        }
        message.append(evenetDate.toString());
        return message.toString();
    }


    public Date getEvenetDate() {
        return evenetDate;
    }

    public void setEvenetDate(Date evnetDate) {
        this.evenetDate = evnetDate;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public eventType getMyType() {
        return myType;
    }

    public void setMyType(eventType myType) {
        this.myType = myType;
    }

}
