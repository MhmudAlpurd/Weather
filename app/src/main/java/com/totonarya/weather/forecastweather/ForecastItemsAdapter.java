package com.totonarya.weather.forecastweather;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;

public class ForecastItemsAdapter extends RecyclerView.Adapter<ForecastItemsAdapter.MyViewHolder>{
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
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
