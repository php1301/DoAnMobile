package com.example.doanmobile;

import android.app.Application;

import com.example.doanmobile.model.ResCampaignSummary;
import com.example.doanmobile.model.ResDeployedCampaigns;
import com.example.doanmobile.model.ResViewProfile;

import java.util.ArrayList;

import dev.pinkroom.walletconnectkit.WalletConnectKit;

public class GlobalVar extends Application {
    public int getMyVar() {
        return myVar;
    }

    public void setMyVar(int myVar) {
        this.myVar = myVar;
    }

    private int myVar = 0;

    public WalletConnectKit getWalletConnectKit() {
        return walletConnectKit;
    }

    public void setWalletConnectKit(WalletConnectKit walletConnectKit) {
        this.walletConnectKit = walletConnectKit;
    }

    private WalletConnectKit walletConnectKit;
    private static GlobalVar instance;

    static {
        instance = new GlobalVar();
    }

    private GlobalVar() {
    }

    public static GlobalVar getInstance() {
        return GlobalVar.instance;
    }

    public ResViewProfile profile;

    public ResDeployedCampaigns listDeployedCampains;

    public ArrayList<ResCampaignSummary> campainSummary = new ArrayList<ResCampaignSummary>();

    public String userid;

    public int position;

    public ResViewProfile getProfile() {
        return profile;
    }

    public void setProfile(ResViewProfile profile) {
        this.profile = profile;
    }

    public ResDeployedCampaigns getListDeployedCampains() {
        return listDeployedCampains;
    }

    public void setListDeployedCampains(ResDeployedCampaigns listDeployedCampains) {
        this.listDeployedCampains = listDeployedCampains;
    }

    public ArrayList<ResCampaignSummary> getCampainSummary() {
        return campainSummary;
    }

    public void setCampainSummary(ArrayList<ResCampaignSummary> campainSummary) {
        this.campainSummary = campainSummary;
    }

    public void addCampainSummary(ResCampaignSummary res) {
        this.campainSummary.add(res);
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
