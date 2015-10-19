package com.weather.tianle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    CityListSharePrefer cityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        DBWeatherHelper dbWeather = new DBWeatherHelper(this);
        dbWeather.getReadableDatabase();
        DBManagerCity dbCity = new DBManagerCity(getApplicationContext());
        dbCity.openDatabase();

   //    Toast.makeText(this ,Environment.getDataDirectory().getAbsolutePath(),Toast.LENGTH_LONG).show();
        //初始化数据库
        try {
            Thread.sleep(15 * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cityList = new CityListSharePrefer(this);
        if(cityList.getCityList()==null)
        {
            Intent intent = new Intent(SplashActivity.this,AddCity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent  = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
        }
        finish(); //后退后结束
    }
}
