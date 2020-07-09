package com.totonarya.weather.cityData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.totonarya.weather.R;
import com.totonarya.weather.data.db.DataBase;
import com.totonarya.weather.data.pojo.forecast.City;

public class CitynameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView back, cityName, countryName, tempcity;
    FloatingActionButton fab;

    DataBase db;
    int id, value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cityname);
        setupViews();
        getAndSetData();
        favCondition();
        back.setOnClickListener(this);
        fab.setOnClickListener(this);


    }

    private void favCondition() {
        db = new DataBase(CitynameActivity.this);
        value = db.fav_value(id);

        if (value == 0) {
//not fav
            fab.setImageResource(R.drawable.ic_baseline_favorite_border_24);


        } else if (value == 1) {
//fav
            fab.setImageResource(R.drawable.fav_full);
        }
    }

    private void getAndSetData() {

        Intent intent = getIntent();
        id = intent.getExtras().getInt("ID");
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


                addOrRemoveFav();

                break;

        }

    }

    private void addOrRemoveFav() {
        db = new DataBase((CitynameActivity.this));
        value = db.fav_value(id);
        if (value == 0) {
            db.favChanger(1, id);
            fab.setImageResource(R.drawable.fav_full);
            Toast.makeText(CitynameActivity.this, "Added to your favorite cities!", Toast.LENGTH_LONG).show();
        } else {

            db.favChanger(0, id);
            fab.setImageResource(R.drawable.ic_baseline_favorite_border_24);
            Toast.makeText(CitynameActivity.this, "Removed from your favorite cities!", Toast.LENGTH_LONG).show();
        }

    }
}