package com.example.doanmobile.fragment;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;
import java.util.UUID;

import com.example.doanmobile.Api;
import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.RetrofitClient;
import com.example.doanmobile.activity.MainActivity;
import com.example.doanmobile.databinding.FragmentCampaignDetailBinding;
import com.example.doanmobile.databinding.FragmentDashboardBinding;
import com.example.doanmobile.databinding.FragmentDonateBinding;
import com.example.doanmobile.model.ContributeRequest;
import com.example.doanmobile.model.ResDeployedCampaigns;
import com.example.doanmobile.model.RestxParams;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.walletconnect.Session;
import org.web3j.utils.Convert;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.*;
import java.util.Date;

import dev.pinkroom.walletconnectkit.WalletConnectKit;
import kotlin.Unit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonateFragment extends Fragment {
    FragmentDonateBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         long gain;
         long target;
         long percent;
        binding = FragmentDonateBinding.inflate(getLayoutInflater());
        gain= Long.parseLong(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getBalance());
        target=Long.parseLong(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getTarget());
        percent=gain*100/target;
        binding.textViewCurrentBalance.setText(Convert.fromWei(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getBalance(),Convert.Unit.ETHER).toString()+" ETH");
        binding.textTargetBalance.setText("Target of "+Convert.fromWei(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getTarget(),Convert.Unit.ETHER).toString()+" ETH");
        binding.pgbCampaign.setProgress(Math.toIntExact(percent));
        binding.yourWalletAdress.setText(GlobalVar.getInstance().getUserid());
        binding.walletAdressOfCamCrea.setText(GlobalVar.getInstance().listDeployedCampains.getList().get(GlobalVar.getInstance().getPosition()).toString());
        binding.btndonate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.parseDouble(binding.InputTargetAmount.getText().toString())>=Double.parseDouble(Convert.fromWei(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getMinimumContribution(),Convert.Unit.ETHER).toString())){
                    ContributeRequest cr = new ContributeRequest();
                    cr.setWalletAddr(GlobalVar.getInstance().getUserid());
                    cr.setValue(binding.InputTargetAmount.getText().toString());
                    cr.setAddress(binding.walletAdressOfCamCrea.getText().toString());
                    Api api = RetrofitClient.getRetrofitInstance().create(Api.class);
                    Call<RestxParams> call = api.contributeCampaign(cr);
                    call.enqueue(new Callback<RestxParams>() {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void onResponse(Call<RestxParams> call, Response<RestxParams> response) {
                            if (response.isSuccessful()) {

                                RestxParams res = (RestxParams) response.body();
                                System.out.println(res.getTxParams().getTo());
                                WalletConnectKit walletConnectKit = GlobalVar.getInstance().getWalletConnectKit();
                                System.out.println(walletConnectKit.getSession());
                                walletConnectKit.getSession().performMethodCall(new Session
                                                .MethodCall
                                                .SendTransaction(System.currentTimeMillis(), res.getTxParams().getFrom(), res.getTxParams().getTo(),"qwer", res.getTxParams().getGasPrice(), res.getTxParams().getGas(), res.getTxParams().getValue(), res.getTxParams().getData()),
                                        response1 -> {

                                            System.out.println(response1.getError().getMessage());
                                            System.out.println(response1.getResult());
                                            System.out.println(response1.getId());

                                            if (response1.getError() != null)
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(getActivity().getApplicationContext(), response1.getError().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            return Unit.INSTANCE;
                                        });
                                walletConnectKit.openWallet();
                            }
                        }
                        //                    .SendTransaction(System.currentTimeMillis(), res.getTxParams().getFrom(), res.getTxParams().getTo(), res.getTxParams().getData(), res.getTxParams().getGasPrice(),thiếu cái nonce , res.getTxParams().getValue(), res.getTxParams().getData()),
//                    res
//                    SendTransaction(System.currentTimeMillis(), "0x4ddFf5E113FF403f193503c280DDf7723E53Ca11", "0xE124cEE21A6DE685D24AaC6487CC9AAB07350A38", "abc", "0x8a8c7838", "0x2b89ee", "0x0", data),
//                    res
                        @Override
                        public void onFailure(Call<RestxParams> call, Throwable t) {
                            Log.e("onFailure: ",t.getMessage() );
                        }
                    });
                }else{
                    AlertDialog alertDialog = new
                            AlertDialog.Builder(getActivity()).create();
                    alertDialog.setTitle("Thông báo lỗi" );
                    alertDialog.setMessage("Giá trị bạn nhập phải lớn hơn "+Convert.fromWei(GlobalVar.getInstance().getCampainSummary().get(GlobalVar.getInstance().getPosition()).getSummary().getMinimumContribution(),Convert.Unit.ETHER).toString() +" ETH");
                    alertDialog.setIcon(R.mipmap.ic_launcher);
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getActivity(), "Mời bạn nhập lại ETH",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    alertDialog.show();
                }

            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_donate, container, false);


    }

}