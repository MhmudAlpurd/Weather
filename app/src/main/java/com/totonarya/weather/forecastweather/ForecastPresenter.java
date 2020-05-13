package com.totonarya.weather.forecastweather;

import com.totonarya.weather.data.WeatherDataSource;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForecastPresenter implements ForecastContract.Presenter {
    WeatherDataSource weatherDataSource;
    ForecastContract.View view;
    private String City;
    private String State;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ForecastPresenter(WeatherDataSource weatherDataSource, String City, String State) {
        this.weatherDataSource = weatherDataSource;
        this.City = City;
        this.State = State;
    }


    @Override
    public void getForecastWeather(String City, String State) {
        weatherDataSource.getForecastWeather(City, State).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ForecastWeather>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(ForecastWeather forecastWeatherList) {
                view.showForecastWeather(forecastWeatherList);
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.toString());
            }

            @Override
            public void onComplete() {
                setDataOnUI();
            }
        });
    }

    @Override
    public void setDataOnUI() {
        view.OnSetData();
    }

    @Override
    public void attachView(ForecastContract.View view) {
        this.view = view;
        getForecastWeather(City, State);
    }

    @Override
    public void detachView() {
        this.view = null;
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }

    }
}
