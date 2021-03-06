package com.totonarya.weather.data;


import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //Current Link: http://api.openweathermap.org/data/2.5/weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515
    //Forecast Link: http://api.openweathermap.org/data/2.5/forecast?q=tehran,ir&appid=d32376e1460f4bda251d473227f33515

    @GET("weather?")
    Observable<CurrentWeather> getCurrentWeather(@Query("q") String cnt, @Query("appid") String APP_ID);

    @GET("forecast?")
    Observable<ForecastWeather> getForecastWeather(@Query("q") String cnt, @Query("appid") String APP_ID);


}
