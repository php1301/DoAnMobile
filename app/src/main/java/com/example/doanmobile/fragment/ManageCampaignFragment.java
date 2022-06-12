package com.example.doanmobile.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;

import com.example.doanmobile.adapter.CampaignAdapter;
import com.example.doanmobile.adapter.CampaignEditAdapter;
import com.example.doanmobile.databinding.FragmentDashboardBinding;
import com.example.doanmobile.databinding.FragmentManageCampaignBinding;
import com.example.doanmobile.databinding.FragmentSettingBinding;
import com.example.doanmobile.model.Campaign;

import java.util.ArrayList;

import dev.pinkroom.walletconnectkit.WalletConnectKit;

public class ManageCampaignFragment extends Fragment {

    FragmentManageCampaignBinding binding;
    ArrayList<Campaign> campaignsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentManageCampaignBinding.inflate(getLayoutInflater());
        binding.btnCreateCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WalletConnectKit walletConnectKit = GlobalVar.getInstance().getWalletConnectKit();
                String url = "https://metamask.app.link/dapp/https://blockchain-charity.vercel.app/campaign/new";
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                startActivity(intent1);
            }
        });

        createTestList();

        return binding.getRoot();
    }

    public FragmentManageCampaignBinding createTestList(){
//        Campaign campaign = new Campaign("abc");
//        campaignsList = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++)
//            campaignsList.add(campaign);
//        CampaignEditAdapter adapter = new CampaignEditAdapter(campaignsList, getContext());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        binding.rvCampaign.setAdapter(adapter);
//        binding.rvCampaign.setLayoutManager(linearLayoutManager);
        // That's all!
        return binding;
    }
}