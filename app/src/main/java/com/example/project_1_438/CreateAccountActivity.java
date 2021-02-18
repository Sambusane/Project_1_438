package com.example.project_1_438;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.project_1_438.DAO.Database;
import com.example.project_1_438.DAO.User;
import com.example.project_1_438.DAO.UserDao;

public class CreateAccountActivity extends AppCompatActivity {
    EditText firstName;
    EditText userName;
    EditText zipcode;
    EditText password;
    Button submitButton;
    String userFName;
    String userUserName;
    String userZip;
    String userPass;
    UserDao mUserDAO;
    User addUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        getSupportActionBar().setTitle("Create your account");

        getDatabase();
        wireUpDisplay();
    }

    private void wireUpDisplay() {
        firstName = findViewById(R.id.createFirstName);
        userName = findViewById(R.id.createPersonName);
        zipcode = findViewById(R.id.createZipcode);
        password = findViewById(R.id.createPassword);
        submitButton = findViewById(R.id.createButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTheFields();

                if (checkValid()){

                    if (isUserInDAO()){
                        Toast.makeText(CreateAccountActivity.this,"Username is taken.",Toast.LENGTH_SHORT).show();

                    }else {
                        addUserToDAO();
                        Toast.makeText(CreateAccountActivity.this,"Account Created. Please Log in",Toast.LENGTH_SHORT).show();
                        Intent intent= MainActivity.intentFactory(CreateAccountActivity.this);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(CreateAccountActivity.this,"Please fill out all fields.",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    private void getDatabase() {
        mUserDAO= Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
    }

    private void addUserToDAO() {
        addUser = new User(userFName,Integer.parseInt(userZip),userUserName,userPass,false);
        mUserDAO.insertAll(addUser);
    }

    private boolean isUserInDAO() {
        addUser = mUserDAO.getUserByUsername(userUserName);
        if (addUser==null){
            return false;
        }
        return true;

    }

    private boolean checkValid() {
        validateZipcode();
        validateUserName();
        validatePassword();
        validateFirstName();
        return validateFirstName() && validatePassword() && validateUserName() && validateZipcode();

    }

    private boolean validateFirstName(){
        if (userFName == null||userFName.equals("")){
            firstName.setError("field cannot be empty!");
            return false;
        }else {
            firstName.setError(null);
        }
        return true;
    }
    private boolean validateUserName(){
        if (userUserName == null||userUserName.equals("")){
            userName.setError("field cannot be empty!");
            return false;
        }else {
            userName.setError(null);
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

    private void getTheFields() {
        userFName = firstName.getText().toString().trim();
        userUserName = userName.getText().toString().trim();
        userZip = zipcode.getText().toString().trim();
        userPass = password.getText().toString().trim();
    }

    public static String testCreateAccount(User user){
        User testUser = user;
        return testUser.Name;
    }

    public static Intent intentFactory(Context context){
        return new Intent(context, CreateAccountActivity.class);
    }

}