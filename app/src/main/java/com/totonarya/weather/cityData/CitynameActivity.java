package com.totonarya.weather.cityData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.totonarya.weather.R;
import com.totonarya.weather.data.pojo.forecast.City;

public class CitynameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView back, cityName, countryName, tempcity;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cityname);
        setupViews();
        getAndSetData();
        back.setOnClickListener(this);
        fab.setOnClickListener(this);



    }

    private void getAndSetData() {

        Intent intent = getIntent();
        cityName.setText(intent.getExtras().getString("CITY"));
        countryName.setText(intent.getExtras().getString("COUNTRY"));


    }

    private void setupViews() {
        back = findViewById(R.id.txt_Back_CityActivity);
        cityName = findViewById(R.id.txt_cityname_cityactivity);
        countryName = findViewById(R.id.txt_countryname_cityactivity);
        tempcity = findViewById(R.id.txt_tempcity_cityactivity);
        fab = findViewById(R.id.fab_id);
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        switch (viewID) {
            case R.id.txt_Back_CityActivity:
                onBackPressed();
                break;
            case R.id.fab_id:

                break;

        }

    }
}