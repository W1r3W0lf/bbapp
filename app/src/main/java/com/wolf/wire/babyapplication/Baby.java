package com.wolf.wire.babyapplication;

/**
 * @author wire_wolf
 * @version 0.3
 */
public class Baby {

    private String DueDate;

    private String Name;

    enum gender {
        Male, Female
    }

    private gender gender;


    public Diaper diaper;

    public Feeding feeding;


    /**
     * Makes a baby with the name with the String name
     * @param Name the name of the baby
     */
    public Baby(String Name){
        this.Name = Name;

        this.diaper = new Diaper(0);
        this.feeding = new Feeding();
    }

    /**
     * @return the due date of the baby
     */
    public String getDueDate() { return DueDate; }

    /**
     * @param dueDate the new due date of the baby
     */
    public void setDueDate(String dueDate) { DueDate = dueDate; }


    /**
     * @return the name of the baby
     */
    public String getName() { return Name; }

    /**
     * @param name the new name of the baby
     */
    public void setName(String name) { Name = name; }

    /**
     * @return the gender of the baby
     */
    public Baby.gender getGender() { return gender; }

    /**
     * @param gender the new gender of the baby
     */
    public void setGender(Baby.gender gender) { this.gender = gender; }


}
