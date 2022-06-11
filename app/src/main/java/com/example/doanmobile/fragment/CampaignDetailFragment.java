package com.example.doanmobile.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.transition.ChangeBounds;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanmobile.Api;
import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.RetrofitClient;
import com.example.doanmobile.adapter.DonorAdapter;
import com.example.doanmobile.databinding.FragmentCampaignDetailBinding;
import com.example.doanmobile.model.ResDeployedCampaigns;
import com.squareup.picasso.Picasso;

import org.walletconnect.Session;
import org.web3j.utils.Convert;

import dev.pinkroom.walletconnectkit.WalletConnectKit;
import kotlin.Unit;
import retrofit2.Call;
import retrofit2.Callback;

public class CampaignDetailFragment extends Fragment {

    FragmentCampaignDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCampaignDetailBinding.inflate(getLayoutInflater());
         long gain;
         long target;
         long percent;
        gain= Long.parseLong(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getBalance());
        target=Long.parseLong(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getTarget());
        percent=gain*100/target;
        Log.e( "percent: ", String.valueOf(percent));
        binding.pgbCampaign.setProgress(Math.toIntExact(percent));
        binding.txtvInfo.setText(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getDescription());
        Picasso.get().load(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getImage()).placeholder(R.drawable.campaignimg).into(binding.imgvImgCampaign);
        binding.txtvGainEth.setText(Convert.fromWei(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getBalance(),Convert.Unit.ETHER).toString());
        binding.txtvNameOrganization.setText(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getManager());
        binding.txtvTargetEth.setText("/"+Convert.fromWei(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getTarget(),Convert.Unit.ETHER).toString()+" ETH");
        binding.txtvNumdonateCampaign.setText(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getApproversCount());
        binding.txtvPercentCampaign.setText(String.valueOf(percent)+"%");
        binding.txtvNameCampaign.setText(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getName());
        binding.btnWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WalletConnectKit walletConnectKit = GlobalVar.getInstance().getWalletConnectKit();
                String url = "https://metamask.app.link/dapp/https://d99d-113-177-113-239.ngrok.io/"+ GlobalVar.getInstance().getListDeployedCampains().getList().get(GlobalVar.getInstance().getPosition())+"/withdrawal";
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                startActivity(intent1);
            }
        });
        setSharedElementEnterTransition(new ChangeBounds());

        createTestList();

        binding.btndonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.action_campaignDetailFragment_to_donateFragment);
                WalletConnectKit walletConnectKit = GlobalVar.getInstance().getWalletConnectKit();
                String url = "https://metamask.app.link/dapp/https://blockchain-charity.vercel.app/campaign/"+ GlobalVar.getInstance().getListDeployedCampains().getList().get(GlobalVar.getInstance().getPosition());
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                startActivity(intent1);
            }
        });

        return binding.getRoot();

        //return inflater.inflate(R.layout.fragment_campaign_detail, container, false);
    }

    public FragmentCampaignDetailBinding createTestList(){
//        Donor donor = new Donor("abc");
//        ArrayList<Donor> donorsList = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++)
//            donorsList.add(donor);

        DonorAdapter adapter = new DonorAdapter(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getRoadmap(), getContext());
        Log.e( "roadmap: ", String.valueOf(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getRoadmap().size()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvDonorsList.setAdapter(adapter);
        binding.rvDonorsList.setLayoutManager(linearLayoutManager);

        return binding;
    }
}