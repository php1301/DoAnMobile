//package com.example.doanmobile.adapter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.core.app.ActivityOptionsCompat;
//import androidx.core.view.ViewCompat;
//import androidx.navigation.Navigation;
//import androidx.navigation.Navigator;
//import androidx.navigation.fragment.FragmentNavigator;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.doanmobile.databinding.FragmentCampaignDetailBinding;
//import com.example.doanmobile.fragment.DashboardFragment;
//import com.example.doanmobile.model.Campaign;
//import com.example.doanmobile.R;
//import com.example.doanmobile.databinding.ItemCampaignBinding;
//
//import java.util.List;
//
//public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder> {
//
//    private List<Campaign> campaignsList;
//    private Context context;
//
//    public CampaignAdapter(List<Campaign> campaignsList, Context context) {
//        this.campaignsList = campaignsList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public CampaignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        return new CampaignAdapter.CampaignViewHolder(
//                ItemCampaignBinding.inflate(LayoutInflater.from(context)));
//
////        LayoutInflater inflater = LayoutInflater.from(context);
////
////        // Inflate the custom layout
////        View contactView = ItemCampaignBinding.inflater.inflate(R.layout.item_campaign, parent, false);
////
////        // Return a new holder instance
////        CampaignViewHolder viewHolder = new CampaignViewHolder(contactView);
////        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CampaignViewHolder holder, int position) {
//        Campaign campaign = campaignsList.get(position);
//
//        holder.binding.cardview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////   params = (LinearLayout.LayoutParams) llayout.getLayoutParams();
//
//                FragmentNavigator.Extras extras =  new FragmentNavigator.Extras.Builder()
//                        .addSharedElement(holder.binding.imgvImgCampaign, "anim_campaign")
//                        .build();
//                //holder.txtName(listdata[position].getDescription());
//
////                Navigation.findNavController(view).navigate(
////                        R.id.action_dashboardFragment_to_campaignDetailFragment,
////                        null,
////                        null, extras);
//
//
//                Navigation.findNavController(view).navigate(
//                        R.id.action_dashboardFragment_to_campaignDetailFragment);
//
//            }
//        });
//        // Set item views based on your views and data model
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return campaignsList.size();
//    }
//
//    public class CampaignViewHolder extends RecyclerView.ViewHolder {
//
//        private ItemCampaignBinding binding;
//
//        public CampaignViewHolder(ItemCampaignBinding itemView) {
//            super(itemView.getRoot());
//            binding = itemView;
//        }
//
//    }
//}

package com.example.doanmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.fragment.DashboardFragment;
import com.example.doanmobile.model.Campaign;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ItemCampaignBinding;

import java.util.List;

public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder> {

    private List<Campaign> campaignsList;
    private Context context;
    ItemCampaignBinding binding;

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

        holder.txtvNameOrganization.setText(campaignsList.get(position).getOrganizationName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_campaignDetailFragment);
            }
        });
        // Set item views based on your views and data model

    }

    @Override
    public int getItemCount() {
        return campaignsList.size();
    }

    public class CampaignViewHolder extends RecyclerView.ViewHolder {

        TextView txtvNameOrganization;

        public CampaignViewHolder(@NonNull View itemView) {
            super(itemView);
            txtvNameOrganization = (TextView) itemView.findViewById(R.id.txtv_name_organization);
        }

    }
}
