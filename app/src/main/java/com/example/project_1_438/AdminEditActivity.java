package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_1_438.DAO.Database;
import com.example.project_1_438.DAO.User;
import com.example.project_1_438.DAO.UserDao;

public class AdminEditActivity extends AppCompatActivity {
    EditText firstname;
    EditText username;
    EditText password;
    EditText zipcode;
    Button editButton;
    Button deleteButton;
    UserDao mUserDAO;
    User user;
    User testUsername;
    String useName;
    String userFName;
    String userUserName;
    String userZip;
    String userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit);
        getDatabase();
        getUserFromDB();
        wireUpDisplay();

    }

    private void getUserFromDB() {
        Intent intent = getIntent();
        useName = intent.getStringExtra("USERNAME");
        user = mUserDAO.getUserByUsername(useName);

    }

    private void wireUpDisplay() {
        firstname = findViewById(R.id.editTextTextFirstname);
        username = findViewById(R.id.editTextTextUsername);
        password = findViewById(R.id.editTextTextPassword);
        zipcode = findViewById(R.id.editTextTextZipcode);
        firstname.setText(user.Name);
        username.setText(user.Username);
        password.setText(user.Password);
        zipcode.setText(String.valueOf(user.getZipCode()));
        editButton = findViewById(R.id.applyChanges);
        deleteButton = findViewById(R.id.button2);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTheFields();
                if (validateThefields()){
                    user.Name = userFName;
                    user.Password = userPass;
                    user.zipCode = Integer.parseInt(userZip);
                    user.Username = userUserName;
                    mUserDAO.update(user);
                    Toast.makeText(AdminEditActivity.this,"User Updated",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminEditActivity.this,tempDisplayPage.class);
                    intent.putExtra("N","admin");
                    startActivity(intent);
                }
                Toast.makeText(AdminEditActivity.this,"Fill out all fields",Toast.LENGTH_SHORT).show();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserDAO.delete(user);
                Toast.makeText(AdminEditActivity.this,"User Deleted",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminEditActivity.this,tempDisplayPage.class);
                intent.putExtra("N","admin");
                startActivity(intent);

            }
        });

    }
    private void getTheFields() {
        userFName = firstname.getText().toString().trim();
        userUserName = username.getText().toString().trim();
        userZip = zipcode.getText().toString().trim();
        userPass = password.getText().toString().trim();
    }

    private boolean validateThefields() {
        return validateFirstName()&&validatePassword()&&validateUserName()&&validateZipcode();
    }
    private boolean validateFirstName(){
        if (userFName == null||userFName.equals("")){
            firstname.setError("field cannot be empty!");
            return false;
        }else {
            firstname.setError(null);
        }
        return true;
    }
    private boolean validateUserName(){
        if (userUserName == null||userUserName.equals("")){
            username.setError("field cannot be empty!");
            return false;
        }else {
            username.setError(null);
        }
        return true;
    }
    private boolean validateZipcode(){
        if (userZip == null||userZip.equals("")){
            zipcode.setError("field cannot be empty!");
            return false;
        }else {
            zipcode.setError(null);
        }
        return true;
    }
    private boolean validatePassword(){
        if (userPass == null||userPass.equals("")){
            password.setError("field cannot be empty!");
            return false;
        }else {
            password.setError(null);
        }
        return true;
    }


    private void getDatabase() {
        mUserDAO= Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
    }

    public static Intent intentFactory(Context c){
        return new Intent(c,AdminEditActivity.class);
    }
}