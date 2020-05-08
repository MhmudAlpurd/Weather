package com.totonarya.weather.data;


import androidx.appcompat.widget.ListPopupWindow;

import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    //Current Link: http://api.openweathermap.org/data/2.5/weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515
    //Forecast Link: http://api.openweathermap.org/data/2.5/forecast?q=tehran,ir&appid=d32376e1460f4bda251d473227f33515

    @GET("weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515")
    Single<List<CurrentWeather>> getCurrentWeather();


    @GET("weather?q=Tehran,IRAN&appid=d32376e1460f4bda251d473227f33515")
    Single<List<ForecastWeather>> getForeCastWeather();


/*
    @GET("weather?q={city},{state}&appid={APP_ID}")
    Single<List<CurrentWeather>> getCurrentWeather(@Path("city") String city, @Path("state") String state, @Path("APP_ID") String APP_ID);


    @GET("forecast/hourly?q={city},{state}&appid={APP_ID}")
    Single<List<ForecastWeather>> getForeCastWeather(@Path("city") String city, @Path("state") String state, @Path("APP_ID") String APP_ID);
*/

}
