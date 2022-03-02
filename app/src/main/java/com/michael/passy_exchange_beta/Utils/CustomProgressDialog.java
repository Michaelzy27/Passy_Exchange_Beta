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
    public CustomProgressDialog(@NonNull Context context, int viewID, boolean signup) {  //boolean checks if this was called by Signup page
        super(context);

        WindowManager.LayoutParams wlmp = getWindow().getAttributes();

        wlmp.gravity = Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(wlmp);
        setTitle(null);
        if (signup) {  //if called by signup page, user can dismiss dialog by tapping anywhere on screen.
            setCancelable(true);
        } else {
            setCancelable(false);
        }
        setOnCancelListener(null);
        View view = LayoutInflater.from(context).inflate(viewID, null);
        setContentView(view);
    }
}
