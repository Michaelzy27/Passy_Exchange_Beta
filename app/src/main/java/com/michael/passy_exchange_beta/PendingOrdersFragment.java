package com.michael.passy_exchange;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.passy_exchange.Adapters.PendingOrdersAdapter;


public class PendingOrdersFragment extends Fragment {

    LinearLayoutManager recyclerLayout;
    PendingOrdersAdapter ordersAdapter;


    public static PendingOrdersFragment newInstance() {
        return new PendingOrdersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pending_orders, container, false);

        RecyclerView pendingOrders = root.findViewById(R.id.pending_orders);
        recyclerLayout = new LinearLayoutManager(getContext());
        ordersAdapter = new PendingOrdersAdapter();

        pendingOrders.setLayoutManager(recyclerLayout);
        pendingOrders.setAdapter(ordersAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel

    }

}