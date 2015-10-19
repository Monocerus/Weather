package com.weather.tianle;

import java.io.Serializable;

/**
 * Created by tianle on 2015/9/21.
 */
public class Forecast_information implements Serializable
{
    private static final long serialVersionUID = 1L;

    String city;
    String current_date;
    String update_time;
    String current_weather;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }


    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(String current_weather) {
        this.current_weather = current_weather;
    }

    public String toString() {
        return "Forecast_information [city=" + city + ", current_date="
                + current_date + ", update_time=" + update_time
                + ", current_weather=" + current_weather + "]";
    }
}
