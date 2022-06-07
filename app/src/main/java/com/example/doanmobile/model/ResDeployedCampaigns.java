package com.example.doanmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResDeployedCampaigns {
    @SerializedName("list")
    @Expose
    private List<String> list = null;
    @SerializedName("sorted")
    @Expose
    private List<Object> sorted = null;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Object> getSorted() {
        return sorted;
    }

    public void setSorted(List<Object> sorted) {
        this.sorted = sorted;
    }
}
