package com.weather.tianle;

import com.weather.tianle.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianle on 2015/9/21.
 */
public class StringToImage {

   final  static HashMap<String, Integer> weatherMap = new HashMap<String, Integer>() {
        {
            put("晴", R.mipmap.org3_ww0);
            put("多云", R.mipmap.org3_ww1);
            put("阴",R.mipmap.org3_ww2);
            put("阵雨",R.mipmap.org3_ww4);
            put("雷阵雨",R.mipmap.org3_ww4);
            put("雷阵雨伴有冰雹",R.mipmap.org3_ww5);
            put("雨夹雪",R.mipmap.org3_ww6);
            put("小雨",R.mipmap.org3_ww7);
            put("中雨",R.mipmap.org3_ww8);
            put("大雨",R.mipmap.org3_ww9);
            put("暴雨",R.mipmap.org3_ww10);
            put("大暴雨",R.mipmap.org3_ww10);
            put("特大暴雨",R.mipmap.org3_ww10);
            put("阵雪",R.mipmap.org3_ww13);
            put("小雪",R.mipmap.org3_ww14);
            put("中雪",R.mipmap.org3_ww15);
            put("大雪",R.mipmap.org3_ww16);
            put("暴雪",R.mipmap.org3_ww17);
            put("雾",R.mipmap.org3_ww18);
            put("冻雨",R.mipmap.org3_ww19);
            put("沙尘暴",R.mipmap.org3_ww20);
            put("小到中雨",R.mipmap.org3_ww8);
            put("中到大雨",R.mipmap.org3_ww9);
            put("大到暴雨",R.mipmap.org3_ww10);
            put("暴雨到大暴雨",R.mipmap.org3_ww10);
            put("大暴雨到特大暴雨",R.mipmap.org3_ww10);
            put("小到中雪",R.mipmap.org3_ww15);
            put("中到大雪",R.mipmap.org3_ww16);
            put("大到暴雪",R.mipmap.org3_ww17);
        }
    };

    final  static HashMap<String,Integer> weatherBg = new HashMap<String,Integer>(){
        {
            put("晴", R.mipmap.bg0_fine_day);
            put("多云", R.mipmap.bg_fog_day);
            put("阴",R.mipmap.bg_fog_day);
            put("阵雨",R.mipmap.bg_moderate_rain_day);
            put("雷阵雨",R.mipmap.bg_moderate_rain_day);
            put("雷阵雨伴有冰雹",R.mipmap.bg_moderate_rain_day);
            put("雨夹雪",R.mipmap.bg_moderate_rain_day);
            put("小雨",R.mipmap.bg_moderate_rain_day);
            put("中雨",R.mipmap.bg_moderate_rain_day);
            put("大雨",R.mipmap.bg_moderate_rain_day);
            put("暴雨",R.mipmap.bg_moderate_rain_day);
            put("大暴雨",R.mipmap.bg_moderate_rain_day);
            put("特大暴雨",R.mipmap.bg_moderate_rain_day);
            put("阵雪",R.mipmap.bg_moderate_rain_day);
            put("小雪",R.mipmap.bg_moderate_rain_day);
            put("中雪",R.mipmap.bg_moderate_rain_day);
            put("大雪",R.mipmap.bg_moderate_rain_day);
            put("暴雪",R.mipmap.bg_moderate_rain_day);
            put("雾",R.mipmap.bg_moderate_rain_day);
            put("冻雨",R.mipmap.bg_moderate_rain_day);
            put("沙尘暴",R.mipmap.bg_fog_and_haze);
            put("小到中雨",R.mipmap.bg_moderate_rain_day);
            put("中到大雨",R.mipmap.bg_moderate_rain_day);
            put("大到暴雨",R.mipmap.bg_moderate_rain_day);
            put("暴雨到大暴雨",R.mipmap.bg_moderate_rain_day);
            put("大暴雨到特大暴雨",R.mipmap.bg_moderate_rain_day);
            put("小到中雪",R.mipmap.bg_moderate_rain_day);
            put("中到大雪",R.mipmap.bg_moderate_rain_day);
            put("大到暴雪",R.mipmap.bg_moderate_rain_day);
        }
    };
  public  static int getImageFromStr(String weather)
  {
      if (!weatherMap.containsKey(weather))
      {
          return weatherMap.get("晴");
      }
      else
      {
          return weatherMap.get(weather);
      }
  }
    public  static int getBgImageFromStr(String weather)
    {
        if (!weatherBg.containsKey(weather))
        {
            return weatherBg.get("晴");
        }
        else
        {
            return weatherBg.get(weather);
        }
    }


}
