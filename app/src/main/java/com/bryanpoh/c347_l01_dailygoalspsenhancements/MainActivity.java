package com.bryanpoh.c347_l01_dailygoalspsenhancements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

            }
        });

    }
}