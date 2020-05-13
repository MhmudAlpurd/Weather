package com.totonarya.weather.data;

import android.util.Log;

import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerDataSource implements WeatherDataSource {
    private ApiService apiService;
    final String APP_ID = "d32376e1460f4bda251d473227f33515";

    public ServerDataSource() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(ApiService.class);
    }

    public Observable<CurrentWeather> getCurrentWeather(String City, String State) {
        String Location = City + "," + State;
        return apiService.getCurrentWeather(Location, APP_ID);
    }

    @Override
    public Observable<ForecastWeather> getForecastWeather(String City, String State) {
        String Location = City + "," + State;
        Log.d("LLL", "Observable<ForecastWeather>");
        return apiService.getForecastWeather(Location,APP_ID);
    }

}

