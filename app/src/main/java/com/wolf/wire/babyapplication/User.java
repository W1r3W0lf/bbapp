package com.wolf.wire.babyapplication;

import android.util.Pair;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 * @author wire_wolf
 * @version 0.3
 */
public class User {

    private List<Baby> children;

    User(){ children = new ArrayList<>(); }

    /**
     * turns the user into a json string
     * @return the user json string
     */
    String save(){
        Gson gson = new Gson();
        return gson.toJson(children);
    }

    /**
     * takes a json user string and loads it's values
     * @param babyString the user json string to load
     */
    void load(String babyString){
        Gson gson = new Gson();
        children = gson.fromJson(babyString, List.class);
    }



    public List<Event> getEvents(){

        List<Event> events = new ArrayList<>();

        ListIterator<Baby> childrenIterator = (ListIterator<Baby>) children.iterator();
        Baby child;

        while (childrenIterator.hasNext()){
            child = childrenIterator.next();
            // diaper and feeding should diaper should have the same getDate method
            events.add(new Event(child.getName(), child.feeding.getFeedingTime(), Event.eventType.Feeding));
            events.add(new Event(child.getName(), child.diaper.getDate(), Event.eventType.Diaper));
        }

        Collections.sort(events, new Comparator<Event>(){
            public int compare (Event e1, Event e2){
                return e1.getEvenetDate().compareTo(e2.getEvenetDate());
            }
        });


        //populate list
        // Jonny Feeding Date
        List<Event> next_events = new ArrayList<>();

        for (int x = 0; x < 3 ; x++){
            next_events.add(events.get(x));
        }

        return next_events;
    }

    /**
     * adds a new baby to the user's children
     * @param name name of the child
     * @param gender gender of the child
     * @param diaper the size of the diaper of the child
     */
    public void makeBaby(String name, Baby.gender gender, int diaper){ children.add(new Baby(name, gender, diaper)); }

    /**
     * adds a new baby that has not been born yet to the user children
     * @param name name of the baby
     * @param DueDate the due date of the baby
     */
    public void makeBaby(String name, String DueDate){children.add(new Baby(name, DueDate));}


}
