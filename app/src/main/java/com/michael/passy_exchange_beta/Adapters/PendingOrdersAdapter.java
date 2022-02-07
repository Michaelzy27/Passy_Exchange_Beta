package com.michael.passy_exchange_beta.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.michael.passy_exchange_beta.R;

public class PendingOrdersAdapter extends RecyclerView.Adapter<PendingOrdersAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView pending_order_type, pending_order_amount, pending_order_address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pending_order_type = itemView.findViewById(R.id.pending_order_type);
            pending_order_amount = itemView.findViewById(R.id.pending_orders_amount);
            pending_order_address = itemView.findViewById(R.id.pending_order_address);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_orders_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PendingOrdersAdapter.ViewHolder holder, int position) {

        holder.pending_order_address.setText("Hahah test");
        holder.pending_order_amount.setText("Heheh okay");
        holder.pending_order_type.setText("Text test");

    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
