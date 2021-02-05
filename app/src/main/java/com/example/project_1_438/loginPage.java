package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        TextView usernameLogin = (TextView)findViewById(R.id.usernameLogin);
        TextView passwordLogin = (TextView)findViewById(R.id.passwordLogin);
        Button loginPageBtn = (Button)findViewById(R.id.loginPageBtn);
    }
}