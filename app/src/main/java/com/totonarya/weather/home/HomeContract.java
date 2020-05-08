package com.totonarya.weather.home;

import com.totonarya.weather.base.BasePresenter;
import com.totonarya.weather.base.BaseView;
import com.totonarya.weather.data.pojo.current.CurrentWeather;

import java.util.List;


public interface HomeContract {

    interface View extends BaseView {
        void showCurrentWeather(List<CurrentWeather> currentWeatherList);
        void showError(String error);
    }

    interface Presenter extends BasePresenter<View> {
        void getCurrentWeather();
    }


}
