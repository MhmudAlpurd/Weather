package com.totonarya.weather.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;
import com.totonarya.weather.data.db.DataBase;
import com.totonarya.weather.data.pojo.searchCity.SearchCities;

import java.util.List;

public class SearchFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    SearchAdapter searchAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_search, container, false);

        setupViews();
        return view;
    }

    private void setupViews() {
        recyclerView = view.findViewById(R.id.rv_cities_searchactivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DataBase db = new DataBase(getActivity());

        List<SearchCities> searchCitiesList = db.getAllCities();
        searchAdapter = new SearchAdapter(getActivity(), searchCitiesList);
        recyclerView.setAdapter(searchAdapter);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
