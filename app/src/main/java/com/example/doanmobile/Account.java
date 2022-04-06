package com.example.doanmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageButton btn_edit_info = (ImageButton) findViewById(R.id.btn_edit_per_inf);
        btn_edit_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewSwitcher switch_name = (ViewSwitcher) findViewById(R.id.switch_name);
                switch_name.showNext();
                ViewSwitcher switch_username = (ViewSwitcher) findViewById(R.id.switch_username);
                switch_username.showNext();
                ViewSwitcher switch_email= (ViewSwitcher) findViewById(R.id.switch_email);
                switch_email.showNext();
                ViewSwitcher switch_phone = (ViewSwitcher) findViewById(R.id.switch_phone);
                switch_phone.showNext();
            }
        });

        //
        MyListData[] myListData = new MyListData[] {
                new MyListData("Wallet", android.R.drawable.ic_dialog_email),
                new MyListData("Wallet", android.R.drawable.ic_dialog_info),
                new MyListData("Wallet", android.R.drawable.ic_delete),
                new MyListData("Wallet", android.R.drawable.ic_dialog_dialer),
                new MyListData("Wallet", android.R.drawable.ic_dialog_alert),
                new MyListData("Wallet", android.R.drawable.ic_dialog_map),
                new MyListData("Wallet", android.R.drawable.ic_dialog_email),
                new MyListData("Wallet", android.R.drawable.ic_dialog_info),
                new MyListData("Wallet", android.R.drawable.ic_delete),
                new MyListData("Wallet", android.R.drawable.ic_dialog_dialer),
                new MyListData("Wallet", android.R.drawable.ic_dialog_alert),
                new MyListData("Wallet", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_wallet);
        ListWalletAdapter adapter = new ListWalletAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        //
    }
}