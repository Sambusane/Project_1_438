package com.example.project_1_438;

import com.google.gson.annotations.SerializedName;

public class Post {
<<<<<<< HEAD
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }
=======


    public String title;
    @SerializedName("body")
    public String text;
    //comment to fix post
    public int userId;

    public int id;
>>>>>>> origin/master

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
<<<<<<< HEAD
}
=======

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }
}
>>>>>>> origin/master
