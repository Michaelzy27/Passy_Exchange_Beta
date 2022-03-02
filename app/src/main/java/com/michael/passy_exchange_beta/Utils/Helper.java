package com.michael.passy_exchange_beta.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.michael.passy_exchange_beta.Models.NotificationModel;
import com.michael.passy_exchange_beta.OnboardingScreen;
import com.michael.passy_exchange_beta.R;
import com.michael.passy_exchange_beta.Splashscreen;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    ProgressDialog progressDialog;
    Context context;
    private NotificationModel notificationModel;
    CustomProgressDialog dialog;

    public Helper(){

    }

    public Helper(Context context){
        this.context = context;
    }

    public void progressDialogStart(int dialogViewId, boolean signup){  //boolean checks if this method was called by Signup page

        dialog = new CustomProgressDialog(context, dialogViewId, signup);
        dialog.show();

        if (signup) {

            new Handler().postDelayed(new Runnable() { //if called by Signup page, the success dialog shows and dismisses by itself after 5 seconds
                @Override
                public void run() {
                    progressDialogEnd();
                }
            }, 5000);
        }

//        progressDialog = new ProgressDialog(context);
//        View view = LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog, null);
//        progressDialog.setContentView(view);
//        progressDialog.setTitle(titleMessage);
//        progressDialog.setMessage(detailMessage);
//        progressDialog.show();
//        progressDialog.setCanceledOnTouchOutside(true);
    }

    public void progressDialogEnd(){
        dialog.dismiss();
    }

    public void toastMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public List<NotificationModel> notificationLocalData(){
        List<NotificationModel> notificationList = new ArrayList<>();

        String s1 = "Welcome to HNG, here you will receive our basic notifications on important updates and things you wish to follow throughout HNG.  Welcom";
        notificationModel = new NotificationModel("Welcome to HNG", s1, "default", "25 July", false);
        notificationList.add(notificationModel);

        String s2 = "Welcome to HNG once more, we hope you getting prepared for out first upcoming task";
        notificationModel = new NotificationModel("Set Up for Our First Task", s2, "default", "25 July", true);
        notificationList.add(notificationModel);
        notificationList.add(notificationModel);

        return notificationList;
    }

}
