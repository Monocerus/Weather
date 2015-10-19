package com.weather.tianle;

import java.io.Serializable;

/**
 * Created by tianle on 2015/9/21.
 */
public class Conditions implements Serializable
{

    private static final long serialVersionUID = 1L;

    String date;
    String week;
    String condition;
    String direction;
    String wind;
    int humidity;
    int low;
    int high;
    int body_temp1;
    int body_temp2;
    int contamination;
    String cont_msg;
    String air_condition;
    String air_condition_msg;
    int carwash;
    String carwash_msg;
    int dress;
    String dress_msg;
    String rays;
    String rays_msg;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAir_condition() {
        return air_condition;
    }

    public void setAir_condition(String air_condition) {
        this.air_condition = air_condition;
    }


    public String getRays() {
        return rays;
    }

    public void setRays(String rays) {
        this.rays = rays;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getBody_temp1() {
        return body_temp1;
    }

    public void setBody_temp1(int body_temp1) {
        this.body_temp1 = body_temp1;
    }

    public int getBody_temp2() {
        return body_temp2;
    }

    public void setBody_temp2(int body_temp2) {
        this.body_temp2 = body_temp2;
    }

    public int getContamination() {
        return contamination;
    }

    public void setContamination(int contamination) {
        this.contamination = contamination;
    }

    public String getCont_msg() {
        return cont_msg;
    }

    public void setCont_msg(String cont_msg) {
        this.cont_msg = cont_msg;
    }

    public String getAir_condition_msg() {
        return air_condition_msg;
    }

    public void setAir_condition_msg(String air_condition_msg) {
        this.air_condition_msg = air_condition_msg;
    }

    public int getCarwash() {
        return carwash;
    }

    public void setCarwash(int carwash) {
        this.carwash = carwash;
    }

    public String getCarwash_msg() {
        return carwash_msg;
    }

    public void setCarwash_msg(String carwash_msg) {
        this.carwash_msg = carwash_msg;
    }

    public int getDress() {
        return dress;
    }

    public void setDress(int dress) {
        this.dress = dress;
    }

    public String getDress_msg() {
        return dress_msg;
    }

    public void setDress_msg(String dress_msg) {
        this.dress_msg = dress_msg;
    }

    public String getRays_msg() {
        return rays_msg;
    }

    public void setRays_msg(String rays_msg) {
        this.rays_msg = rays_msg;
    }

    public String toString() {
        return "Conditions [date=" + date + ", week=" + week + ", condition="
                + condition + ", direction=" + direction + ", wind=" + wind
                + ", humidity=" + humidity + ", low=" + low + ", high=" + high
                + ", body_temp1=" + body_temp1 + ", body_temp2=" + body_temp2
                + ", contamination=" + contamination + ", cont_msg=" + cont_msg
                + ", air_condition=" + air_condition + ", air_condition_msg="
                + air_condition_msg + ", carwash=" + carwash + ", carwash_msg="
                + carwash_msg + ", dress=" + dress + ", dress_msg=" + dress_msg
                + ", rays=" + rays + ", rays_msg=" + rays_msg + "]";
    }


}


