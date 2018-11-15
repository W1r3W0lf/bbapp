package com.wolf.wire.babyapplication;

import com.google.gson.Gson;

public class User {


    public Baby children[];

    public User(){
    }

    // Saves children to json string
    public String save(){
        Gson gson = new Gson();
        return gson.toJson(children);
    }

    // Load changes to User
    public void load(String babyString){
        Gson gson = new Gson();
        children = gson.fromJson(babyString, Baby[].class);
    }


}
