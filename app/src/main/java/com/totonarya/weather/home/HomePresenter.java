package com.totonarya.weather.home;

import android.util.Log;

import com.totonarya.weather.data.WeatherDataSource;
import com.totonarya.weather.data.pojo.current.CurrentWeather;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private WeatherDataSource weatherDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomePresenter(WeatherDataSource weatherDataSource) {
        this.weatherDataSource = weatherDataSource;
        Log.d("CurrentWeather", "HomePresenter:Constructor:1");
    }

    @Override
    public void getCurrentWeather() {
        Log.d("CurrentWeather", "HomePresenter:GetCurrentWeather:1");
        weatherDataSource.getCurrentWeather().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<CurrentWeather>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("CurrentWeather", "HomePresenter:GetCurrentWeather:onsubscribe:1");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<CurrentWeather> currentWeathers) {
                        view.showCurrentWeather(currentWeathers);
                        Log.d("CurrentWeather", "HomePresenter:onSuccess:1");



                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                        Log.d("CurrentWeather", "HomePresenter:onError:1");
                    }
                });

    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
        getCurrentWeather();
    }

    @Override
    public void detachView() {
        this.view = null;
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }

    }
}
