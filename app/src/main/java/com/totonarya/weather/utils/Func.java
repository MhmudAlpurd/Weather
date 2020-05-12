package com.totonarya.weather.utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Func {


    //unix to UTC!
    public String unix_To_UTC(long unixSeconds) {
        // convert seconds to milliseconds
        Date date = new java.util.Date(unixSeconds * 1000L);
        // the format of your date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        // give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public void setImageByUrl(String url, ImageView imageView) {
        Picasso.get().load(url).into(imageView);
    }

    public int kelvinToCenti(Double kelvin) {
        Double centigrade = kelvin - 273.15;
        int centInt = (int) Math.round(centigrade);
        return centInt;
    }

    public String openWeather_Icon_Link(String icon_ID) {
        String Icon_URL = MessageFormat.format("http://openweathermap.org/img/wn/{0}@2x.png", icon_ID);
        return Icon_URL;

    }


}
