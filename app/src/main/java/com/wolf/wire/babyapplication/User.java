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

    // For testing only
    public int childrenNumber = 0;

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
    
    public void makeBaby(String name){ children.add(new Baby(name)); }


}
