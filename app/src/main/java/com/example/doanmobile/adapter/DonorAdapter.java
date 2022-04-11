package com.example.doanmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.databinding.ItemActivityBinding;
import com.example.doanmobile.model.Campaign;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ItemCampaignBinding;
import com.example.doanmobile.model.Donor;

import java.util.List;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.DonorViewHolder> {

    private List<Donor> donorList;
    private Context context;
    ItemActivityBinding binding;

    public DonorAdapter(List<Donor> donorList, Context context) {
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
        Donor donor= donorList.get(position);

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

        public DonorViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

    }
}
