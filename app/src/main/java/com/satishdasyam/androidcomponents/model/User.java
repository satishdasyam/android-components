package com.satishdasyam.androidcomponents.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    int userId;

    @SerializedName("title")
    String userTitle;

    public int getUserId() {
        return userId;
    }

    public String getUserTitle() {
        return userTitle;
    }
}
