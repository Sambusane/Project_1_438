package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {
    EditText firstName;
    EditText userName;
    EditText zipcode;
    EditText password;
    Button submitButton;
    String userFName;
    String userUserName;
    Integer userZip;
    String userPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
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

                    }else {
                        addUserToDAO();
                    }
                }else{
                    Toast.makeText(CreateAccountActivity.this,"Please fill out all fields.",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void addUserToDAO() {
        //TODO: add user to database;
    }

    private boolean isUserInDAO() {
        //TODO:check if user is in database
        return true;

    }

    private boolean checkValid() {
        if (validateFirstName()&&validatePassword()&&validateUserName()&&validateZipcode()){
            return true;
        }
        return false;

    }

    private boolean validateFirstName(){
        if (userFName == null){
            firstName.setError("field cannot be empty!");
            return false;
        }else {
            firstName.setError(null);
        }
        return true;
    }
    private boolean validateUserName(){
        if (userUserName == null){
            userName.setError("field cannot be empty!");
            return false;
        }else {
            userName.setError(null);
        }
        return true;
    }
    private boolean validateZipcode(){
        if (userZip == null){
            zipcode.setError("field cannot be empty!");
            return false;
        }else {
            zipcode.setError(null);
        }
        return true;
    }
    private boolean validatePassword(){
        if (userPass == null){
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
        userZip = Integer.parseInt(zipcode.getText().toString().trim());
        userPass = password.getText().toString().trim();
    }

    public static Intent intentFactory(Context context){
        return new Intent(context, CreateAccountActivity.class);
    }

}