package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.Campaign;
import com.example.doanmobile.R;
import com.example.doanmobile.adapter.CampaignAdapter;
import com.example.doanmobile.databinding.ActivityDashboardBinding;
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

//        setSupportActionBar(binding.toolbarDashboard);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        createTestList();


       // setSupportActionBar(binding.toolbarDashboard);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Initialize contacts
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(DashboardFragment.this)
//                        .navigate(R.id.campaign_to_campaigndetail);
//            }
//        });
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

//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.toolbar_search:
//            case R.id.toolbar_notification:
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}