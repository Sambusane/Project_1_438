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
import com.example.project_1_438.DAO.User;
import com.example.project_1_438.DAO.UserDao;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    UserDao mUserDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      
        Button loginBtn = findViewById(R.id.loginBtn);
        Button createAccountBtn = findViewById(R.id.createAccountBtn);
        Button editAccountBtn = findViewById(R.id.EditAccount);

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

        editAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = EditAccountLogin.intentFactory(MainActivity.this);
                startActivity(intent);
            }
        });

        /**
          Creation of the Database when app is first loaded. Will be used when called upon by using'
         db.function();
         */
        Database db = Room.databaseBuilder(getApplicationContext(),Database.class,
                "User").build();
        /*
        creating a function that checks if the database of users is empty and if it is it will create and add in an admin user and a dummy user
        username: admin, password:admin
        username: Luke, password:Skywalker
         */
        getDatabase();
        checkIfDAOEmpty();

    }

    private void getDatabase() {
        mUserDAO= Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
    }

    private void checkIfDAOEmpty() {
        ArrayList<User> users;
        users= (ArrayList<User>) mUserDAO.getAll();
        if (users.size()<=0){
            User admin = new User("admin",93901,"admin","admin",true);
            User test = new User("Luke",93955,"Luke","Skywalker",false);
            mUserDAO.insertAll(admin,test);
        }
    }

    public static Intent intentFactory(Context context){
        return new Intent(context, MainActivity.class);
    }
}