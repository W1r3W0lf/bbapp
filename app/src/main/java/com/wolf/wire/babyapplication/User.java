package com.wolf.wire.babyapplication;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wire_wolf
 * @version 0.3
 */
public class User {

    private List<Baby> children;


    public User(){ children = new ArrayList<Baby>(); }

    /**
     * turns the user into a json string
     * @return the user json string
     */
    public String save(){
        Gson gson = new Gson();
        return gson.toJson(children);
    }

    /**
     * takes a json user string and loads it's values
     * @param babyString the user json string to load
     */
    public void load(String babyString){
        Gson gson = new Gson();
        children = gson.fromJson(babyString, List.class);
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
