package com.wolf.wire.babyapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
<<<<<<< HEAD
=======
import android.widget.TextView;
>>>>>>> aa3717581f1f7c690e8d0a15e60a263843f944f6

public class MainActivity extends AppCompatActivity {

    private User user;

    /**
     *
     // Overlay declaration variables
     */
    private long animationDuration = 1000;
    private ConstraintLayout viewBaby = null;
    private ConstraintLayout viewDiaper = null;
    private ConstraintLayout viewFeeding = null;
    private ConstraintLayout viewNewBaby = null;


    public static final String MyPrefs = "MyPrefs";
    public static final String UserName = "UserName";

    SharedPreferences sharedPreferences;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* find the overlay  for baby, feeding, and diaper*/
        viewBaby = findViewById(R.id.viewBaby_overlay);
        viewDiaper = findViewById(R.id.viewDiaper_overlay);
        viewFeeding = findViewById(R.id.viewFeeding_overlay);
        viewNewBaby = findViewById(R.id.viewNewBaby_overlay);


        user = new User();

        sharedPreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        String userJson = sharedPreferences.getString(UserName,"");

        try {
            assert userJson != null;
            if (userJson.length() > 0) {
                user.load(userJson);
                Log.i("My_onCreate", "Loaded Past User");
            } else {
                Log.i("My_onCreate", "No Past User");
            }
        }
        catch (AssertionError e){
            //If the userJson is a null pointer length will raise an error
            //If that happens then we just assume no past user
            Log.e("My_onCreate",e.getMessage());
        }



        // get the size of the screen/window
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // translate the overlay off screen without animation before anyone can see it.
        viewBaby.setX(size.x);
        viewFeeding.setX(size.x);
        viewDiaper.setX(size.x);
        viewNewBaby.setX(size.x);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sharedPreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(UserName,user.save());

        editor.apply();

        Log.i("My_onPause","Saved Past User");


    }

    /**
     * hideBaby hides the constraint when the user clicks on the sliding window
     * @param view app view
     */
    public void hideBaby(View view) {
        viewBaby.animate().x(viewBaby.getWidth()).setDuration(animationDuration);
    }

    /**
     * viewBaby moves the over lay onto the screen.
     * @param view app view
     */
    public void viewBaby(View view) {
        // move overlay on screen by animating the x value
        viewBaby.animate().x(0).setDuration(animationDuration);
        viewFeeding.animate().x(viewFeeding.getWidth()).setDuration(animationDuration);
        viewDiaper.animate().x(viewDiaper.getWidth()).setDuration(animationDuration);
    }

    /**
     * hideFeeding hides the constraint when the user clicks on the sliding window
     * @param view app view
     */
    public void hideFeeding(View view) {
       viewFeeding.animate().x(viewFeeding.getWidth()).setDuration(animationDuration);
    }

    /**
     * viewFeeding moves the overlay onto the screen
     * @param view app view
     */
    public void viewFeeding(View view) {
        // move overlay on screen by animating the x value
        viewFeeding.animate().x(0).setDuration(animationDuration);
        viewBaby.animate().x(viewBaby.getWidth()).setDuration(animationDuration);
        viewDiaper.animate().x(viewDiaper.getWidth()).setDuration(animationDuration);
    }


    /**
     * Hides the diaper overlay
     * @param view app view
     */
    public void hideDiaper(View view) {
        viewDiaper.animate().x(viewDiaper.getWidth()).setDuration(animationDuration);
    }

    /**
     * Shows the diaper overlay
     * @param view app view
     */
    public void viewDiaper (View view) {
        viewDiaper.animate().x(0).setDuration(animationDuration);
        viewFeeding.animate().x(viewFeeding.getWidth()).setDuration(animationDuration);
        viewBaby.animate().x(viewBaby.getWidth()).setDuration(animationDuration);
    }

    /**
     * on background click will hide the viewNewBaby_overlay
     * @param view
     */
    public void hideNewBaby(View view) {
        viewNewBaby.animate().x(viewNewBaby.getWidth()).setDuration(animationDuration);
    }

    /**
     * Moves the viewNewBaby_overlay onto the screen
     * @param view
     */
    public void viewNewBaby(View view) {
        viewNewBaby.animate().x(0).setDuration(animationDuration);
        viewBaby.animate().x(viewBaby.getWidth()).setDuration(animationDuration);
    }
}
