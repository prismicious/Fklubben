package com.example.fklubben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {

    public void onClickAboutUs(View view){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void onClickDrinks(View view){
        Intent intent = new Intent(this, DrinksActivity.class);
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
}
