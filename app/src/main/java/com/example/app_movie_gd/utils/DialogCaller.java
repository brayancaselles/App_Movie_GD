package com.example.aflore_prueba.utils;

import android.app.AlertDialog;
import android.content.Context;

import com.example.aflore_prueba.R;

public class DialogCaller {

    private static AlertDialog dialog;

    public static void showDialog(Context context) {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setMessage(context.getString(R.string.generic_message_progress));
        dialog.show();
    }

    public static void dismissDialog() {
        dialog.dismiss();
    }
}
