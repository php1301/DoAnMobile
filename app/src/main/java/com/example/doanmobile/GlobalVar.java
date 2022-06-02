package com.example.doanmobile;

import android.app.Application;

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
    }}
