package com.weather.tianle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tianle on 2015/9/15.
 */
public class DBWeatherHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "weather.db";
    private static final int DATABASE_VERSION = 1;
//    private static final String CREAT_TB_CURRENT_WEATHER = "create table if not exists tb_current_weather(_id integer primary key autoincrement, city text not null ," +
//            "current_date text, update_time text, current_weather text)";
    private static final String CREAT_TB_WEEK_WEATHER = "create table if not exists tb_week_weather(_id integer primary key autoincrement,day_order integer not null ,city text not null," +
            "thedate text, week text, condition text,direction text,wind text,humidity text,body_temp1 integer,body_temp2 integer,cont_msg text,air_condition_msg text,"+
            "low integer,high integer,carwash_msg text,dress_msg text,rays_msg text)";
    public DBWeatherHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    //首次创建数据库，创建表
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_TB_WEEK_WEATHER);
    }

    @Override
    //数据库版本发生变化时，自动调用
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
