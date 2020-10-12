package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pause;
    private boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }

    public void Startchronometer(View view){
        if(!run){
            chronometer.setBase(SystemClock.elapsedRealtime() - pause);
            chronometer.start();
            run = true;
        }
    }

    public void Pausechronometer(View view){
        if(run){
            chronometer.stop();
            pause = SystemClock.elapsedRealtime() - chronometer.getBase();
            run = false;
        }
    }

    public void Resetchronometer(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pause = 0;
    }
}