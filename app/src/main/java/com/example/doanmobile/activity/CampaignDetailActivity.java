package com.example.doanmobile.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmobile.databinding.ActivityCampaignDetailBinding;

public class CampaignDetailActivity extends AppCompatActivity {

    ActivityCampaignDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCampaignDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarCampaignDetail);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

}