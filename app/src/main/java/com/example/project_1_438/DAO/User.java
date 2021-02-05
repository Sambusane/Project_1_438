package com.example.project_1_438.DAO;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    public User(String name, int zipCode, String username, String password, boolean adminPerms) {
        Name = name;
        this.zipCode = zipCode;
        Username = username;
        Password = password;
        this.adminPerms = adminPerms;
    }

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "Name")
    public String Name;

    @ColumnInfo(name ="ZipCode")
    public int zipCode;

    @ColumnInfo(name = "username")
    public String Username;

    @ColumnInfo(name = "password")
    public String Password;

    @ColumnInfo(name = "adminPerms")
    public boolean adminPerms = false;


}
