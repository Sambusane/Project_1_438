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

import java.util.List;

public class loginPage extends AppCompatActivity {

    UserDao mUserDAO;
    List<User> allAccounts;
    EditText usernameLogin;
    EditText passwordLogin;
    Button loginPageBtn;

    String accountName;
    String password;
    String username;
    User signedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        usernameLogin = findViewById(R.id.usernameLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        loginPageBtn = findViewById(R.id.loginPageBtn);

        getSupportActionBar().setTitle("Welcome, log into your account");

        getDatabase();

        loginPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkValid()){
                    if(checkDAO()){

                        Intent intent = new Intent(getApplicationContext(), tempDisplayPage.class);
                        intent.putExtra("N",username);
                        //intent.putExtra("N",signedInUser.uid);
                        //intent.putExtra("N",signedInUser);//get this to work correctly by having the signed in
                        //user account deleted from the database
                        startActivity(intent);

                    }else{
                        //make user retype their username and password
                        //make toast saying it didnt work because there was no one with the username and password

                        Toast.makeText(loginPage.this,"Account doesn't exist",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    //make user retype their username and password
                    //make toast saying it didnt work because

                    Toast.makeText(loginPage.this,"Username or Password Invalid",Toast.LENGTH_SHORT).show();
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

    private boolean checkValid(){
        return checkPassword() && checkUsername();
    }

    private boolean checkPassword(){

        password = passwordLogin.getText().toString();

        if(password.equals("")){
            passwordLogin.setError("field cannot be empty!");
            return false;
        }else{
            passwordLogin.setError(null);
        }

        return true;
    }

    private boolean checkUsername(){

        username = usernameLogin.getText().toString();

        if(username.equals("")){
            usernameLogin.setError("field cannot be empty!");
            return false;
        }else{
            usernameLogin.setError(null);
        }

        return true;
    }

    private boolean checkDAO(){

        allAccounts = mUserDAO.getAll();

        for(int i = 0; i < allAccounts.size(); i++){

            System.out.println(allAccounts.get(i).getUsername());

            if(allAccounts.get(i).getUsername().equals(username) && allAccounts.get(i).getPassword().equals(password)){
                  signedInUser = allAccounts.get(i);
                  return true;
            }
        }
        return false;
    }

    public static Intent intentFactory(Context context){
        return new Intent(context, loginPage.class);
    }

}