package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.adapter.CampaignAdapter;
import com.example.doanmobile.adapter.DonorAdapter;
import com.example.doanmobile.databinding.FragmentDonorsListBinding;
import com.example.doanmobile.model.Donor;

import java.util.ArrayList;

public class DonorsListFragment extends Fragment {

    FragmentDonorsListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDonorsListBinding.inflate(getLayoutInflater());

//        final String arr[] = {"Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin",
//                "Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, arr);
//        binding.rvDonorsList.setAdapter(adapter);
//
        createTestList();
        return binding.getRoot();

    }

    public FragmentDonorsListBinding createTestList(){
        Donor donor = new Donor("abc");
        ArrayList<Donor> donorsList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            donorsList.add(donor);

        DonorAdapter adapter = new DonorAdapter(donorsList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvDonorsList.setAdapter(adapter);
        binding.rvDonorsList.setLayoutManager(linearLayoutManager);

        return binding;
    }
}