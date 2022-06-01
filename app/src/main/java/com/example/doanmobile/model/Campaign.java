package com.example.doanmobile.model;

import com.google.gson.annotations.SerializedName;

public class Campaign {

    @SerializedName("organizationName")
    private String organizationName;
    @SerializedName("campaignBanner")
    private String campaignBanner;
    @SerializedName("campaignDescription")
    private String CampaignDescription;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCampaignBanner() {
        return campaignBanner;
    }

    public void setCampaignBanner(String campaignBanner) {
        this.campaignBanner = campaignBanner;
    }

    public String getCampaignDescription() {
        return CampaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        CampaignDescription = campaignDescription;
    }

    public Campaign(String organizationName, String campaignBanner) {
        this.organizationName = organizationName;
        this.campaignBanner = campaignBanner;
    }

    public Campaign(String organizationName, String campaignBanner, String campaignDescription) {
        this.organizationName = organizationName;
        this.campaignBanner = campaignBanner;
        CampaignDescription = campaignDescription;
    }

    public Campaign() {}

}
