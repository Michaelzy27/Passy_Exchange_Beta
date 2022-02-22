package com.michael.passy_exchange_beta.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.michael.passy_exchange_beta.Models.NotificationModel;
import com.michael.passy_exchange_beta.R;

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

    public void progressDialogStart(String titleMessage, String detailMessage){

        dialog = new CustomProgressDialog(context, titleMessage, detailMessage);
        dialog.show();

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
