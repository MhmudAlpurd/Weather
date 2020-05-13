package com.totonarya.weather.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.totonarya.weather.R;
import com.totonarya.weather.base.BaseFragment;
import com.totonarya.weather.data.WeatherRepository;
import com.totonarya.weather.data.pojo.current.CurrentWeather;
import com.totonarya.weather.utils.Consts;
import com.totonarya.weather.utils.Func;

public class CurrentWeatherFragment extends BaseFragment implements HomeContract.View {
    ImageView kebabMenu, arrowUp, weatherIcon;
    TextView cityName, humidity, date, tempChart, cityState, maxTemprature, mainCurrentTemp, weatherSituation, weatherDescription, currentTemp, minTemperature, windSpeed;
    FloatingActionButton fab_Main;
    int Weather_ID_fromData, Pressure_fromData, Humidity_fromData, SunriseTime_fromData, SunSetTime_fromData, currentTemp_fromData_Converted, maxTemprature_fromData_Converted;
    String Weather_CurrentSituation_fromData, Weather_Description_fromData, Weather_Icon_fromData,
            Clouds_fromData, State_fromData, City_fromData, TimeConverted_fromData;
    private Double Temp_fromData, Temp_Max_fromData, Temp_Min_fromData, WindSpeed_fromData, currentTemp_fromData;


    public Func func;


    private HomeContract.Presenter presenter;
    String City = "Shiraz";
    String State = "Iran";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(new WeatherRepository(), City, State);
        func = new Func();
    }

    @Override
    public void setupViews() {
        humidity = rootView.findViewById(R.id.txt_Humidity_currentweatherfrag);
        windSpeed = rootView.findViewById(R.id.txt_WindSpeed_currentweatherfrag);
        minTemperature = rootView.findViewById(R.id.txt_minTemp_currentweatherfrag);
        weatherDescription = rootView.findViewById(R.id.txt_weatherDiscription_currentweatherfrag);
        weatherSituation = rootView.findViewById(R.id.txt_weathersituation_currentweatherfrag);
        weatherIcon = rootView.findViewById(R.id.img_WeatherIcon_currentweatherfrag);
        maxTemprature = rootView.findViewById(R.id.txt_maxTemp_currentweatherfrag);
        kebabMenu = rootView.findViewById(R.id.img_kebabmenu_main);
        arrowUp = rootView.findViewById(R.id.img_arrowup_main);
        cityName = rootView.findViewById(R.id.txt_cityname_currentweatherfrag);
        date = rootView.findViewById(R.id.txt_date_currentweatherfrag);
        tempChart = rootView.findViewById(R.id.txt_TempChart_MainActivity);
        fab_Main = rootView.findViewById(R.id.fab_Main);
        mainCurrentTemp = rootView.findViewById(R.id.txt_MainCurrentTemp_currentweatherfrag);
        currentTemp = rootView.findViewById(R.id.txt_CurrentTemp_currentweatherfrag);
    }


    @Override
    public int getLayout() {
        return R.layout.fragmentcurrentweather;
    }


    @Override
    public void OnSetData() {

        int currentTemp_fromData_Converted = func.kelvinToCenti(currentTemp_fromData);
        mainCurrentTemp.setText(currentTemp_fromData_Converted + "\u00B0" + "C");
        weatherDescription.setText(Weather_Description_fromData);

        String icon_Link = func.openWeather_Icon_Link(Weather_Icon_fromData);
        func.setImageByUrl(icon_Link, weatherIcon);
        currentTemp.setText(currentTemp_fromData_Converted + "\u00B0" + "C");

        int maxTemprature_fromData_Converted = func.kelvinToCenti(Temp_Max_fromData);
        maxTemprature.setText(maxTemprature_fromData_Converted + "\u00B0" + "C");

        int minTemprature_fromData_Converted = func.kelvinToCenti(Temp_Min_fromData);
        minTemperature.setText(minTemprature_fromData_Converted + "\u00B0" + "C");

        windSpeed.setText(WindSpeed_fromData +"m|s");
        humidity.setText(Humidity_fromData+"%");

        cityName.setText(City_fromData);
        date.setText(TimeConverted_fromData);




    }

    @Override
    public void showCurrentWeather(CurrentWeather currentWeather) {
        currentTemp_fromData = currentWeather.getMain().getTemp();
        Weather_ID_fromData = currentWeather.getWeather().get(0).getId();
        Weather_CurrentSituation_fromData = currentWeather.getWeather().get(0).getMain();
        Weather_Description_fromData = currentWeather.getWeather().get(0).getDescription();
        Weather_Icon_fromData = currentWeather.getWeather().get(0).getIcon();
        Temp_fromData = currentWeather.getMain().getTemp();
        Temp_Max_fromData = currentWeather.getMain().getTempMax();
        Temp_Min_fromData = currentWeather.getMain().getTempMin();
        Pressure_fromData = currentWeather.getMain().getPressure();
        Humidity_fromData = currentWeather.getMain().getHumidity();
        WindSpeed_fromData = currentWeather.getWind().getSpeed();
        Clouds_fromData = currentWeather.getClouds().getAll().toString();
        State_fromData = currentWeather.getSys().getCountry();
        SunriseTime_fromData = currentWeather.getSys().getSunrise();
        SunSetTime_fromData = currentWeather.getSys().getSunset();
        City_fromData = currentWeather.getName();
        TimeConverted_fromData = func.unix_To_UTC(currentWeather.getDt());

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
