package com.example.doanmobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.model.MyListData;
import com.example.doanmobile.R;


public class ListWalletAdapter extends RecyclerView.Adapter<ListWalletAdapter.ViewHolder> {
    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public ListWalletAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_wallet, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];

//        holder.txtName(listdata[position].getDescription());
//        holder.txtAddress(listdata[position].getAddress());
//        holder.imageView.setImageResource(listdata[position].getImgId());
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtName, txtAddress;
        public RelativeLayout relativelayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imgv_wallet);
            this.txtName = (TextView) itemView.findViewById(R.id.name_wallet);
            this.txtAddress = (TextView) itemView.findViewById(R.id.address_wallet);
            relativelayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_wallet);
        }
    }
}