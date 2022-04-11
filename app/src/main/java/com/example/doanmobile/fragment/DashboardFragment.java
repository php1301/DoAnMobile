package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.model.Campaign;
import com.example.doanmobile.adapter.CampaignAdapter;
import com.example.doanmobile.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    FragmentDashboardBinding binding;
    ArrayList<Campaign> campaignsList;

    public DashboardFragment() {
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
        binding = FragmentDashboardBinding.inflate(getLayoutInflater());

        createTestList();

        // Initialize contacts
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public FragmentDashboardBinding createTestList(){
        Campaign campaign = new Campaign("abc");
        campaignsList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            campaignsList.add(campaign);
        CampaignAdapter adapter = new CampaignAdapter(campaignsList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvCampaign.setAdapter(adapter);
        binding.rvCampaign.setLayoutManager(linearLayoutManager);
        // That's all!
        return binding;
    }

}