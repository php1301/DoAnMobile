package com.example.doanmobile.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.FragmentCampaignDetailBinding;
import com.example.doanmobile.databinding.FragmentSettingBinding;

import org.walletconnect.Session;

import dev.pinkroom.walletconnectkit.WalletConnectKit;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public class SettingFragment extends Fragment {

    FragmentSettingBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(getLayoutInflater());

        binding.cardviewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WalletConnectKit walletConnectKit = GlobalVar.getInstance().getWalletConnectKit();
//                walletConnectKit.removeSession();
//                Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_loginActivity);

//                System.out.println(walletConnectKit.getSession());
//                String data = "0xcd7a489e00000000000000000000000000000000000000000000000000038d7ea4c6800000000000000000000000000000000000000000000000000000000000000000e00000000000000000000000000000000000000000000000000000000000000120000000000000000000000000000000000000000000000000000000000000016000000000000000000000000000000000000000000000000000000000000001a000000000000000000000000000000000000000000000000000000000000001e0000000000000000000000000000000000000000000000000002386f26fc10000000000000000000000000000000000000000000000000000000000000000000b546573742061626364656600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000036767670000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002068747470733a2f2f692e696d6775722e636f6d2f79723274597a6f2e6a7065670000000000000000000000000000000000000000000000000000000000000018323032322d30362d30325430323a32383a35312e3337315a00000000000000000000000000000000000000000000000000000000000000000000000000000018323032322d30362d30325430323a32383a35312e3337315a0000000000000000";
//walletConnectKit.getSession().performMethodCall(new Session
//                        .MethodCall
//                        .SendTransaction(System.currentTimeMillis(), "0x4ddFf5E113FF403f193503c280DDf7723E53Ca11", "0xE124cEE21A6DE685D24AaC6487CC9AAB07350A38", "abc", "0x8a8c7838", "0x2b89ee", "0x0", data),
//                        response -> {
//                    System.out.println(response.getError().getMessage());
//
//                    return Unit.INSTANCE;
//                });
//                walletConnectKit.openWallet();


            }
        });

        return binding.getRoot();
   }

}