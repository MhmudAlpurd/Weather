package com.totonarya.weather.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;
import com.totonarya.weather.data.pojo.searchCity.SearchCities;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SearchCities> searchCitiesList;

    public SearchAdapter(Context context, List<SearchCities> searchCitiesList) {
        this.context = context;
        this.searchCitiesList = searchCitiesList;
    }

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item,parent,false);
        return new ItemViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//Bind Data

        ItemViewHolder myViewHolder = (ItemViewHolder) holder;
        myViewHolder.cityName.setText(searchCitiesList.get(position).getCityName());

    }

    @Override
    public int getItemCount() {
        return searchCitiesList.size() ;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView cityName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.txt_cityName_searchItem);
        }
    }
}
