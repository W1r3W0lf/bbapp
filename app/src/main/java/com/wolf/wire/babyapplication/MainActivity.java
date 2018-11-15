package com.wolf.wire.babyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    User user;

    public static final String MyPrefs = "MyPrefs";
    public static final String UserName = "UserName";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = new User();

        sharedPreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        String userJson = sharedPreferences.getString(UserName,"");

        if (userJson.length() > 0){
            user.load(userJson);
        } else {
            Log.i( "onCreate","No Past User");
        }



    }

    @Override
    protected void onPause() {
        super.onPause();

        sharedPreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(UserName,user.save());

        editor.apply();



    }



}
