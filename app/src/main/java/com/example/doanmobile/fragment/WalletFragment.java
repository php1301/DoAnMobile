package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.R;
import com.example.doanmobile.databinding.FragmentDashboardBinding;
import com.example.doanmobile.databinding.FragmentWalletBinding;

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

        return binding.getRoot();
    }
}