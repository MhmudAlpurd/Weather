package com.totonarya.weather.base;

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
