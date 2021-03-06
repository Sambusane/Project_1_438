package com.example.project_1_438.DAO;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    public User(String Name, int zipCode, String Username, String Password, boolean adminPerms) {
        this.Name = Name;
        this.zipCode = zipCode;
        this.Username = Username;
        this.Password = Password;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
