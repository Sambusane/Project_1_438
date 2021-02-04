package com.example.project_1_438.DAO;


import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract UserDao userDao();
}
