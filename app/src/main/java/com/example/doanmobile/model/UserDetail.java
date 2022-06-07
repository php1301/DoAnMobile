package com.example.doanmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetail {
    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("facebookUrl")
    @Expose
    private String facebookUrl;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("displayName")
    @Expose
    private String displayName;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("nonce")
    @Expose
    private String nonce;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("instagramUrl")
    @Expose
    private String instagramUrl;

    @SerializedName("youtubeUrl")
    @Expose
    private String youtubeUrl;

    @SerializedName("walletAddress")
    @Expose
    private String walletAddress;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

}
