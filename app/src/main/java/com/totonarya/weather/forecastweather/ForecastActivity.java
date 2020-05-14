package com.totonarya.weather.forecastweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.totonarya.weather.R;
import com.totonarya.weather.data.WeatherRepository;
import com.totonarya.weather.data.pojo.forecast.ForecastWeather;
import com.totonarya.weather.utils.Func;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.LegendModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.util.ArrayList;
import java.util.List;

public class ForecastActivity extends AppCompatActivity implements ForecastContract.View {
    ForecastContract.Presenter presenter;
    List<Integer> tempsList = new ArrayList<>();
    String city = "Tehran";
    String state = "Iran";
    Func func = new Func();
    BarChart mBarChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        presenter = new ForecastPresenter(new WeatherRepository(), city, state);
        mBarChart = findViewById(R.id.barChart);

    }

    @Override
    public void OnSetData() {

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
        return null;
    }
}

