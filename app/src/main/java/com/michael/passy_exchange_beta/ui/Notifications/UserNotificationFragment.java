package com.michael.passy_exchange.ui.Notifications;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.passy_exchange.Adapters.NotificationAdapter;
import com.michael.passy_exchange.R;
import com.michael.passy_exchange.Utils.Helper;

public class UserNotificationFragment extends Fragment {

    private UserNotificationViewModel mViewModel;
    private RecyclerView recyclerView;
    private Helper helper;
    NotificationAdapter notificationAdapter;

    public static UserNotificationFragment newInstance() {
        return new UserNotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.user_notification_fragment, container, false);
        helper = new Helper(getContext());

        recyclerView = root.findViewById(R.id.notification_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        notificationAdapter = new NotificationAdapter(getContext(), helper.notificationLocalData());
        recyclerView.setAdapter(notificationAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserNotificationViewModel.class);
        // TODO: Use the ViewModel
    }

}