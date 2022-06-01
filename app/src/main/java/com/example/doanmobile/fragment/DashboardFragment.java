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

        campaignsList = new ArrayList<>();

        campaignsList.add( new Campaign("AntiCOVID", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrEejUt9id9JnFZyvW8rUJDQ0jVKmPtkJHuMbLV4i4ydP0fAMDkiWx__Dd4MuGawEdEaA&usqp=CAU"));
        campaignsList.add( new Campaign("Global Forest", "https://en.baoquocte.vn/stores/news_dataimages/lananh/032022/04/11/in_article/adb-ho-tro-15-trieu-usd-phat-trien-lam-nghiep-ben-vung-o-dong-nam-a.jpg?rt=20220304145227"));
        campaignsList.add( new Campaign("ChildFund", "https://media.globalcitizen.org/thumbnails/9b/bd/9bbd86a1-4827-4243-b033-dcbd2e7fe5a5/nedbankchildprotectionandsafety.jpg__1600x900_q85_crop_subsampling-2.jpg"));

        CampaignAdapter adapter = new CampaignAdapter(campaignsList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvCampaign.setAdapter(adapter);
        binding.rvCampaign.setLayoutManager(linearLayoutManager);
        // That's all!
        return binding;
    }

}