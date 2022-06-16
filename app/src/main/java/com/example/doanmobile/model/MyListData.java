package com.example.doanmobile.model;

//
public class MyListData {
    private String description;
    private String address;
    private int imgId;
    public MyListData(String description, String address, int imgId) {
        this.description = description;
        this.address = address;
        this.imgId = imgId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
//
