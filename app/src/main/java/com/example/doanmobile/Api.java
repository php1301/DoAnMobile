package com.example.doanmobile;

import com.example.doanmobile.model.ResCampaignSummary;
import com.example.doanmobile.model.ResDeployedCampaigns;
import com.example.doanmobile.model.ResViewProfile;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "";

    @FormUrlEncoded
    @POST("/dev/auth/nonce")
    Call<Object> nonceapi (
            @Field("walletAddr") String walletAddr);

    @FormUrlEncoded
    @POST("/dev/auth/wallet")
    Call<Object> walletapi (
            @Field("walletAddr") String walletAddr,
            @Field("signature") String signature,
            @Field("nonce") String nonce);

    @FormUrlEncoded
    @POST("/dev/auth/login")
    Call<Object> login (
            @Field("walletAddr") String walletAddr);

    @GET("/dev/campaigns/get-deployed-campaigns/{sort}")
    Call<ResDeployedCampaigns> getDeployedCampaign(@Path("sort") String sort);

    @GET("/dev/campaigns/get-campaign-summary/{address}")
    Call<ResCampaignSummary> getCampaignsummary(@Path("address") String address);

    @GET("/dev/users/view-profile/{uid}")
    Call<ResViewProfile> getProfile(@Path("uid") String uid);
}
