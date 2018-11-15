package com.rohan.legendDialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ProgressDialog {

    private AlertDialog dialog;

    public ProgressDialog(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.progress_dialog, null);
        TextView tv_message = view.findViewById(R.id.tv_message);
        tv_message.setText(message);

        builder.setView(view);
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }
}
