package com.totonarya.weather.forecastweather;

import com.totonarya.weather.base.BasePresenter;
import com.totonarya.weather.base.BaseView;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

public interface ForecastContract {

    interface View extends BaseView{
        void OnSetData();
        void showForecastWeather(ForecastWeather forecastWeatherList);
        void showError(String error);
    }

    interface Presenter extends BasePresenter<View>{
        void getForecastWeather(String City, String State);
        void setDataOnUI();

    }
}
