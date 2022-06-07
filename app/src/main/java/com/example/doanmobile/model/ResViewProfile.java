package com.example.doanmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResViewProfile {
    @SerializedName("user")
    @Expose
    private User users;

    public User getUser() {
        return users;
    }

    public void setUser(User users) {
        this.users = users;
    }
}
