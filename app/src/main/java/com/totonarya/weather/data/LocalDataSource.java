package com.totonarya.weather.data;

import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import io.reactivex.Observable;


public class LocalDataSource implements WeatherDataSource {
    @Override
    public Observable<CurrentWeather> getCurrentWeather(String City, String State) {
        return null;
    }

    @Override
    public Observable<ForecastWeather> getForecastWeather(String City, String State) {
        return null;
    }


}
