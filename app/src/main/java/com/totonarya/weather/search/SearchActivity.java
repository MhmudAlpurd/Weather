package com.totonarya.weather.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;
import com.totonarya.weather.data.db.DataBase;
import com.totonarya.weather.data.pojo.searchCity.SearchCities;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView rvSearch;
    SearchCitiesAdapter searchCitiesAdapter;
    EditText editText;
    ImageView background;
    List<SearchCities> searchedcity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setupViews();
        showBackground();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().isEmpty()) {
                    showBackground();
                } else {
                    removeBackground();
                    filter(s.toString());
                }

            }
        });
    }

    private void setupViews() {
        rvSearch = findViewById(R.id.rv_cities_searchactivity);
        rvSearch.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DataBase db = new DataBase(getApplicationContext());
        searchedcity = db.getAllCities();
        searchCitiesAdapter = new SearchCitiesAdapter(getApplicationContext(), searchedcity);
        rvSearch.setAdapter(searchCitiesAdapter);
        editText = findViewById(R.id.et_cityname_searchactivity);
        background = findViewById(R.id.searchBackground);
    }


    private void filter(String text) {
        List<SearchCities> filteredList = new ArrayList<>();
        for (SearchCities city : searchedcity){
            if (city.getCityName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(city);
            }
        }
       searchCitiesAdapter.filterList(filteredList);

    }

    private void showBackground() {
        background.setVisibility(View.VISIBLE);
        rvSearch.setVisibility(View.GONE);
    }

    private void removeBackground() {
        background.setVisibility(View.GONE);
        rvSearch.setVisibility(View.VISIBLE);
    }





}
