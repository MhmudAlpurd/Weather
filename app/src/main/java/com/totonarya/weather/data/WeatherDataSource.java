package com.totonarya.weather.data;

import android.util.Log;

import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface WeatherDataSource {

    Observable<CurrentWeather> getCurrentWeather();


}
