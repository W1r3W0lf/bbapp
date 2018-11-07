package com.wolf.wire.babyapplication;

import java.util.ArrayList;
import java.util.List;

public class USER_class implements History{
    int number_babies = 0;
    ArrayList babies = new ArrayList();

    void createBaby(){
        String duedate = null;
        Baby baby = new Baby(duedate, number_babies);
        if (baby != null)
            number_babies++;
        babies.add(number_babies - 1, baby);

    }

    @Override
    public void save() {

    }
}
