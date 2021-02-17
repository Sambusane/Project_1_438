package com.example.project_1_438.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface  UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE User.username = :mUsername")
    User getUserByUsername(String mUsername);

    @Query("DELETE FROM User WHERE User.username = :user")
    void deleteSpecificUser(String user);

    @Insert
    void insertAll(User...user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUsers(List<User> user);

    @Delete
    void deleteAll(User...user);

    @Delete
    void delete(User...user);

    @Update
    void update(User user);
}
