package com.totonarya.weather.forecastweather;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;
import com.totonarya.weather.data.Item;


import java.util.List;

public class ForecastItemsAdapter extends RecyclerView.Adapter<ForecastItemsAdapter.MyViewHolder> {
    List<com.totonarya.weather.data.pojo.forecast.List> itemList;
    Context mContext;

    public ForecastItemsAdapter(List<com.totonarya.weather.data.pojo.forecast.List> itemList, Context mContext) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecastitems_item, parent, false);
        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        com.totonarya.weather.data.pojo.forecast.List aItem = itemList.get(position);
        holder.one.setText(aItem.getDtTxt());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView one;
        public TextView two;
        public TextView three;
        public TextView four;
        public TextView five;
        public TextView six;
        public TextView seven;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            one = itemView.findViewById(R.id.txt_forecastItems_One);
            two = itemView.findViewById(R.id.txt_forecastItems_Two);
            three = itemView.findViewById(R.id.txt_forecastItems_Three);
            four = itemView.findViewById(R.id.txt_forecastItems_Four);
            five = itemView.findViewById(R.id.txt_forecastItems_Five);
            six = itemView.findViewById(R.id.txt_forecastItems_Six);
            seven = itemView.findViewById(R.id.txt_forecastItems_Seven);
        }
    }

}
