package com.example.fklubben;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Drink> drinks;

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
        setContentView(R.layout.activity_drinks);
       Log.i("test","hertil2");


        this.drinks = new ArrayList<Drink>();
        createModel();
        this.recyclerView = (RecyclerView) findViewById(R.id.drinks_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        this.recyclerView.setHasFixedSize(true);
        // adding things to the recycleview
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        this.recyclerView.addItemDecoration(itemDecoration);
        // use a linear layout manager
        this.layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);
        // specify an adapter
        this.mAdapter = new DrinkAdapter(drinks);
        this.recyclerView.setAdapter(mAdapter);
    }

    private void createModel() {
        Drink drink1 = new Drink("Coca-cola", 12);
        Drink drink2 = new Drink("Kinley", 6);
        Drink drink3 = new Drink("Sportscola", 7);
    }
}
