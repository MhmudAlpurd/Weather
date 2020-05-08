package com.totonarya.weather.data;

import android.util.Log;

import com.totonarya.weather.data.pojo.forecast.ForecastWeather;
import com.totonarya.weather.data.pojo.current.CurrentWeather;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerDataSource implements WeatherDataSource {
    private ApiService apiService;
    final String APP_ID = "d32376e1460f4bda251d473227f33515";

    public ServerDataSource() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(ApiService.class);
    }

    public Single<List<CurrentWeather>> getCurrentWeather() {
        //TODO: DEFINE CITY AND STATE VARS.
        Log.d("CurrentWeather", "ServerDataSource:getCurrentWeather:1");
       // return apiService.getCurrentWeather("Tehran","Iran" , APP_ID);
        return apiService.getCurrentWeather();
    }

    public Single<List<ForecastWeather>> getForecastWeather() {
        //TODO: DEFINE CITY AND STATE VARS.
        //return apiService.getForeCastWeather("Tehran", "Iran", APP_ID);
        return apiService.getForeCastWeather();
    }
}
