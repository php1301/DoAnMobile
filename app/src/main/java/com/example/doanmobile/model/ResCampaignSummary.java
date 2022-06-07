package com.example.doanmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResCampaignSummary {
    @SerializedName("summary")
    @Expose
    private Summary summary;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
