package com.weather.tianle;

;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by tianle on 2015/9/15.
 */
public class WeatherHttpServer {
    HttpURLConnection connection = null;
    final  static String strURL  = "http://weather.bbk.com:15000/getvivoweather/?city=";
    public static Weather getDateFromInternet(String city)
    {
        URL url = null;
        try {
            url = new URL(strURL+URLEncoder.encode(city,"gbk"));

            HttpURLConnection connection = (HttpURLConnection )url.openConnection();

            connection.setConnectTimeout(5 * 1000);

            if (connection.getResponseCode() == 200)
            {
                InputStream in = connection.getInputStream();

                return SaxParseServices.getDataFromXML(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
