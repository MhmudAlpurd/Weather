package com.totonarya.weather.forecastweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.totonarya.weather.R;
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
    List<com.totonarya.weather.data.pojo.forecast.List> mItem = new ArrayList<>();
    ForecastItemsAdapter forecastItemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        presenter = new ForecastPresenter(new WeatherRepository(), city, state);
        mBarChart = findViewById(R.id.barChart);
        forecastRecyclerView = findViewById(R.id.rv_ForecastItems_ForecastActivity);



    }

    @Override
    public void OnSetData() {
        Log.d("ForecastActivity","OnSetData");
    }

    @Override
    public void showForecastWeather(ForecastWeather forecastWeather) {
        int d = forecastWeather.getList().size();
        Double f = forecastWeather.getList().get(0).getMain().getTemp();
        mItem = forecastWeather.getList();

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
        sendDataToRV();
        Log.d("ForecastActivity","showForecastWeather");
    }

    public void sendDataToRV() {
        forecastItemsAdapter = new ForecastItemsAdapter(mItem, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        forecastRecyclerView.setLayoutManager(mLayoutManager);
        forecastRecyclerView.setAdapter(forecastItemsAdapter);
        Log.d("ForecastActivity","sendDataToRV");
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        Log.d("ForecastActivity","showError");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ForecastActivity","onStart");
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ForecastActivity","onStop");
        presenter.detachView();
    }

    @Override
    public Context getViewContext() {

        Log.d("ForecastActivity","getViewContext");
        return this.getViewContext();
    }
}
