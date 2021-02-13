package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tempDisplayPage extends AppCompatActivity {
    Button adminButton;
    String User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_display_page);
        Intent Prev = getIntent();
        User = Prev.getStringExtra("N");
        getSupportActionBar().setTitle("Welcome " + User);
        adminButton = findViewById(R.id.admin_button);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AdminActivity.intentFactory(tempDisplayPage.this);
                startActivity(intent);
            }
        });

    }
}