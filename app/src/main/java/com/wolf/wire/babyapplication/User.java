package com.wolf.wire.babyapplication;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class User {



    private List<Baby> children;

    // For testing only
    public int childrenNumber = 0;

    public User(){ children = new ArrayList<Baby>(); }

    // Saves children to json string
    public String save(){
        Gson gson = new Gson();
        return gson.toJson(children);
    }

    // Load changes to User
    public void load(String babyString){
        Gson gson = new Gson();
        children = gson.fromJson(babyString, List.class);
    }
    
    public void makeBaby(String name){ children.add(new Baby(name)); }


}
