package com.example.fklubben;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("OnCreate", "OnCreate called!");
    }

    protected void onStart()
    {
        super.onStart();
        Log.i("OnStart", "OnStart called!");
    }

    protected void onResume()
    {
        super.onResume();
        Log.i("onResume", "onResume called!");
    }


    protected void onPause()
    {
        super.onPause();
        Log.i("onPause", "onPause called!");
    }

    protected void onStop()
    {
        super.onStop();
        Log.i("onPause", "onPause called!");
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("onDestroy", "onDestroy called!");
    }
}
