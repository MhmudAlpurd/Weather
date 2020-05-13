package com.totonarya.weather.data;

import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import io.reactivex.Observable;

public class WeatherRepository implements WeatherDataSource {

    private ServerDataSource serverDataSource = new ServerDataSource();
    private LocalDataSource localDataSource = new LocalDataSource();

    @Override
    public Observable<CurrentWeather> getCurrentWeather(String City, String State) {
        return serverDataSource.getCurrentWeather(City,State);
    }

    @Override
    public Observable<ForecastWeather> getForecastWeather(String City, String State) {
        return serverDataSource.getForecastWeather(City,State);
    }


}
