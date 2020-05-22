package com.totonarya.weather.forecastweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;
import com.totonarya.weather.data.pojo.forecast.List;
import com.totonarya.weather.utils.Func;


public class ForecastItemAdapter extends RecyclerView.Adapter<ForecastItemAdapter.MyViewHolder> {

    java.util.List<List> itemList;
    Context mContext;
    Func func = new Func();

    public ForecastItemAdapter(java.util.List<List> itemList, Context mContext) {
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
        List item = itemList.get(position);
        holder.temp.setText(item.getMain().getTemp().toString());
         holder.time.setText(item.getDt().toString());
         holder.day.setText(item.getDt().toString());
         holder.date.setText(item.getDt().toString());
          String icon_Link = func.openWeather_Icon_Link(item.getWeather().get(0).getIcon().toString());
         func.setImageByUrl(icon_Link,holder.weatherIcon);
         holder.weatherSituation.setText(item.getWeather().get(0).getMain().toString());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public TextView day;
        public TextView date;
        public ImageView weatherIcon;
        public TextView temp;
        public TextView weatherSituation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.tv_time_forecastItem);
            day = itemView.findViewById(R.id.tv_day_forecastItem);
            date = itemView.findViewById(R.id.tv_date_forecastItem);
           weatherIcon = itemView.findViewById(R.id.img_weatherIcon_forecastItem);
            temp = itemView.findViewById(R.id.tv_temp_forecastItem);
            weatherSituation = itemView.findViewById(R.id.tv_weatherSituation_forecastItem);
        }
    }
}
