package com.wolf.wire.babyapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.wolf.wire.babyapplication.R.id.viewBaby_overlay;

public class MainActivity extends AppCompatActivity {

    private User user;

    // viewbaby variables
    private long animationDuration = 1000;
    private ConstraintLayout viewBaby = null;


    public static final String MyPrefs = "MyPrefs";
    public static final String UserName = "UserName";

    SharedPreferences sharedPreferences;

    private TextView textView1 = null;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView);

        /* find the overlay */
        viewBaby = findViewById(R.id.viewBaby_overlay);

        user = new User();

        sharedPreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        String userJson = sharedPreferences.getString(UserName,"");

        if (userJson.length() > 0){
            user.load(userJson);
            Log.i("My_onCreate","Loaded Past User");
        } else {
            Log.i( "My_onCreate","No Past User");
        }



        // get the size of the screen/window
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // translate the viewBaby_overlay off screen without animation before anyone can see it.
        viewBaby.setX(size.x);
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



    public void baby(View view) {
        Log.i("My_babyButton","Button pushed");
        textView1.setText(Integer.toString(++user.childrenNumber));
        user.makeBaby("Test");
    }

    public void hideBaby(View view) {
        viewBaby.animate().x(viewBaby.getWidth()).setDuration(animationDuration);
    }

    public void viewBaby(View view) {
        // move overlay on screen by animating the x value
        viewBaby.animate().x(0).setDuration(animationDuration);
    }
}
