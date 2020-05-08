package com.totonarya.weather.data;


import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //Current Link: http://api.openweathermap.org/data/2.5/weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515
    //Forecast Link: http://api.openweathermap.org/data/2.5/forecast?q=tehran,ir&appid=d32376e1460f4bda251d473227f33515

/*
    @GET("weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515")
    Single<List<CurrentWeather>> getCurrentWeather();


    @GET("weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515")
    Single<List<ForecastWeather>> getForeCastWeather();

*/


  //  @GET("weather?q={city},{state}&appid={APP_ID}")
    @GET("weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515")
    Single<List<CurrentWeather>> getCurrentWeather();


    @GET("weather?q=Tehran,IRAN")
    Single<List<ForecastWeather>> getForeCastWeather(@Query("appid") String APP_ID);


}
