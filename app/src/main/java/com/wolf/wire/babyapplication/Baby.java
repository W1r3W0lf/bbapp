package com.wolf.wire.babyapplication;

public class Baby {

    private String DueDate;

    private String Name;

    enum gender {
        Male, Female
    }

    private gender gender;

    // These are public so we don't have to have a bunch of stub functions that just pass along values
    // like So baby.diaper.change() rather than baby.diaperChange()
    public Diaper diaper;

    public Feeding feeding;


    public Baby(String Name){
        this.Name = Name;

        this.diaper = new Diaper(0);
        this.feeding = new Feeding();
    }


    public String getDueDate() { return DueDate; }

    public void setDueDate(String dueDate) { DueDate = dueDate; }


    public String getName() { return Name; }

    public void setName(String name) { Name = name; }


    public Baby.gender getGender() { return gender; }

    public void setGender(Baby.gender gender) { this.gender = gender; }


}
