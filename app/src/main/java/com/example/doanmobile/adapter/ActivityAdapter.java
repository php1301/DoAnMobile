package com.example.doanmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ItemCampaignBinding;
import com.example.doanmobile.model.Activity;
import com.example.doanmobile.model.Campaign;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private List<Activity> activitiesList;
    private Context context;
    ItemCampaignBinding binding;

    public ActivityAdapter(List<Activity> activitiesList, Context context) {
        this.activitiesList = activitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_activity, parent, false);

        // Return a new holder instance
        ActivityViewHolder viewHolder = new ActivityViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        Activity activity = activitiesList.get(position);


        // Set item views based on your views and data model

    }

    @Override
    public int getItemCount() {
        return activitiesList.size();
    }

    public class ActivityViewHolder extends RecyclerView.ViewHolder {

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);

        }

    }
}
