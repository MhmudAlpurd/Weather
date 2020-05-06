package com.totonarya.weather.data;

import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import java.util.List;

import io.reactivex.Single;

public interface WeatherDataSource {


    Single<List<CurrentWeather>> getCurrentWeather();
    Single<List<ForecastWeather>> getForecastWeather();


}
