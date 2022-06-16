package com.example.doanmobile.model;

public class Donor {
    private String name;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
