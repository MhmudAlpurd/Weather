package com.totonarya.weather.base;

public interface BasePresenter<T extends BaseView, City, State> {
    void attachView(T view, String City, String State);

    void detachView();
}
