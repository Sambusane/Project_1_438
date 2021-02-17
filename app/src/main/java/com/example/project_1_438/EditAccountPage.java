package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_1_438.DAO.Database;
import com.example.project_1_438.DAO.User;
import com.example.project_1_438.DAO.UserDao;

import java.util.List;

public class EditAccountPage extends AppCompatActivity {
    //Variables
    UserDao mUserDAO;
    List<User> allAccounts;

    //XML Attachments
     EditText name;
     EditText user;
     EditText pass;
     EditText zip;
     Button confirm;
     Button deleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_page);
        Intent intent = getIntent();
        final String username = intent.getStringExtra("N");
        getSupportActionBar().setTitle("Welcome: " + username + "!");
        name = findViewById(R.id.editAccountName);
        user = findViewById(R.id.editAccountUsername);
        pass = findViewById(R.id.editAccountPassword);
        zip = findViewById(R.id.editAccountZipCode);
        confirm = findViewById(R.id.EditAccountConfirm);
        getDatabase();
        fillContent(username);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(submitInformation(username)){
                    Toast.makeText(EditAccountPage.this,"Account Information Updated!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(EditAccountPage.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * Retrieve the local database
     */
    private void getDatabase() {
        mUserDAO = Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
    }

    /**
     * Called upon page loading, auto-filling the EditTexts for user to then go ahead and update account;
     */
    public void fillContent(String n){
        allAccounts = mUserDAO.getAll();
        for(int i = 0; i < allAccounts.size(); i++){
            if(n.equals(allAccounts.get(i).Username)){
                user.setText(n);
                name.setText(allAccounts.get(i).Name);
                int zCon = allAccounts.get(i).getZipCode();
                zip.setText(Integer.toString(zCon));
                pass.setText(allAccounts.get(i).Password);

            }
        }
    }

    /**
     *
     * @param n - Username for comparison within the <bold>List<User></bold>
     *        Added new Query to UserDAO which if there is an issue (user from allAccounts list is in the DAO) if so, overwrite it. (meaning if there is a username in the DAO that matches the input from allAccounts
     *        just overwrite it since information hasn't been changed.
     * @return return true if the account information has been altered within the list, then added to the Room Database
     */
    public boolean submitInformation(String n){
        allAccounts = mUserDAO.getAll();
        for(int i = 0; i < allAccounts.size(); i++) {
            if(n.equals(allAccounts.get(i).Username)){
                allAccounts.get(i).Username = user.getText().toString();
                allAccounts.get(i).Name = name.getText().toString();
                allAccounts.get(i).zipCode = Integer.parseInt(zip.getText().toString());
                allAccounts.get(i).Password = pass.getText().toString();
                mUserDAO.insertAllUsers(allAccounts);
                return true;
            }
        }
        return false;
    }



    public static Intent intentFactory(Context context){
        return new Intent(context, EditAccountPage.class);
    }
}