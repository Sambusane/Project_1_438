package com.example.project_1_438;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        Button createAccountBtn = (Button)findViewById(R.id.createAccountBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * need to still check to make sure the credentials match - Tim
                 */

                Intent intent = new Intent(getApplicationContext(), loginPage.class);
                startActivity(intent);
            }
        });

    }
}