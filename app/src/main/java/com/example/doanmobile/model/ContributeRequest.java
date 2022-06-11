package com.example.doanmobile.model;

public class ContributeRequest {
    private String walletAddr;
    private String value;
    private String address;

    public void setWalletAddr(String walletAddr) {
        this.walletAddr = walletAddr;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWalletAddr() {
        return walletAddr;
    }

    public String getValue() {
        return value;
    }

    public String getAddress() {
        return address;
    }
}
