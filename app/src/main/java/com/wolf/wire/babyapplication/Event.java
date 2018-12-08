package com.wolf.wire.babyapplication;

import java.util.Date;


/**
 * @author wire_wolf
 * @version 0.5
 */
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

    /**
     * makes a string of the items in the Event
     * @return message
     */
    public String getString(){
        StringBuilder message = new StringBuilder(babyName);
        message.append(" needs");
        if (myType == eventType.Diaper){
            message.append(" diaper changing ");
        } else {
            message.append(" feeding ");
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
