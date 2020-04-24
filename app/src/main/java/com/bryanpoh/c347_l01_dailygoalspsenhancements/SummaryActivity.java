package com.bryanpoh.c347_l01_dailygoalspsenhancements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_activity);

        // Get button
        Button btnClose = findViewById(R.id.button);

        // Get the intent so as to get the things inside the intent
        Intent i = getIntent();

        // Get string array "info"
        String[] summary = i.getStringArrayExtra("summary");

        // Get textview objkect
        TextView tv1 = findViewById(R.id.tvSummary1);

        // Display questions
        String msg = "";
        for(String j:summary)
        {
            msg += j + "\n";
        }
        tv1.setText(msg);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}