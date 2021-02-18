package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project_1_438.DAO.Database;
import com.example.project_1_438.DAO.User;
import com.example.project_1_438.DAO.UserDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class tempDisplayPage extends AppCompatActivity {
    Button adminButton;
    Button deleteAccountButton;
    int userID;
    private UserDao mUserDao;
    private TextView textViewResult;
    User loggedIn;
    String User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_display_page);

        getDatabase();
        Intent Prev = getIntent();
        User = Prev.getStringExtra("N");
        getSupportActionBar().setTitle("Welcome " + User);
        adminButton = findViewById(R.id.admin_button);
        getUser();


        deleteAccountButton = findViewById(R.id.delete_button);
        textViewResult = findViewById(R.id.text_view_result);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AdminActivity.intentFactory(tempDisplayPage.this);
                startActivity(intent);
            }
        });

        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), loginPage.class);
                //Intent intent = MainActivity.intentFactory(MainActivity.class);
                //intent.putExtra("N",username);
                startActivity(intent);
                finish();//stops user from going back to previous pages on the phone
                //mUserDao.delete(userID); <-- this needs to take the correct user
            }//if you comment out this whole set on click listener function, then the app runs fine.
            //maybe check the xml to see if button needs something
            //maybe create a new activity, but i dont think so since it will go back to main activity
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.getPost(loggedIn.getZipCode(),"74d8517267ed379a707898f5da43b1cc","imperial");
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: "+response.code());
                    return;
                }
                String content="";
                Post posts = response.body();
                content += "Forcast: "+posts.weather.get(0).description+"\n";
                content += "Temperature: "+posts.main1.temp+"\n";
                content += "City: "+posts.name+"\n";
                textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getUser() {
        loggedIn = mUserDao.getUserByUsername(User);
        if (loggedIn.adminPerms){
            adminButton.setVisibility(View.VISIBLE);
        }else {
            adminButton.setVisibility(View.GONE);
        }
    }

    public void getDatabase(){
        mUserDao = Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
    }

}