package com.example.doanmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Summary {
    @SerializedName("0")
    @Expose
    private String minimumContribution;

    @SerializedName("1")
    @Expose
    private String balance;

    @SerializedName("2")
    @Expose
    private String requestsCount;

    @SerializedName("3")
    @Expose
    private String approversCount;

    @SerializedName("4")
    @Expose
    private String manager;

    @SerializedName("5")
    @Expose
    private String name;

    @SerializedName("6")
    @Expose
    private String description;

    @SerializedName("7")
    @Expose
    private String image;

    @SerializedName("8")
    @Expose
    private String dateCreated;

    @SerializedName("9")
    @Expose
    private String dateUpdated;

    @SerializedName("10")
    @Expose
    private String target;

    @SerializedName("11")
    @Expose
    private List<RoadMap> roadmap = null;

    public String getMinimumContribution() {
        return minimumContribution;
    }

    public void setMinimumContribution(String minimumContribution) {
        this.minimumContribution = minimumContribution;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRequestsCount() {
        return requestsCount;
    }

    public void setRequestsCount(String requestsCount) {
        this.requestsCount = requestsCount;
    }

    public String getApproversCount() {
        return approversCount;
    }

    public void setApproversCount(String approversCount) {
        this.approversCount = approversCount;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<RoadMap> getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(List<RoadMap> roadmap) {
        this.roadmap = roadmap;
    }
}
