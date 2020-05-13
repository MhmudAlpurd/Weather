package com.totonarya.weather.home;

import com.totonarya.weather.base.BasePresenter;
import com.totonarya.weather.base.BaseView;
import com.totonarya.weather.data.pojo.current.CurrentWeather;


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
