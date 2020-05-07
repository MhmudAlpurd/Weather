package com.totonarya.weather.data;

import com.totonarya.weather.data.pojo.current.CurrentWeather;

import java.util.List;

import io.reactivex.Single;

public class LocalDataSource implements WeatherDataSource {
    @Override
    public Single<List<CurrentWeather>> getCurrentWeather() {
        return null;
    }

/*    @Override
    public Single<List<ForecastWeather>> getForecastWeather() {
        return null;
    }*/
}
