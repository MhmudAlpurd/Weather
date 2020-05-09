package com.totonarya.weather.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.totonarya.weather.R;
import com.totonarya.weather.base.BaseFragment;
import com.totonarya.weather.data.WeatherRepository;
import com.totonarya.weather.data.pojo.current.CurrentWeather;

import java.util.List;

public class CurrentWeatherFragment extends BaseFragment implements HomeContract.View {

    private HomeContract.Presenter presenter;
    String City = "Tehran";
    String State = "Iran";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CurrentWeather", "onCreate:CurrentWeatherFragment:1");
        presenter = new HomePresenter(new WeatherRepository());

    }

    @Override
    public void setupViews() {
        Log.d("CurrentWeather", "CurrentWeatherFragment:setUpViews:1");
    }

    @Override
    public int getLayout() {
        return R.layout.fragmentcurrentweather;
    }

    @Override
    public void showCurrentWeather(CurrentWeather currentWeather) {
        String CityName = currentWeather.getName().toString();
        String ID = currentWeather.getId().toString();
        String Clouds = currentWeather.getClouds().getAll().toString();
        String Temp = currentWeather.getMain().getTemp().toString();
        String TempMax = currentWeather.getMain().getTempMax().toString();


        Log.d("currentweather", Temp);

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void onStart() {
        Log.d("CurrentWeather", "CurrentWeatherFragment:onStart:1");
        super.onStart();
        presenter.attachView(this, City, State);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
