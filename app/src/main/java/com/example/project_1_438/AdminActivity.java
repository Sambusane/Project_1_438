package com.example.project_1_438;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.project_1_438.DAO.Database;
import com.example.project_1_438.DAO.User;
import com.example.project_1_438.DAO.UserDao;
import com.example.project_1_438.RecyclerView.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UserDao mUserDAO;
    List<User> users;
    ArrayList<String> firstname = new ArrayList<>();
    ArrayList<String> username= new ArrayList<>();
    ArrayList<String> password= new ArrayList<>();
    ArrayList<Integer> zipcode= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        recyclerView = findViewById(R.id.user_list);
        getDatabase();
        getRecView();

    }

    private void getRecView() {
        users = mUserDAO.getAll();
        for (User i : users){
            if (!i.adminPerms){
                firstname.add(i.Name);
                username.add(i.Username);
                password.add(i.Password);
                zipcode.add(i.zipCode);
            }
        }
        UserAdapter adapter= new UserAdapter(this,username,firstname,zipcode,password);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    public static Intent intentFactory(Context con){
        return new Intent(con,AdminActivity.class);
    }

    private void getDatabase() {
        mUserDAO= Room.databaseBuilder(this, Database.class,"USER_TABLE")
                .allowMainThreadQueries()
                .build()
                .userDao();
    }
}