package com.example.doanmobile.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ActivityLoginBinding;
import com.example.doanmobile.databinding.ActivityMainBinding;
import com.example.doanmobile.fragment.DashboardFragment;

import org.walletconnect.Session;
import org.web3j.abi.datatypes.Uint;

import java.util.Arrays;
import java.util.List;

import dev.pinkroom.walletconnectkit.WalletConnectKit;
import dev.pinkroom.walletconnectkit.WalletConnectKitConfig;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public class LoginActivity extends AppCompatActivity implements Session.Callback {

    ActivityLoginBinding binding;
    WalletConnectKit walletConnectKit;
    @Override
    public void onStatus(Session.Status status){

    }

    @Override
    public void onMethodCall(Session.MethodCall methodCall){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        setTheme(R.style.Theme_DoAnMobile);
        Log.d("STATE", "abc");
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
                List<String> list = Arrays.asList("haha");

                WalletConnectKitConfig config = new WalletConnectKitConfig(
                        LoginActivity.this,
                        "https://bridge.walletconnect.org",
                         "https://betterfund.vercel.app/",
                        "WalletConnectKit",
                        "abc",
                        list
                );

                walletConnectKit = new WalletConnectKit.Builder(config).build();
                    binding.btnLogin.start(walletConnectKit, address -> {
                        System.out.println("You are connected with account: " + address);
                        return Unit.INSTANCE;
                    });
                walletConnectKit.loadSession(new Session.Callback() {
                    @Override
                    public void onStatus(@NonNull Session.Status status) {

                    }

                    @Override
                    public void onMethodCall(@NonNull Session.MethodCall methodCall) {

                    }
                });
                walletConnectKit.personalSign("123", new Continuation<Session.MethodCall.Response>() {
                    @NonNull
                    @Override
                    public CoroutineContext getContext() {
                        return EmptyCoroutineContext.INSTANCE;
                    }

                    @Override
                    public void resumeWith(@NonNull Object o) {
                        System.out.println(o.toString());
                    }
                });
            }
        });
    }
}