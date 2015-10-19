package com.weather.tianle;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianle on 2015/9/23.
 */
public class CityListSharePrefer {

    SharedPreferences preferences;

    SharedPreferences.Editor editor;

    public CityListSharePrefer(Context context)
    {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);

        editor = preferences.edit();
    }
    /**
     * get the city list
     * @return
     */

    public List<String> getCityList()
    {
        String listjson =preferences.getString("city",null);

        if (listjson==null){
            return null;
        }
        List<String> cityList = JSON.parseArray(listjson, String.class);
        return cityList;  //获取城市列表
    }

    /**
     * add the city
     * @param strCityName
     */
    public void addCity(String strCityName)
    {
        List<String> list =getCityList();
        if(list==null){
         list = new LinkedList<String>();
        }
        list.add(strCityName);
        editor.putString("city", JSON.toJSONString(list));  //添加城市
        editor.commit();
    }

    public void  deleteCity(int position)
    {
        List<String> list = getCityList();
        list.remove(position);
        editor.putString("city",JSON.toJSONString(list));  //删除城市
        editor.commit();
    }

}
