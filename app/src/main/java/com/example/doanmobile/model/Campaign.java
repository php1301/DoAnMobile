package com.example.doanmobile.model;

public class Campaign {
    private String organizationName;

    public Campaign(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Campaign() {}

}
