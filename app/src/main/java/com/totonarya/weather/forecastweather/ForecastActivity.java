package com.totonarya.weather.forecastweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.totonarya.weather.R;
import com.totonarya.weather.data.Item;
import com.totonarya.weather.data.WeatherRepository;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;
import com.totonarya.weather.utils.Func;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;


import java.util.ArrayList;
import java.util.List;

public class ForecastActivity extends AppCompatActivity implements ForecastContract.View {
    ForecastContract.Presenter presenter;
    List<Integer> tempsList = new ArrayList<>();
    String city = "Tehran";
    String state = "Iran";
    Func func = new Func();
    BarChart mBarChart;
    //RecyclerView
    RecyclerView forecastRecyclerView;
    List<Item> mItem = new ArrayList<>();
    ForecastItemsAdapter forecastItemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        presenter = new ForecastPresenter(new WeatherRepository(), city, state);
        mBarChart = findViewById(R.id.barChart);
        //RecyclerView
        forecastRecyclerView = findViewById(R.id.rv_ForecastItems_ForecastActivity);
        forecastItemsAdapter = new ForecastItemsAdapter(mItem, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        forecastRecyclerView.setLayoutManager(mLayoutManager);
        forecastRecyclerView.setAdapter(forecastItemsAdapter);


        OnSetData();


    }

    @Override
    public void OnSetData() {
        mItem.add(new Item(1,"name_One","Message_One","Time_One"));
        mItem.add(new Item(2,"name_Two","Message_Two","Time_Two"));
        mItem.add(new Item(3,"name_Three","Message_Three","Time_Three"));
        mItem.add(new Item(4,"name_Four","Message_Four","Time_Four"));
        forecastItemsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showForecastWeather(ForecastWeather forecastWeather) {

        int d = forecastWeather.getList().size();
        Double f = forecastWeather.getList().get(0).getMain().getTemp();

        for (int i = 0; i < d; i++) {
            Double tempList_Kelvin = forecastWeather.getList().get(i).getMain().getTemp();
            String date = forecastWeather.getList().get(i).getDt().toString();
            int tempList_Converted = func.kelvinToCenti(tempList_Kelvin);
            tempsList.add(tempList_Converted);
            int color = func.color_Selector(tempList_Converted);
            mBarChart.addBar(new BarModel((float) tempList_Converted, color));
            //TODO: SET DATES INSTEAD OF LEGENDS OF BARCHART.
        }

        mBarChart.startAnimation();

    }

    @Override
    public void showError(String error) {
        Log.d("LLL", error);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public Context getViewContext() {
        return this.getViewContext();
    }
}

