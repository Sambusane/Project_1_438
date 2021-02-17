package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project_1_438.DAO.Database;
import com.example.project_1_438.DAO.UserDao;


public class tempDisplayPage extends AppCompatActivity {
    Button adminButton;
    Button deleteAccountButton;
    int userID;
    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserDao = Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
        setContentView(R.layout.activity_temp_display_page);
        Intent Prev = getIntent();
        //User = Prev.getStringExtra("N");
         userID = Prev.getIntExtra("N", 0);
        //getSupportActionBar().setTitle("Welcome " + User);
        getSupportActionBar().setTitle("Welcome " + userID);
        adminButton = findViewById(R.id.admin_button);
        deleteAccountButton = findViewById(R.id.delete_button);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AdminActivity.intentFactory(tempDisplayPage.this);
                startActivity(intent);
            }
        });

        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), loginPage.class);
                //Intent intent = MainActivity.intentFactory(MainActivity.class);
                //intent.putExtra("N",username);
                startActivity(intent);
                finish();//stops user from going back to previous pages on the phone
                //mUserDao.delete(userID); <-- this needs to take the correct user
            }//if you comment out this whole set on click listener function, then the app runs fine.
            //maybe check the xml to see if button needs something
            //maybe create a new activity, but i dont think so since it will go back to main activity
        });
    }
}