package com.example.doanmobile.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;

import com.example.doanmobile.R;
import com.example.doanmobile.adapter.ListWalletAdapter;
import com.example.doanmobile.databinding.FragmentAccountBinding;
import com.example.doanmobile.databinding.FragmentDashboardBinding;
import com.example.doanmobile.model.MyListData;

public class AccountFragment extends Fragment {

    FragmentAccountBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentAccountBinding.inflate(getLayoutInflater());

        binding.imgvEditPerInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switchName.showNext();
                binding.switchUsername.showNext();
                binding.switchEmail.showNext();
                binding.switchPhone.showNext();
            }
        });

        createTestList();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public FragmentAccountBinding createTestList(){
        MyListData[] myListData = new MyListData[] {
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_email),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_info),
                new MyListData("Wallet", "123", android.R.drawable.ic_delete),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_dialer),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_alert),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_map),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_email),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_info),
                new MyListData("Wallet", "123", android.R.drawable.ic_delete),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_dialer),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_alert),
                new MyListData("Wallet", "123", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = binding.rvWalletList;
        ListWalletAdapter adapter = new ListWalletAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return binding;
    }
}