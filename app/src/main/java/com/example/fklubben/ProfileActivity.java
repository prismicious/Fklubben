package com.example.fklubben;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;

    //ImageView imageView = findViewById(R.id.profileImg);

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences myPrefsFile = getSharedPreferences("MyPrefsFile", Activity.MODE_PRIVATE);

        String savedFirstName= myPrefsFile.getString("firstname", "");
        String savedLastName = myPrefsFile.getString("lastname", "");
        String savedEmail = myPrefsFile.getString("email", "");

        EditText firstname = (EditText) findViewById(R.id.firstName);
        EditText lastname = (EditText) findViewById(R.id.lastName);
        EditText email = (EditText) findViewById(R.id.email);

        firstname.setText("" + savedFirstName);
        lastname.setText("" + savedLastName);
        email.setText("" + savedEmail);
    }

    public void onClickCamera(View  view){
        Intent myCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(myCameraIntent, CAMERA_REQUEST);
    }

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data){
        super.onActivityResult(reqCode, resCode, data);
        switch (reqCode){
            case CAMERA_REQUEST : {
                if(resCode == Activity.RESULT_OK){
                    Bitmap newFace = (Bitmap) data.getExtras().get("data");

                    ImageView image = (ImageView) findViewById(R.id.profileImg);
                    image.setImageBitmap(newFace);

                    ContextWrapper cw = new ContextWrapper(getApplicationContext());
                    File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
                    File mypath = new File(directory,"profile.jpg");
                    FileOutputStream outputstream = null;

                    try{
                        outputstream = new FileOutputStream(mypath);
                        newFace.compress(Bitmap.CompressFormat.JPEG, 90, outputstream);
                        outputstream.close();
                    } catch (IOException e) {
                        e.printStackTrace(); }


                } }
            default: break; }
    }

    public void onClickSave(View view){
       savePrefs(view);
    }

    public void savePrefs(View view) {

        EditText firstname = (EditText) findViewById(R.id.firstName);
        EditText lastname = (EditText) findViewById(R.id.lastName);
        EditText email = (EditText) findViewById(R.id.email);


        SharedPreferences myPrefsFile = getSharedPreferences("MyPrefsFile", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefsFile.edit();
        editor.putString("firstname", String.valueOf(firstname.getText()));
        editor.putString("lastname", String.valueOf(lastname.getText()));
        editor.putString("email", String.valueOf(email.getText()));
        editor.commit();
        }
    }
