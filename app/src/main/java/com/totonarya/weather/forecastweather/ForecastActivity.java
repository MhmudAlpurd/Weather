package com.totonarya.weather.forecastweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.totonarya.weather.R;
import com.totonarya.weather.data.WeatherRepository;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

public class ForecastActivity extends AppCompatActivity implements ForecastContract.View {
    ForecastContract.Presenter presenter;
    String city = "Tehran";
    String state = "Iran";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        presenter = new ForecastPresenter(new WeatherRepository(),city,state);

    }

    @Override
    public void OnSetData() {

    }

    @Override
    public void showForecastWeather(ForecastWeather forecastWeather) {
        Log.d("LLL", forecastWeather.getCity().getName());


    }

    @Override
    public void showError(String error) {
      Log.d("LLL",error);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public Context getViewContext() {
        return null;
    }
}

