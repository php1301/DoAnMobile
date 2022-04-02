package com.example.doanmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout);


        Button truonghop1 = (Button) findViewById(R.id.button);
        truonghop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Truonghop = new Intent(SearchActivity.this, DonorsListActivity.class);
                startActivity(Truonghop);
            }
        });

        Button truonghop2 = (Button) findViewById(R.id.button1);
        truonghop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Truonghop = new Intent(SearchActivity.this, DonateActivity.class);
                startActivity(Truonghop);
            }
        });

        Button truonghop3 = (Button) findViewById(R.id.button2);
        truonghop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Truonghop = new Intent(SearchActivity.this, PathOfCampaignActivity.class);
                startActivity(Truonghop);
            }
        });

    }



}