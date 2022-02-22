package com.michael.passy_exchange_beta.Utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.michael.passy_exchange_beta.R;

public class CustomProgressDialog extends Dialog {
    public CustomProgressDialog(@NonNull Context context, String title, String message) {
        super(context);

        WindowManager.LayoutParams wlmp = getWindow().getAttributes();

        wlmp.gravity = Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(wlmp);
        setTitle(title);
        setCancelable(false);
        setOnCancelListener(null);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog, null);
        setContentView(view);
    }
}
