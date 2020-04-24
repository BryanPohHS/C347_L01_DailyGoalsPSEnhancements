package com.bryanpoh.c347_l01_dailygoalspsenhancements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Get all the names of elements
    TextView tvQ1, tvQ2, tvQ3, tvRJ;
    RadioGroup radioGrp1, radioGrp2, radioGrp3;
    EditText et;
    Button btnSubmit;

    public static final String SHARED_PREFS = "sharedPrefs";

    // SharedPreferences
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Findviewbyid
        tvQ1 = findViewById(R.id.textView1);
        tvQ2 = findViewById(R.id.textView3);
        tvQ3 = findViewById(R.id.textView5);
        tvRJ = findViewById(R.id.textView7);

        radioGrp1 = findViewById(R.id.radiogrp1);
        radioGrp2 = findViewById(R.id.radiogrp2);
        radioGrp3 = findViewById(R.id.radiogrp3);

        et = findViewById(R.id.editText);
        btnSubmit = findViewById(R.id.button);

        // On button submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get radio button values
                RadioButton rb = findViewById(radioGrp1.getCheckedRadioButtonId());
                RadioButton rb2 = findViewById(radioGrp2.getCheckedRadioButtonId());
                RadioButton rb3 = findViewById(radioGrp3.getCheckedRadioButtonId());

                // Questions array to store questions
                String[] summary = {
                        tvQ1.getText().toString() + "\n" + rb.getText().toString(),
                        tvQ2.getText().toString() + "\n" + rb2.getText().toString(),
                        tvQ3.getText().toString() + "\n" + rb3.getText().toString(),
                        tvRJ.getText().toString() + "\n" + et.getText().toString(),
                };

                // Create intent to start summary activity
                Intent i = new Intent(MainActivity.this, SummaryActivity.class);

                // Pass summary to activity
                i.putExtra("summary", summary);

                // Start new activity
                startActivity(i);

                // Call save data function for shared pref
                saveData();
            }
        });

        // Load the saved data from shared pref
        loadData();

    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Insert choices from user into editor
        editor.putInt("choice1", radioGrp1.getCheckedRadioButtonId());
        editor.putInt("choice2", radioGrp2.getCheckedRadioButtonId());
        editor.putInt("choice3", radioGrp3.getCheckedRadioButtonId());
        editor.putString("reflection", et.getText().toString());

        // Commit the choices into editor
        editor.commit();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        // Retrieve the choices from shared prefs and set into appropriate variables
        Integer choice1 = sharedPreferences.getInt("choice1", 0);
        Integer choice2 = sharedPreferences.getInt("choice2", 0);
        Integer choice3 = sharedPreferences.getInt("choice3", 0);

        String reflection = sharedPreferences.getString("reflection", null);

        // Set the radio buttons in the radio group AND edit text with the choices set in shared pref
        radioGrp1.check(choice1);
        radioGrp2.check(choice2);
        radioGrp3.check(choice3);

        et.setText(reflection);
    }
}