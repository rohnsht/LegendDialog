package com.rohan.legendDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

public class ListDialog {

    public ListDialog(Context context, String header, String[] items,
                      final DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(header)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        listener.onClick(dialogInterface, position);
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public ListDialog(Context context, String header, ArrayList<String> itemList,
                      final DialogInterface.OnClickListener listener) {

        String[] items = itemList.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(header)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        listener.onClick(dialogInterface, position);
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
