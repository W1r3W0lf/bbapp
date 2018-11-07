package com.wolf.wire.babyapplication;

public class User {

    private String Name;
    
    public User(String Name){
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
