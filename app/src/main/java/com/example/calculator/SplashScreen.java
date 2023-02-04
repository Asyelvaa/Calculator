package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String USERNAME_KEY = "username_key";
    public static final String PASSWORD_KEY = "password_key";

    // variable for shared preferences.
    SharedPreferences sharedpreferences;
    String username, password;
    private int timeLoad=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        username = sharedpreferences.getString(USERNAME_KEY, null);
        password = sharedpreferences.getString(PASSWORD_KEY, null);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                    Intent splash=new Intent(SplashScreen.this, MainActivity.class);
//                    startActivity(splash);
//                    finish();
                    if (username != null && password != null) {
                        Intent i = new Intent(SplashScreen.this, Calculator.class);
                        startActivity(i);

                    }else{
                        Intent i = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(i);
                    }
                    finish();

                }
            },1000);





    }
}