package com.example.doanmobile.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ItemCampaignBinding;
import com.example.doanmobile.model.Activity;
import com.example.doanmobile.model.Campaign;
import com.example.doanmobile.model.ResCampaignSummary;

import org.web3j.utils.Convert;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActViewHolder> {

    private List<ResCampaignSummary> activitiesList;
    private Context context;
    ItemCampaignBinding binding;

    public ActivityAdapter(List<ResCampaignSummary> activitiesList, Context context) {
        this.activitiesList = activitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ActViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_activity, parent, false);

        // Return a new holder instance
        ActViewHolder viewHolder = new ActViewHolder(contactView);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ActViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ResCampaignSummary activity = activitiesList.get(position);
        String t = "";
        if (activity.getSummary().getName().length() > 11)
            t = activity.getSummary().getName().substring(0, 8) + "...";
        else
            t = activity.getSummary().getName();
        holder.txtAddress.setText(t);
        holder.txtDate.setText("");
        holder.txtValue.setText(Convert.fromWei(activity.getSummary().getBalance(), Convert.Unit.ETHER).toString() + "/"+Convert.fromWei(activity.getSummary().getTarget(), Convert.Unit.ETHER).toString()+" ETH");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_walletFragment_to_campaignDetailFragment);
                GlobalVar.getInstance().setPosition(position);
            }
        });
        // Set item views based on your views and data model

    }

    @Override
    public int getItemCount() {
        return activitiesList.size();
    }


    public class ActViewHolder extends RecyclerView.ViewHolder {

        TextView txtAddress;
        TextView txtDate;
        TextView txtValue;
        CardView card;

        public ActViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAddress = (TextView) itemView.findViewById(R.id.name_activity1);
            txtDate = (TextView) itemView.findViewById(R.id.time_activity1);
            txtValue = (TextView) itemView.findViewById(R.id.txt_activity_money);
            card = (CardView) itemView.findViewById(R.id.Act_bg);
        }

    }
}
