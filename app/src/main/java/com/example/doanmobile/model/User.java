package com.example.doanmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("user")
    @Expose
    private UserDetail user;

    @SerializedName("userCampaigns")
    @Expose
    private List<String> userCampaigns = null;

    @SerializedName("numberOfCampaigns")
    @Expose
    private Integer numberOfCampaigns;

    @SerializedName("totalDonationReceived")
    @Expose
    private Double totalDonationReceived;

    @SerializedName("finalizeRate")
    @Expose
    private Double finalizeRate;

    public UserDetail getUser() {
        return user;
    }

    public void setUser(UserDetail user) {
        this.user = user;
    }

    public List<String> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<String> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }

    public Integer getNumberOfCampaigns() {
        return numberOfCampaigns;
    }

    public void setNumberOfCampaigns(Integer numberOfCampaigns) {
        this.numberOfCampaigns = numberOfCampaigns;
    }

    public Double getTotalDonationReceived() {
        return totalDonationReceived;
    }

    public void setTotalDonationReceived(Double totalDonationReceived) {
        this.totalDonationReceived = totalDonationReceived;
    }

    public Double getFinalizeRate() {
        return finalizeRate;
    }

    public void setFinalizeRate(Double finalizeRate) {
        this.finalizeRate = finalizeRate;
    }
}
