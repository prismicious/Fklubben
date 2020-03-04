package com.example.fklubben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final Button aboutUsButton = (Button) findViewById(R.id.btn_aboutus);
    final Button mapButton = (Button) findViewById(R.id.btn_map);
    final Button drinksButton = (Button) findViewById(R.id.btn_drinks);
    final Button contactButton = (Button) findViewById(R.id.btn_kontakt);
    final Button testButton = (Button) findViewById(R.id.btn_test);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickAboutUs(View view){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void onClickDrinks(View view){
        Intent intent = new Intent(this, drinks.class);
        startActivity(intent);
    }

    public void onClickContact(View view){
        Intent intent = new Intent(this, contact.class);
        startActivity(intent);
    }

    public void onClickMap(View view){
        Intent intent = new Intent(this, map.class);
        startActivity(intent);
    }

    public void onClickTest(View view){
        Intent intent = new Intent(this, test.class);
        startActivity(intent);
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
