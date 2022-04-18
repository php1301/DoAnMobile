package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        binding.txtvViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_walletFragment_to_activitiesListFragment);
            }
        });

        createTestList();

        return binding.getRoot();
    }

    public FragmentWalletBinding createTestList(){
        Activity activity = new Activity(5);
        ArrayList<Activity> activitiesList = new ArrayList<>();

        for (int i = 0; i < 3; i++)
            activitiesList.add(activity);
        ActivityAdapter adapter = new ActivityAdapter(activitiesList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvActivitiesList.setAdapter(adapter);
        binding.rvActivitiesList.setLayoutManager(linearLayoutManager);

        return binding;
    }
}