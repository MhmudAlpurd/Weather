package com.totonarya.weather.forecastweather;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
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

public class ForecastWeatherFragment extends BaseFragment implements ForecastContract.View {
    ForecastContract.Presenter presenter;
    List<Integer> tempsList = new ArrayList<>();
    String city = "Tehran";
    String state = "Iran";
    Func func = new Func();
    BarChart mBarChart;
    //RecyclerView
    RecyclerView forecastRecyclerView;
    List<com.totonarya.weather.data.pojo.forecast.List> mItem = new ArrayList<>();
    ForecastItemsAdapter forecastItemsAdapter;
    TextView textView;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ForecastPresenter(new WeatherRepository(), city, state);
        mBarChart = rootView.findViewById(R.id.barChart);
        forecastRecyclerView = rootView.findViewById(R.id.rv_ForecastItems_ForecastActivity);
        Log.d("ForecastActivity","onCreate");
        textView.setText("Two");




    }

    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragmentforecastweather ;
    }

    @Override
    public void OnSetData() {
        Log.d("ForecastActivity","OnSetData");
    }

    @Override
    public void showForecastWeather(ForecastWeather forecastWeatherList) {
        int d = forecastWeatherList.getList().size();
        Double f = forecastWeatherList.getList().get(0).getMain().getTemp();
        mItem = forecastWeatherList.getList();

        for (int i = 0; i < d; i++) {
            Double tempList_Kelvin = forecastWeatherList.getList().get(i).getMain().getTemp();
            String date = forecastWeatherList.getList().get(i).getDt().toString();
            int tempList_Converted = func.kelvinToCenti(tempList_Kelvin);
            tempsList.add(tempList_Converted);
            int color = func.color_Selector(tempList_Converted);
            mBarChart.addBar(new BarModel((float) tempList_Converted, color));
            //TODO: SET DATES INSTEAD OF LEGENDS OF BARCHART.


        }
        mBarChart.startAnimation();
        sendDataToRV();
        Log.d("ForecastActivity","showForecastWeather");
    }


    public void sendDataToRV() {
        forecastItemsAdapter = new ForecastItemsAdapter(mItem, getViewContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getViewContext());
        forecastRecyclerView.setLayoutManager(mLayoutManager);
        forecastRecyclerView.setAdapter(forecastItemsAdapter);
        Log.d("ForecastActivity","sendDataToRV");
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getViewContext(), error, Toast.LENGTH_SHORT).show();
        Log.d("ForecastFragment","showError");
    }





    @Override
    public void onStart() {
        super.onStart();
        Log.d("ForecastFragment","onStart");
        presenter.attachView(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
    @Override
    public Context getViewContext() {
        return getContext();
    }
}
