package com.totonarya.weather;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.totonarya.weather.forecastweather.ForecastWeatherFragment;
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
        kebabMenu = findViewById(R.id.img_kebabmenu_main);
    }

    private void setupViews() {
     /*   fragmentTransaction_Current = getSupportFragmentManager().beginTransaction();
        fragmentTransaction_Current.replace(R.id.rel_main_fragmentContainer, new CurrentWeatherFragment());
        fragmentTransaction_Current.commit();*/

        fragmentTransaction_Forecast = getSupportFragmentManager().beginTransaction();
        fragmentTransaction_Forecast.replace(R.id.rel_forecast_fragmentContainer, new ForecastWeatherFragment());
        fragmentTransaction_Forecast.commit();
    }

}
