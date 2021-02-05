package com.example.project_1_438.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE User.username = :mUsername")
    User getUserByUsername(String mUsername);

    @Insert
    void insertAll(User...user);


    @Delete
    void deleteAll(User...user);

    @Delete
    void delete(User...user);
}
