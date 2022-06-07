package com.example.doanmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.databinding.ItemActivityBinding;
import com.example.doanmobile.model.Campaign;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ItemCampaignBinding;
import com.example.doanmobile.model.Donor;
import com.example.doanmobile.model.RoadMap;

import java.util.List;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.DonorViewHolder> {

    private List<RoadMap> donorList;
    private Context context;
    ItemActivityBinding binding;

    public DonorAdapter(List<RoadMap> donorList, Context context) {
        this.donorList = donorList;
        this.context = context;
    }

    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_donor, parent, false);

        // Return a new holder instance
        DonorViewHolder viewHolder = new DonorViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DonorViewHolder holder, int position) {
        RoadMap roadMap= donorList.get(position);
        holder.dateRoadmap.setText(roadMap.getDate());
        holder.descriptionRoadmap.setText(roadMap.getDescription());
        holder.nameRoadmap.setText(roadMap.getName());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        // Set item views based on your views and data model

    }

    @Override
    public int getItemCount() {
        return donorList.size();
    }

    public class DonorViewHolder extends RecyclerView.ViewHolder {
        TextView nameRoadmap;
        TextView dateRoadmap;
        TextView descriptionRoadmap;
        public DonorViewHolder(@NonNull View itemView) {
            super(itemView);
            nameRoadmap=(TextView) itemView.findViewById(R.id.name_roadmap);
            dateRoadmap=(TextView) itemView.findViewById(R.id.date_roadmap);
            descriptionRoadmap=(TextView) itemView.findViewById(R.id.description_roadmap);

        }

    }
}
