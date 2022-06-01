package com.example.doanmobile;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
}
