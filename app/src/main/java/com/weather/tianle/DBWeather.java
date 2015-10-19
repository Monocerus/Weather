package com.weather.tianle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tianle on 2015/9/24.
 */
public class DBWeather {
    SQLiteDatabase sqLiteDatabase = null;
    DBWeatherHelper dbWeatherHelper =  null;
    public DBWeather(Context context)
    {
        dbWeatherHelper = new DBWeatherHelper(context);
    }

    public void insertCityWeather(Weather weather){
        String sql = "insert into tb_current_weather (city,) values (?)";
        sqLiteDatabase = dbWeatherHelper.getWritableDatabase();
       // sqLiteDatabase.rawQuery()
    }

    public void closeDB()
    {
        sqLiteDatabase.close();
    }
}
