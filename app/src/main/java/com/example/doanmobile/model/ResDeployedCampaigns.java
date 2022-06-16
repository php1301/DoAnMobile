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
    private List<String> sorted = null;


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getSorted() {
        return sorted;
    }

    public void setSorted(List<String> sorted) {

          this.sorted = sorted;
    }
}
