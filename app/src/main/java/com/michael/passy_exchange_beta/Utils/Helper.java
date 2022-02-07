package com.michael.passy_exchange.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.michael.passy_exchange.Models.NotificationModel;
import com.michael.passy_exchange.Models.UserPostModel;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    ProgressDialog progressDialog;
    Context context;
    private NotificationModel notificationModel;

    public Helper(){

    }

    public Helper(Context context){
        this.context = context;
    }

    public void progressDialogStart(String titleMessage, String detailMessage){
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titleMessage);
        progressDialog.setMessage(detailMessage);
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(true);
    }

    public void progressDialogEnd(){
        progressDialog.dismiss();
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

    public List<UserPostModel> userPostLocalData(){
        List<UserPostModel> userPostListData = new ArrayList<>();

        String s2 = "Hello, I am John Doe, happy to be here";
        UserPostModel userPostModel = new UserPostModel("default", "John Doe", "25min", "Introduction", "Hello, I am John Doe, happy to be here");
        userPostListData.add(userPostModel);
        userPostListData.add(userPostModel);
        userPostListData.add(userPostModel);

        return userPostListData;
    }
}
