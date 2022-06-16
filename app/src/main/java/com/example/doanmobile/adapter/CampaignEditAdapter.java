package com.example.doanmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ItemCampaignBinding;
import com.example.doanmobile.model.Activity;
import com.example.doanmobile.model.Campaign;

import java.util.List;

public class CampaignEditAdapter extends RecyclerView.Adapter<CampaignEditAdapter.CampaignEditViewHolder> {

    private List<Campaign> campaignList;
    private Context context;
    ItemCampaignBinding binding;

    public CampaignEditAdapter(List<Campaign> campaignList, Context context) {
        this.campaignList = campaignList;
        this.context = context;
    }

    @NonNull
    @Override
    public CampaignEditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_campaign, parent, false);

        // Return a new holder instance
        CampaignEditViewHolder viewHolder = new CampaignEditViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignEditViewHolder holder, int position) {
        Campaign campaign = campaignList.get(position);


        // Set item views based on your views and data model

    }

    @Override
    public int getItemCount() {
        return campaignList.size();
    }

    public class CampaignEditViewHolder extends RecyclerView.ViewHolder {

        public CampaignEditViewHolder(@NonNull View itemView) {
            super(itemView);

        }

    }
}
