package com.michael.passy_exchange;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawerItemCustomAdapter extends ArrayAdapter<NavItem> {
    Context mContext;
    int layoutResourceId;
    NavItem[] data;

    DrawerItemCustomAdapter(Context mContext, NavItem[] data) {
        super(mContext,0, data);
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

        if (listItem == null) {
            listItem = inflater.inflate(R.layout.nav_bar_item, parent, false);
        }
        ImageView imageViewIcon = listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = listItem.findViewById(R.id.textViewName);

        NavItem folder = data[position];

        imageViewIcon.setImageResource(folder.getIcon());
        textViewName.setText(folder.getName());

        return listItem;
    }
}
