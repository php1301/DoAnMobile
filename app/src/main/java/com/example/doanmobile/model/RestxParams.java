package com.example.doanmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestxParams {

    @SerializedName("txParams")
    @Expose
    private TxParams txParams;

    public TxParams getTxParams() {
        return txParams;
    }

    public void setTxParams(TxParams txParams) {
        this.txParams = txParams;
    }
}
