package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.adapter.ActivityAdapter;
import com.example.doanmobile.adapter.DonorAdapter;
import com.example.doanmobile.databinding.FragmentCampaignDetailBinding;
import com.example.doanmobile.databinding.FragmentDashboardBinding;
import com.example.doanmobile.databinding.FragmentWalletBinding;
import com.example.doanmobile.model.Activity;
import com.example.doanmobile.model.Donor;

import java.util.ArrayList;

public class WalletFragment extends Fragment {

    FragmentWalletBinding binding;

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWalletBinding.inflate(getLayoutInflater());

        binding.ETHValue.setText(GlobalVar.getInstance().getProfile().getUser().getUser().getFirstName() + " " + GlobalVar.getInstance().getProfile().getUser().getUser().getLastName());
        binding.numberCampaign.setText(GlobalVar.getInstance().getProfile().getUser().getNumberOfCampaigns().toString());
        String td = GlobalVar.getInstance().getProfile().getUser().getTotalDonationReceived().toString();
        if (td.length() > 8)
            td = td.substring(0, 5) + "...";
        binding.totalDonation.setText(td);
        String fr = GlobalVar.getInstance().getProfile().getUser().getFinalizeRate().toString();
        if (fr.length() > 8)
            fr = fr.substring(0, 5) + "%";
        binding.finalizeRate.setText(fr);
        createTestList();

        return binding.getRoot();
    }

    public FragmentWalletBinding createTestList(){

        ActivityAdapter adapter = new ActivityAdapter(GlobalVar.getInstance().getCampainSummary(), getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvActivitiesList.setAdapter(adapter);
        binding.rvActivitiesList.setLayoutManager(linearLayoutManager);

        return binding;
    }
}