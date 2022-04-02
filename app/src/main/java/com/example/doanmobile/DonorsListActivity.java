package com.example.doanmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DonorsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donors_list);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout_donorslist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        final String arr[] = {"Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin",
//                "Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo","Teo", "Ty", "Bin", "Bo"};
//        ListView lvPerson = (ListView) findViewById(R.id.listview1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                (this, android.R.layout.simple_list_item_1, arr);
//        lvPerson.setAdapter(adapter);
    }

    //Tạo ra nút trở về ở thanh actionbar...........................
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    //...............................................................


}