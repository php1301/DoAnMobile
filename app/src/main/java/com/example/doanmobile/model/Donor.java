package com.example.doanmobile.model;

public class Donor {
    private String name;

    public Donor(){ }

    public Donor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
