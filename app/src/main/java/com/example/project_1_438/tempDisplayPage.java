package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class tempDisplayPage extends AppCompatActivity {
    String User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_display_page);
        Intent Prev = getIntent();
        User = Prev.getStringExtra("N");
        getSupportActionBar().setTitle("Welcome " + User);
    }
}