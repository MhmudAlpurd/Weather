package com.totonarya.weather.home;

import android.util.Log;

import com.totonarya.weather.base.BasePresenter;
import com.totonarya.weather.base.BaseView;
import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.data.pojo.forecast.City;

import java.util.List;


public interface HomeContract {

    interface View extends BaseView {
        void OnSetData();
        void showCurrentWeather(CurrentWeather currentWeather);
        void showError(String error);

    }

    interface Presenter extends BasePresenter<View> {
        void getCurrentWeather(String City, String State);
        void setDataOnUI();
    }


}
