package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.*;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    RadioGroup radioGroup;
    EditText name, email;
    Switch finalYear;
    Boolean boo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.grpRadio);
        btnSave=findViewById(R.id.btnSave);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        finalYear=findViewById(R.id.switch1);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=radioGroup.getCheckedRadioButtonId();
                if(id==-1){
                    Toast.makeText(MainActivity.this, "Choose!", Toast.LENGTH_SHORT).show();
                }
                else{

                    if(finalYear.isChecked()){
                        boo=true;
                    }
                    else{
                        boo=false;
                    }

                    Student student = new Student(name.getText().toString(), email.getText().toString(), radioGroup.getTransitionName(), boo);
                    saveJsonToSharedPreferences("1", student);
                    retrieveJsonFromSharedPreferences("1");



                }
            }
        });

    }

    public void saveJsonToSharedPreferences(String key, Student student) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(student);
        SharedPreferences sharedPreferences = getSharedPreferences("student", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, jsonString);
        editor.apply();
        editor.commit();
    }

    public Student[] retrieveJsonFromSharedPreferences(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String jsonString = sharedPreferences.getString(key, null);

        if (jsonString != null) {
            Gson gson = new Gson();
            Student[] student = new Student[]{gson.fromJson(jsonString, Student.class)};
            return student;
        }

        return null;
    }





}