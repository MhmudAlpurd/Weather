package com.totonarya.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.totonarya.weather.home.CurrentWeatherFragment;

public class MainActivity extends AppCompatActivity{


    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CurrentWeather", "onCreate:MainActivity:1");
        setupViews();



    }

    private void setupViews() {
        Log.d("CurrentWeather", "setupViews:MainActivity:2");
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rel_main_fragmentContainer, new CurrentWeatherFragment());
        fragmentTransaction.commit();


    }

}
