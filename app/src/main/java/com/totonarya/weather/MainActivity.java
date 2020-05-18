package com.totonarya.weather;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.totonarya.weather.forecastweather.ForecastWeatherFragment;
import com.totonarya.weather.home.CurrentWeatherFragment;
public class MainActivity extends AppCompatActivity {

    ImageView kebabMenu;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupForecast();
        kebabMenu = findViewById(R.id.img_kebabmenu_main);
    }

    private void setupViews() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rel_main_fragmentContainer, new CurrentWeatherFragment());
        fragmentTransaction.commit();
    }
    private void setupForecast() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rel_forecast_fragmentContainer,new ForecastWeatherFragment());
        fragmentTransaction.commit();
    }
}
