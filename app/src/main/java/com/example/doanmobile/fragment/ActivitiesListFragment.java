package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.R;
import com.example.doanmobile.adapter.ActivityAdapter;
import com.example.doanmobile.adapter.DonorAdapter;
import com.example.doanmobile.databinding.FragmentActivitiesListBinding;
import com.example.doanmobile.databinding.FragmentDonorsListBinding;
import com.example.doanmobile.model.Activity;
import com.example.doanmobile.model.Donor;

import java.util.ArrayList;

public class ActivitiesListFragment extends Fragment {

    FragmentActivitiesListBinding binding;

    public ActivitiesListFragment() {
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
        binding = FragmentActivitiesListBinding.inflate(getLayoutInflater());

        createTestList();

        return binding.getRoot();
    }

    public FragmentActivitiesListBinding createTestList(){
        Activity activity = new Activity(5);
        ArrayList<Activity> activitiesList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            activitiesList.add(activity);

        ActivityAdapter adapter = new ActivityAdapter(activitiesList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvActivitiesList.setAdapter(adapter);
        binding.rvActivitiesList.setLayoutManager(linearLayoutManager);

        return binding;
    }
}