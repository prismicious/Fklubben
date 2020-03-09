package com.example.fklubben;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ProfileActivity extends AppCompatActivity {

    String put_firstName = String.valueOf((TextView)findViewById(R.id.firstName));
    String put_lastName = String.valueOf((TextView)findViewById(R.id.lastName));
    String put_Email = String.valueOf((TextView)findViewById(R.id.email));
    //ImageView imageView = findViewById(R.id.profileImg);

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void onClickCamera(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //imageView.setImageBitmap(imageBitmap);
        }
    }

    public void onClickSave(View view){
      //  savePrefs(view);
    }
 /*
    public void savePrefs(View view) {
        SharedPreferences myPrefsFile = getSharedPreferences("MyPrefsFile", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefsFile.edit();
        editor.putString("firstName", put_firstName);
        editor.putString("lastName", put_lastName);
        editor.putString("Email", put_Email);
        editor.commit();
        }*/
    }
