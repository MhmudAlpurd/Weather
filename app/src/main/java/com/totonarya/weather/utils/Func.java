package com.totonarya.weather.utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Func {

    public String unix_To_UTC(long unixSeconds) {
        // convert seconds to milliseconds
        Date date = new java.util.Date(unixSeconds * 1000L);
        // the format of your date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MMM-dd");
        // give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public String unix_To_weekday(long unixSeconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("EE");
        Date dateFormat = new java.util.Date(unixSeconds * 1000);
        String weekday = sdf.format(dateFormat);
        return weekday;
    }

    public String unix_To_hour(long unixSeconds, String zone) {
        //TODO: Send TimeZone!
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(unixSeconds * 1000L);
        cal.setTimeZone(TimeZone.getTimeZone(zone));
        String hour = cal.get(Calendar.HOUR_OF_DAY) + ":00";
        return hour;
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

    public int color_Selector(double temperature) {
        int color;
        if (temperature < -40) {
            color = 0xFF818281;
        } else if (-40 <= temperature && temperature < -37) {
            color = 0xFFcccccd;
        } else if (-37 <= temperature && temperature < -34.5) {
            color = 0xFFffffff;
        } else if (-34.5 <= temperature && temperature < -31.5) {
            color = 0xFFfde6ff;
        } else if (-31.5 <= temperature && temperature < -29) {
            color = 0xFFfac8fe;
        } else if (-29 <= temperature && temperature < -26) {
            color = 0xFFf664fd;
        } else if (-26 <= temperature && temperature < -23) {
            color = 0xFFe104e2;
        } else if (-23 <= temperature && temperature < -20) {
            color = 0xFFb164c0;
        } else if (-20 <= temperature && temperature < -18) {
            color = 0xFF8c01af;
        } else if (-18 <= temperature && temperature < -15) {
            color = 0xFF0c0096;
        } else if (-15 <= temperature && temperature < -12) {
            color = 0xFF1400c8;
        } else if (-12 <= temperature && temperature < -9.5) {
            color = 0xFF233cfd;
        } else if (-9.5 <= temperature && temperature < -6.5) {
            color = 0xFF338cf0;
        } else if (-6.5 <= temperature && temperature < -4) {
            color = 0xFF41b5fd;
        } else if (-4 <= temperature && temperature < -1) {
            color = 0xFF96e7fe;
        } else if (-1 <= temperature && temperature < 1.5) {
            color = 0xFF217802;
        } else if (1.5 <= temperature && temperature < 4.5) {
            color = 0xFF32a131;
        } else if (4.5 <= temperature && temperature < 7) {
            color = 0xFF3ec805;
        } else if (7 <= temperature && temperature < 10) {
            color = 0xFF64e764;
        } else if (10 <= temperature && temperature < 13) {
            color = 0xFF8cff8c;
        } else if (13 <= temperature && temperature < 15.5) {
            color = 0xFFb4ffb5;
        } else if (15.5 <= temperature && temperature < 18) {
            color = 0xFFfafba0;
        } else if (18 <= temperature && temperature < 21) {
            color = 0xFFf9f673;
        } else if (21 <= temperature && temperature < 24) {
            color = 0xFFf5dd5a;
        } else if (24 <= temperature && temperature < 27) {
            color = 0xFFf7b429;
        } else if (27 <= temperature && temperature < 29.5) {
            color = 0xFFf08c12;
        } else if (29.5 <= temperature && temperature < 32) {
            color = 0xFFdc5004;
        } else if (32 <= temperature && temperature < 38) {
            color = 0xFFf0273c;
        } else if (38 <= temperature && temperature < 40.5) {
            color = 0xFFb42703;
        } else if (40.5 <= temperature && temperature < 43.5) {
            color = 0xFFfac8dc;
        } else if (temperature <= 43.5) {
            color = 0xFF8c0101;
        } else {
            color = 0xFF8c0101;
        }
        return color;
    }

}
