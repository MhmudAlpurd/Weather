package com.totonarya.weather.data.pojo.searchCity;

public class SearchCities {

    private int id;
    private String cityName;
    private String country;
    private String iso1;
    private String iso2;
    private int fav;

    public SearchCities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso1() {
        return iso1;
    }

    public void setIso1(String iso1) {
        this.iso1 = iso1;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }
}
