package com.example.doanmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.doanmobile.Api;
import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.LoadingDialog;
import com.example.doanmobile.R;
import com.example.doanmobile.RetrofitClient;
import com.example.doanmobile.databinding.ActivityMainBinding;
import com.example.doanmobile.model.ResCampaignSummary;
import com.example.doanmobile.model.ResDeployedCampaigns;
import com.example.doanmobile.model.ResViewProfile;
import com.google.gson.Gson;

import org.walletconnect.Session;
import org.web3j.crypto.Wallet;


import java.util.Arrays;
import java.util.List;

import dev.pinkroom.walletconnectkit.WalletConnectKit;
import dev.pinkroom.walletconnectkit.WalletConnectKitConfig;
import kotlin.Unit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private WalletConnectKit walletConnectKit;
    ActivityMainBinding binding;
    LoadingDialog loadingDialog;
    private int temp;
    private String sort="new";
    private String address="0xa5b0B408D996627C0264a34080CD4CA397a66D5E";
    private String uid="0x4ddFf5E113FF403f193503c280DDf7723E53Ca11";
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setSupportActionBar(binding.toolbarDashboard);

        createTopToolbar();

        bottomNavChangeFragment();
        List<String> list = Arrays.asList("haha");

        WalletConnectKitConfig config = new WalletConnectKitConfig(
                MainActivity.this,
                "https://bridge.walletconnect.org",
                "https://betterfund.vercel.app/",
                "WalletConnectKit",
                "abc",
                list
        );

        getProfile(uid);
        loadingDialog = new LoadingDialog(this);
    //    getProfile(GlobalVar.getInstance().getUserid());
        getDeployedCampaign(sort);

//        getProfile(uid);
//        getDeployedCampaign(sort);
//        getCampaignsummary(address);

    }

    protected void bottomNavChangeFragment(){
        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_bottom_nav_container);
        final NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNav, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_bottom_nav_container);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    protected void createTopToolbar(){
        appBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.dashboardFragment,
                        R.id.walletFragment,
                        R.id.manageCampaignFragment,
                        R.id.accountFragment,
                        R.id.settingFragment)
                        .build();

        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_bottom_nav_container);
        final NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//         Handle item selection
        switch (item.getItemId()) {
            case R.id.toolbar_search:
                Toast.makeText(MainActivity.this, "Thank You For Using Our App", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            case R.id.toolbar_notification:
                Uri uri = Uri.parse("https://github.com/php1301/DoAnMobile");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getDeployedCampaign(String sort){
        loadingDialog.showDialog("Loading...");
        Api api = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<ResDeployedCampaigns> call=api.getDeployedCampaign(sort);
        call.enqueue(new Callback<ResDeployedCampaigns>() {
            @Override
            public void onResponse(Call<ResDeployedCampaigns> call, Response<ResDeployedCampaigns> response) {
                if (response.isSuccessful()) {
                    GlobalVar.getInstance().setListDeployedCampains((ResDeployedCampaigns) response.body());
                    temp = 0;
                    ResDeployedCampaigns list = GlobalVar.getInstance().getListDeployedCampains();
                    int size = list.getList().size();
                    if (size == 0)
                    {
                        loadingDialog.HideDialog();
                        setContentView(binding.getRoot());
                        final SwipeRefreshLayout pullToRefresh = findViewById(R.id.swipeRefreshLayout);
                        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                            @Override
                            public void onRefresh() {
                                System.out.println("request pull to refresh at dashboard");
                                getDeployedCampaign(sort);
                                pullToRefresh.setRefreshing(false);
                            }
                        });

                    }
                    else {
                        for (String l:list.getList()) {
                            getCampaignsummary(l, size);
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ResDeployedCampaigns> call, Throwable t) {
                Log.e("onFailure: ",t.getMessage() );
            }
        });
    }
    public void getCampaignsummary(String address, int t){
        Api api = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<ResCampaignSummary> call=api.getCampaignsummary(address);
        call.enqueue(new Callback<ResCampaignSummary>() {
            @Override
            public void onResponse(Call<ResCampaignSummary> call, Response<ResCampaignSummary> response) {
                if (response.isSuccessful()) {
                    GlobalVar.getInstance().addCampainSummary((ResCampaignSummary) response.body());
                    GlobalVar.getInstance().addClickedAddress(address);
                    temp++;
                    if (temp == t) {
                        loadingDialog.HideDialog();
                        setContentView(binding.getRoot());
                        final SwipeRefreshLayout pullToRefresh = findViewById(R.id.swipeRefreshLayout);
                        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                            @Override
                            public void onRefresh() {
                                System.out.println("request pull to refresh at dashboard");
                                getDeployedCampaign(sort);
                                pullToRefresh.setRefreshing(false);
                            }
                        });
                    }
                }

            }

            @Override
            public void onFailure(Call<ResCampaignSummary> call, Throwable t) {
                Log.e("onFailure: ",t.getMessage() );
            }
        });
    }
    public void getProfile(String uid){
        Api api = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<ResViewProfile> call=api.getProfile(uid);
        call.enqueue(new Callback<ResViewProfile>() {
            @Override
            public void onResponse(Call<ResViewProfile> call, Response<ResViewProfile> response) {
                if (response.isSuccessful()) {
                    GlobalVar.getInstance().setProfile((ResViewProfile) response.body());
                }
            }

            @Override
            public void onFailure(Call<ResViewProfile> call, Throwable t) {
                Log.e("onFailure: ",t.getMessage() );
            }
        });
    }

}