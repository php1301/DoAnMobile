package com.example.doanmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.R;
import com.example.doanmobile.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import org.walletconnect.Session;
import org.web3j.crypto.Wallet;

import java.util.Arrays;
import java.util.List;

import dev.pinkroom.walletconnectkit.WalletConnectKit;
import dev.pinkroom.walletconnectkit.WalletConnectKitConfig;
import kotlin.Unit;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private WalletConnectKit walletConnectKit;
    ActivityMainBinding binding;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
            case R.id.toolbar_notification:
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}