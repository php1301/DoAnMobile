package com.example.doanmobile.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.R;
import com.example.doanmobile.databinding.FragmentCampaignDetailBinding;
import com.example.doanmobile.databinding.FragmentSettingBinding;

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
                Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_loginActivity);
            }
        });

        return binding.getRoot();
   }

}