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
    private ImageView weatherIcon;
    private TextView cityName;
    private TextView humidity;
    private TextView date;
    private TextView weatherSituation;
    private String weather_CurrentSituation_fromData;

    private TextView maxTemprature;
    private TextView mainCurrentTemp;
    private TextView weatherDescription;
    private TextView currentTemp;
    private TextView minTemperature;
    private TextView windSpeed;
    private int Humidity_fromData;
    private String Weather_Description_fromData;
    private String Weather_Icon_fromData;
    private String City_fromData;
    private String TimeConverted_fromData;
    private Double Temp_Max_fromData;
    private Double Temp_Min_fromData;
    private Double WindSpeed_fromData;
    private Double currentTemp_fromData;


    public Func func;


    private HomeContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String city = "Tehran";
        String state = "Iran";
        presenter = new HomePresenter(new WeatherRepository(), city, state);
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
        cityName = rootView.findViewById(R.id.txt_cityname_currentweatherfrag);
        date = rootView.findViewById(R.id.txt_date_currentweatherfrag);
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

        windSpeed.setText(WindSpeed_fromData + "m|s");
        humidity.setText(Humidity_fromData + "%");

        cityName.setText(City_fromData);
        date.setText(TimeConverted_fromData);
        weatherSituation.setText(weather_CurrentSituation_fromData);


    }

    @Override
    public void showCurrentWeather(CurrentWeather currentWeather) {
        currentTemp_fromData = currentWeather.getMain().getTemp();
        int weather_ID_fromData = currentWeather.getWeather().get(0).getId();
        weather_CurrentSituation_fromData = currentWeather.getWeather().get(0).getMain();
        Weather_Description_fromData = currentWeather.getWeather().get(0).getDescription();
        Weather_Icon_fromData = currentWeather.getWeather().get(0).getIcon();
        Double temp_fromData = currentWeather.getMain().getTemp();
        Temp_Max_fromData = currentWeather.getMain().getTempMax();
        Temp_Min_fromData = currentWeather.getMain().getTempMin();
        int pressure_fromData = currentWeather.getMain().getPressure();
        Humidity_fromData = currentWeather.getMain().getHumidity();
        WindSpeed_fromData = currentWeather.getWind().getSpeed();
        String clouds_fromData = currentWeather.getClouds().getAll().toString();
        String state_fromData = currentWeather.getSys().getCountry();
        int sunriseTime_fromData = currentWeather.getSys().getSunrise();
        int sunSetTime_fromData = currentWeather.getSys().getSunset();
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
