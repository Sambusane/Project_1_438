package com.example.project_1_438;
//comment
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.project_1_438.DAO.Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
          Creation of the Database when app is first loaded. Will be used when called upon by using'
         db.function();
         */
        Database db = Room.databaseBuilder(getApplicationContext(),Database.class,
                "User").build();
    }
}