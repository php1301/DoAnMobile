package com.example.doanmobile.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ActivityLoginBinding;
import com.example.doanmobile.databinding.ActivityMainBinding;
import com.example.doanmobile.fragment.DashboardFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    Session session;
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
        walletConnectKit.removeSession();
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {




                    binding.btnLogin.start(walletConnectKit, address -> {
                        session = walletConnectKit.getSession();
                        walletConnectKit.setSession(session);
                        System.out.println("You are connected with account: " + address);
                        GlobalVar.getInstance().setWalletConnectKit(walletConnectKit);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        return Unit.INSTANCE;
                    });

                }catch(Exception e){
                    System.out.println(e.toString());
                }
            }
        });
    }
}