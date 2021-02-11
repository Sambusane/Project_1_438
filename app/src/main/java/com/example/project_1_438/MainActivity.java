package com.example.project_1_438;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import com.example.project_1_438.DAO.Database;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        Button loginBtn = findViewById(R.id.loginBtn);
        Button createAccountBtn = findViewById(R.id.createAccountBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * need to still check to make sure the credentials match - Tim
                 */

                Intent intent = loginPage.intentFactory(MainActivity.this);
                startActivity(intent);
            }
        });

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CreateAccountActivity.intentFactory(MainActivity.this);
                startActivity(intent);
            }
        });

        /**
          Creation of the Database when app is first loaded. Will be used when called upon by using'
         db.function();
         */
        Database db = Room.databaseBuilder(getApplicationContext(),Database.class,
                "User").build();

    }
    public static Intent intentFactory(Context context){
        return new Intent(context, MainActivity.class);
    }
}