package com.totonarya.weather.data;

import com.totonarya.weather.data.pojo.forecast.ForecastWeather;
import com.totonarya.weather.data.pojo.current.CurrentWeather;

import java.util.List;

import io.reactivex.Single;

public class WeatherRepository implements WeatherDataSource {

    private ServerDataSource serverDataSource = new ServerDataSource();
    private LocalDataSource localDataSource = new LocalDataSource();

    @Override
    public Single<List<CurrentWeather>> getCurrentWeather() {
        return serverDataSource.getCurrentWeather();
    }

    public Single<List<ForecastWeather>> getForecastWeather(){
        return serverDataSource.getForecastWeather();
    }


}
