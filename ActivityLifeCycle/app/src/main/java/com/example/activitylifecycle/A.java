package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.i("create","onCreate:layout created");
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("start", "onStart: i am starting");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Restart","onRestart:i have restarted");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("resume", "onResume: i am resumed..");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("pause", "onPause:i a currently paused ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("stop", "onStop: i have stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("destroy", "onDestroy: i am destroyed");
    }
}