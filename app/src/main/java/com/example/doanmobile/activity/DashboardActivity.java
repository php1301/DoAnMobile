package com.example.doanmobile.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.doanmobile.Campaign;
import com.example.doanmobile.R;
import com.example.doanmobile.adapter.CampaignAdapter;
import com.example.doanmobile.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    AppBarConfiguration appBarConfiguration;
    ArrayList<Campaign> campaignsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //setSupportActionBar(binding.toolbarDashboard);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Initialize contacts
//        Campaign campaign = new Campaign("abc");
//        campaignsList = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++)
//            campaignsList.add(campaign);
//        // Create adapter passing in the sample user data
//           CampaignAdapter adapter = new CampaignAdapter(campaignsList, );
//        // Attach the adapter to the recyclerview to populate items
//           binding.rvCampaign.setAdapter(adapter);
//        // Set layout manager to position the items
//           binding.rvCampaign.setLayoutManager(new LinearLayoutManager(this));
//        // That's all!
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.toolbar_search:
//            case R.id.toolbar_notification:
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


}