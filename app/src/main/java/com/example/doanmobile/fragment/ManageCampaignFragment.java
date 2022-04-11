package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.R;

import com.example.doanmobile.databinding.FragmentManageCampaignBinding;

public class ManageCampaignFragment extends Fragment {

    FragmentManageCampaignBinding binding;

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
                Navigation.findNavController(view).navigate(R.id.action_manageCampaignFragment_to_createCampaignFragment);
            }
        });

        return binding.getRoot();
    }
}