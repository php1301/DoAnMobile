package com.example.doanmobile;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

public class LoadingDialog {
    Context context;
    Dialog dialog;
    public LoadingDialog(Context context){
        this.context=context;
    }
    public void showDialog(String title){
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView titleTextView = dialog.findViewById(R.id.Textviewpro);
        titleTextView.setText(title);
        dialog.create();
        dialog.show();
    }
    public void HideDialog()
    {
        dialog.dismiss();
    }
}

