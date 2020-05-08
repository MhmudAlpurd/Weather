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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CurrentWeather", "onCreate:CurrentWeatherFragment:1");
        presenter = new HomePresenter(new  WeatherRepository());

    }

    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragmentcurrentweather;
    }

    @Override
    public void showCurrentWeather(List<CurrentWeather> currentWeatherList) {
        Log.d("CurrentWeather", "CurrentWeathrFragment:showCurrentWeather:1");

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
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
