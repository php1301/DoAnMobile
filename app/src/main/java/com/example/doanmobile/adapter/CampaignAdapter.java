package com.example.doanmobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.Campaign;
import com.example.doanmobile.R;
import com.example.doanmobile.activity.CampaignDetailActivity;
import com.example.doanmobile.databinding.ActivityDashboardBinding;

import java.util.List;

public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder> {

    private List<Campaign> campaignsList;
    private Context context;

    public CampaignAdapter(List<Campaign> campaignsList, Context context) {
        this.campaignsList = campaignsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CampaignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_campaign, parent, false);

        // Return a new holder instance
        CampaignViewHolder viewHolder = new CampaignViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignViewHolder holder, int position) {
        Campaign campaign = campaignsList.get(position);

        // Set item views based on your views and data model

    }

    @Override
    public int getItemCount() {
        return campaignsList.size();
    }

    public class CampaignViewHolder extends RecyclerView.ViewHolder {

        public CampaignViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(itemView, CampaignDetailActivity.class);
//                    startActivity(intent);
                }
            });
        }

    }
}
