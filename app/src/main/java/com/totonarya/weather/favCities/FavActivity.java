package com.totonarya.weather.favCities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.totonarya.weather.R;

public class FavActivity extends AppCompatActivity {

    RecyclerView rv_favCities;
    FavAdapter favAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        rv_favCities = findViewById(R.id.rv_favCities);









    }
}