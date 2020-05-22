package com.totonarya.weather;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.totonarya.weather.forecastweather.forecastWeatherFragment;
import com.totonarya.weather.home.CurrentWeatherFragment;

public class MainActivity extends AppCompatActivity {

    ImageView kebabMenu;
    FragmentTransaction fragmentTransaction_Current;
    FragmentTransaction fragmentTransaction_Forecast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupViews_2();
        kebabMenu = findViewById(R.id.img_kebabmenu_main);
    }

    private void setupViews() {
     fragmentTransaction_Current = getSupportFragmentManager().beginTransaction();
        fragmentTransaction_Current.replace(R.id.rel_main_fragmentContainer, new CurrentWeatherFragment());
        fragmentTransaction_Current.commit();
    }

    private void setupViews_2() {
        fragmentTransaction_Forecast = getSupportFragmentManager().beginTransaction();
        fragmentTransaction_Forecast.replace(R.id.rel_Second_FragmentContainer, new forecastWeatherFragment());
        fragmentTransaction_Forecast.commit();
    }

}
