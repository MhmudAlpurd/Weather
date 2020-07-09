package com.totonarya.weather.favCities;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;
import com.totonarya.weather.cityData.CitynameActivity;
import com.totonarya.weather.data.pojo.searchCity.SearchCities;


import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SearchCities> citiesList;

    public FavAdapter(Context context, List<SearchCities> citiesList) {
        this.context = context;
        this.citiesList = citiesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//Bind Data
        ItemViewHolder myItemViewHolder = (ItemViewHolder) holder;
        myItemViewHolder.cityName.setText(citiesList.get(position).getCityName());
        myItemViewHolder.countryName.setText(citiesList.get(position).getCountry());
        myItemViewHolder.searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CitynameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("ID", citiesList.get(position).getId());
                intent.putExtra("CITY", citiesList.get(position).getCityName());
                intent.putExtra("COUNTRY", citiesList.get(position).getCountry());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return citiesList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView cityName;
        TextView countryName;
        LinearLayout searchLayout;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.txt_cityName_searchItem);
            countryName = itemView.findViewById(R.id.txt_CountryName_searchItem);
            searchLayout = itemView.findViewById(R.id.searchitem_id);

        }
    }


}

