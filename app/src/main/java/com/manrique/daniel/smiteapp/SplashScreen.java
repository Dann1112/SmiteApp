package com.manrique.daniel.smiteapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getActionBar().hide();
        setContentView(R.layout.splash_screen);

        Intent goToMenu = new Intent(this, MainMenu.class);

        Timer t = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            }
        };

        t.schedule(task, 20000);
        startActivity(goToMenu);

    }
}
