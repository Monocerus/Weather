package com.weather.tianle;

import java.io.Serializable;
import java.util.Arrays;


/**
 * Created by tianle on 2015/9/16.
 */
public class Weather implements Serializable
{

    private static final long serialVersionUID = 1L;

    Forecast_information forecast_information;

    Conditions []conditions = new Conditions[5];

    int used_time;

    public int getUsed_time() {
        return used_time;
    }

    public void setUsed_time(int used_time) {
        this.used_time = used_time;
    }

    public Forecast_information getForcast_information() {
        return forecast_information;
    }

    public void setForecast_information(Forecast_information forcast_information) {
        this.forecast_information = forcast_information;
    }

    public Conditions[] getConditions() {
        return conditions;
    }

    public void setConditions(Conditions[] conditions) {
        this.conditions = conditions;
    }



	public String toString() {
		return "Weather [forecast_information=" + forecast_information
				+ ", conditions="
				+ (conditions != null ? Arrays.asList(conditions) : null)
				+ ", used_time=" + used_time + "]";
	}
    
}


