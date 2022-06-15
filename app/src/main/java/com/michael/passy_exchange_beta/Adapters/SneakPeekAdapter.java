package com.michael.passy_exchange_beta.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.safetynet.SafetyNetApi;
import com.michael.passy_exchange_beta.Models.SneakModel;
import com.michael.passy_exchange_beta.R;

import java.util.List;

public class SneakPeekAdapter extends RecyclerView.Adapter<SneakPeekAdapter.ViewHolder> {

    String number;
    int peek;
    List<SneakModel> model;


//    public SneakPeekAdapter(String number, int peek) {
//        this.number = number;
//        this.peek = peek;
//        notifyDataSetChanged();
//    }


    public SneakPeekAdapter(List<SneakModel> model) {
        this.model = model;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView sneakImage;
        TextView sneakNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sneakImage = itemView.findViewById(R.id.sneak_image);
            sneakNumber = itemView.findViewById(R.id.sneak_number);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sneak_peek_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        SkillListModel model = skillModelList.get(position);
//
//        logInfo(model.getNameText());

        SneakModel modeel = model.get(position);
        holder.sneakNumber.setText(modeel.sneakNumber);
        holder.sneakImage.setImageResource(modeel.sneakImage);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }
//
//    public void addLearners(SkillListModel listModel) {
//        skillModelList.add(listModel);
//        notifyDataSetChanged();
//    }
//
//    public void logInfo(String text) {
//        Log.i("info ", text);
//    }
}

