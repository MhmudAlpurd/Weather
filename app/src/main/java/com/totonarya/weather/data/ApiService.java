package com.totonarya.weather.data;


import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //Current Link: http://api.openweathermap.org/data/2.5/weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515
    //Forecast Link: http://api.openweathermap.org/data/2.5/forecast?q=tehran,ir&appid=d32376e1460f4bda251d473227f33515


    @GET("weather?q={city},{state}&appid={APP_ID}")
    Single<List<CurrentWeather>> getCurrentWeather(@Path("city") String city, @Path("state") String state, @Path("APP_ID") String APP_ID);


    @GET("forecast/hourly?q={city},{state}&appid={APP_ID}")
    Single<List<ForecastWeather>> getForeCastWeather(@Path("city") String city, @Path("state") String state, @Path("APP_ID") String APP_ID);

}
