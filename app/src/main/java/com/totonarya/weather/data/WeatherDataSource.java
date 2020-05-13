package com.totonarya.weather.data;

import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import io.reactivex.Observable;

public interface WeatherDataSource {

    Observable<CurrentWeather> getCurrentWeather(String City, String State);
    Observable<ForecastWeather> getForecastWeather(String City, String State);


}
