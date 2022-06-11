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

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ItemCampaignBinding;
import com.example.doanmobile.model.ResCampaignSummary;
import com.squareup.picasso.Picasso;

import org.web3j.utils.Convert;

import java.util.List;

public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder> {

    private List<ResCampaignSummary> campaignsList;
    private Context context;
    ItemCampaignBinding binding;

    public CampaignAdapter(List<ResCampaignSummary> campaignsList, Context context) {
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull CampaignViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ResCampaignSummary campaign = campaignsList.get(position);
         long gain;
         long target;
         long percent;
        holder.txtvNameOrganization.setText(campaign.getSummary().getManager());

        holder.txtvNameCampaign.setText(campaign.getSummary().getName());
        gain= Long.parseLong(campaign.getSummary().getBalance());
        target= Long.parseLong(campaign.getSummary().getTarget());
        percent=gain*100/target;
        holder.pgbCampaign.setProgress(Math.toIntExact(percent));
        holder.txtvPercentCampaign.setText(String.valueOf(percent)+"%");
        holder.txtvGainEth.setText((  Convert.fromWei(campaign.getSummary().getBalance(), Convert.Unit.ETHER).toString()  ));
        holder.txtvTargetEth.setText("/"+Convert.fromWei(campaign.getSummary().getTarget(), Convert.Unit.ETHER).toString()+" ETH");
        holder.txtvNumdonateCampaign.setText(campaign.getSummary().getApproversCount());
        Picasso.get()
                .load(Uri.parse(campaign.getSummary().getImage()))
                .placeholder(R.drawable.campaignimg)
                .error(R.drawable.campaignimg)
                .into(holder.imgvCampaign);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_campaignDetailFragment);
                GlobalVar.getInstance().setPosition(position);
                Log.e( "onClick: ", String.valueOf(GlobalVar.getInstance().getPosition()));
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
        ImageView imgvCampaign;
        TextView txtvNameCampaign;
        TextView txtvGainEth;
        TextView txtvTargetEth;
        TextView txtvNumdonateCampaign;
        TextView txtvPercentCampaign;
        ProgressBar pgbCampaign;
        public CampaignViewHolder(@NonNull View itemView) {
            super(itemView);
            txtvNameOrganization = (TextView) itemView.findViewById(R.id.txtv_name_organization);
            imgvCampaign = (ImageView) itemView.findViewById(R.id.imgv_img_campaign);
            txtvNameCampaign = (TextView) itemView.findViewById(R.id.txtv_name_campaign);
            txtvGainEth=(TextView) itemView.findViewById(R.id.txtv_gain_eth);
            txtvTargetEth= (TextView) itemView.findViewById(R.id.txtv_target_eth);
            txtvNumdonateCampaign= (TextView) itemView.findViewById(R.id.txtv_numdonate_campaign);
            txtvPercentCampaign= (TextView) itemView.findViewById(R.id.txtv_percent_campaign);
            pgbCampaign= (ProgressBar) itemView.findViewById(R.id.pgb_campaign);
        }

    }
}
