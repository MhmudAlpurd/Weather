package com.totonarya.weather.forecastweather;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ForecastItemsAdapter{
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
            one = itemView.findViewById(R.id)
        }
    }

}
