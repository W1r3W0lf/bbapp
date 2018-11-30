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
     * This is more for the kick counter goal
     * @param Name the name of the baby
     */
    public Baby(String Name, String DueDate){
        this.Name = Name;
        this.DueDate = DueDate;

        this.diaper = new Diaper(0);
        this.feeding = new Feeding();
    }

    /**
     * Makes a new baby with a Name, Gender, and diaper
     * @param Name name of the new baby
     * @param Gender gender of the new baby
     * @param diaper the diaper size of the new baby
     */
    public Baby(String Name, gender Gender, int diaper){
        this.Name = Name;
        this.gender = Gender;

        this.diaper = new Diaper(diaper);
        this.feeding = new Feeding();
    }

    /**
     * For kick counter
     * @return the due date of the baby
     */
    public String getDueDate() { return DueDate; }

    /**
     * For kick counter
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
