package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project_1_438.DAO.Database;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserDao = Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
        setContentView(R.layout.activity_temp_display_page);
        Intent Prev = getIntent();
        //User = Prev.getStringExtra("N");
         userID = Prev.getIntExtra("N", 0);
        //getSupportActionBar().setTitle("Welcome " + User);
        getSupportActionBar().setTitle("Welcome " + userID);
        adminButton = findViewById(R.id.admin_button);
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

        String zipCode = "95076";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: "+response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post: posts) {
                    String content ="";
                    content += "ID: "+post.getId()+"\n";
                    content += "User ID: "+post.getUserId()+"\n";
                    content += "Title: "+post.getTitle()+"\n";
                    content += "Text: "+post.getText()+"\n\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}