package com.totonarya.weather.home;

import com.totonarya.weather.data.WeatherDataSource;
import com.totonarya.weather.data.pojo.current.CurrentWeather;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    String City;
    String State;
    private WeatherDataSource weatherDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomePresenter(WeatherDataSource weatherDataSource, String City, String State) {
        this.weatherDataSource = weatherDataSource;
        this.City = City;
        this.State = State;
    }

    @Override
    public void getCurrentWeather(String City, String State) {
        weatherDataSource.getCurrentWeather(City, State).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CurrentWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(CurrentWeather currentWeather) {
                        view.showCurrentWeather(currentWeather);
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
    public void attachView(HomeContract.View view) {
        this.view = view;
        getCurrentWeather(City, State);


    }

    @Override
    public void detachView() {
        this.view = null;
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }

    }
}
