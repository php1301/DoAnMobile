package com.example.doanmobile.fragment;

import android.content.Intent;
import android.net.Uri;
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

import com.example.doanmobile.GlobalVar;
import com.example.doanmobile.LoadImageURL;
import com.example.doanmobile.R;
import com.example.doanmobile.adapter.ListWalletAdapter;
import com.example.doanmobile.databinding.FragmentAccountBinding;
import com.example.doanmobile.databinding.FragmentDashboardBinding;
import com.example.doanmobile.model.MyListData;
import com.example.doanmobile.model.UserDetail;

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

        UserDetail user = GlobalVar.getInstance().getProfile().getUser().getUser();
        if (user.getAvatar() != null) {
            LoadImageURL loadURL = new LoadImageURL(binding.avatar);
            loadURL.execute(user.getAvatar());
        }

        if (user.getDisplayName() != null) {
            binding.textUsername.setText(user.getDisplayName());
        } else binding.textUsername.setText("");

        if (user.getFirstName() != null && user.getLastName() != null) {
            binding.textName.setText(user.getFirstName() + " " + user.getLastName());
        } else binding.textName.setText("");

        if (user.getEmail() != null) {
            binding.textEmail.setText(user.getEmail());
        } else binding.textEmail.setText("");

        if (user.getPhone() != null) {
            binding.textPhone.setText(user.getPhone());
        } else binding.textPhone.setText("");

        if (user.getFacebookUrl() != null) {
            binding.imgvFacebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(user.getFacebookUrl()));
                    startActivity(intent);
                }
            });
        } else binding.imgvFacebook.setVisibility(View.INVISIBLE);

        if (user.getInstagramUrl() != null) {
            binding.imgvInsta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(user.getInstagramUrl()));
                    startActivity(intent);
                }
            });
        } else binding.imgvInsta.setVisibility(View.INVISIBLE);

        if (user.getYoutubeUrl() != null) {
            binding.imgvYoutube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(user.getYoutubeUrl()));
                    startActivity(intent);
                }
            });
        } else binding.imgvYoutube.setVisibility(View.INVISIBLE);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}