package com.totonarya.weather.forecastweather;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.totonarya.weather.R;
import com.totonarya.weather.base.BaseFragment;
import com.totonarya.weather.data.WeatherRepository;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;
import com.totonarya.weather.utils.Func;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import java.util.ArrayList;
import java.util.List;

public class forecastWeatherFragment extends BaseFragment implements ForecastContract.View {
    ForecastContract.Presenter presenter;
    List<Integer> tempsList = new ArrayList<>();
    String city = "Tehran";
    String state = "Iran";
    Func func = new Func();
    BarChart mBarChart;
    List<com.totonarya.weather.data.pojo.forecast.List> mItem = new ArrayList<>();
    RecyclerView myRecyclerView;
    ForecastItemAdapter forecastItemAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ForecastPresenter(new WeatherRepository(), city, state);


    }

    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragmentforecastweather;
    }

    @Override
    public void OnSetData() {
        Log.d("FFL", "OnSetData");
    }

    @Override
    public void showForecastWeather(ForecastWeather forecastWeatherList) {
        mBarChart = (BarChart) getActivity().findViewById(R.id.barChart_ForecastFrag);
        double d = forecastWeatherList.getList().get(0).getWind().getSpeed();
        mItem = forecastWeatherList.getList();
        for (int i = 0; i < forecastWeatherList.getList().size(); i++) {
            double temp = forecastWeatherList.getList().get(i).getMain().getTemp();
            int temp_centi = func.kelvinToCenti(temp);
            tempsList.add(temp_centi);
            int temp_color = func.color_Selector(temp_centi);
            mBarChart.addBar(new BarModel((float) temp_centi, temp_color));

        }
        mBarChart.startAnimation();
        setDatatoRV();

    }

    public void setDatatoRV() {
        //rv
        myRecyclerView = getActivity().findViewById(R.id.recyclerView);
        forecastItemAdapter = new ForecastItemAdapter(mItem, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(forecastItemAdapter);

    }


    @Override
    public void showError(String error) {
        Log.d("FFL", "showError");
        Toast.makeText(getViewContext(), error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public Context getViewContext() {
        Log.d("FFL", "OnSetData");
        return getContext();

    }

    @Override
    public void onStart() {
        Log.d("FFL", "onStart");
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        Log.d("FFL", "OnSetData");
        super.onStop();
        presenter.detachView();
    }
}
