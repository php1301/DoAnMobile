package com.example.doanmobile.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.R;
import com.example.doanmobile.adapter.DonorAdapter;
import com.example.doanmobile.databinding.FragmentCampaignDetailBinding;
import com.example.doanmobile.databinding.FragmentDashboardBinding;
import com.example.doanmobile.databinding.FragmentDonorsListBinding;
import com.example.doanmobile.model.Donor;

import java.util.ArrayList;

public class CampaignDetailFragment extends Fragment {

    FragmentCampaignDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCampaignDetailBinding.inflate(getLayoutInflater());

        createTestList();

        binding.btndonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_campaignDetailFragment_to_donateFragment);
            }
        });

        binding.btnInfoViewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_campaignDetailFragment_to_pathCampaignFragment);
            }
        });

        binding.btnDonorsViewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_campaignDetailFragment_to_donorsListFragment);
            }
        });
        return binding.getRoot();

        //return inflater.inflate(R.layout.fragment_campaign_detail, container, false);
    }

    public FragmentCampaignDetailBinding createTestList(){
        Donor donor = new Donor("abc");
        ArrayList<Donor> donorsList = new ArrayList<>();

        for (int i = 0; i < 3; i++)
            donorsList.add(donor);
        DonorAdapter adapter = new DonorAdapter(donorsList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvDonorsList.setAdapter(adapter);
        binding.rvDonorsList.setLayoutManager(linearLayoutManager);

        return binding;
    }
}