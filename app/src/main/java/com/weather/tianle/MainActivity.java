package com.weather.tianle;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;  //定义滑动view
    FragmentMainAdaptor fragmentMainAdaptor;
    private CityListSharePrefer cityListSharePrefer;  //存储的城市列表
    private TextView cityName;  //城市名称
    private List<String> listCity = null;
    private ImageView location = null;  //位置按钮
    WeatherAsyncTask weatherAsyncTask;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        installView();//初始化控件
        listCity = cityListSharePrefer.getCityList(); //获取城市列表
        if (listCity == null)  //如果城市列表为空
        {
            Intent intent = new Intent(MainActivity.this, AddCity.class);
            startActivity(intent);
            finish();
        }
        fragmentMainAdaptor = new FragmentMainAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(fragmentMainAdaptor);
        //获取城市信息
        weatherAsyncTask = new WeatherAsyncTask();
        weatherAsyncTask.execute((String[]) listCity.toArray(new String[listCity.size()]));
        cityName.setText(listCity.get(0));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {

                cityName.setText(listCity.get(position));
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityList.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void installView()
    {
        cityListSharePrefer = new CityListSharePrefer(this);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        cityName = (TextView) findViewById(R.id.tv_location);
        location = (ImageView) findViewById(R.id.location);
    }

    public class WeatherAsyncTask extends AsyncTask<String,Integer,Weather[]> {

        @Override
        protected Weather[] doInBackground(String... params) {
            int size = params.length;
            Weather[] weathers = new Weather[size];
            for(int i = 0;i<size;i++)
            {
                weathers[i] = WeatherHttpServer.getDateFromInternet(params[i]);
            }
            return weathers;
        }
        @Override
        protected void onPostExecute(Weather[] weathers) {   //更新ui
            super.onPostExecute(weathers);
            fragmentMainAdaptor.setWeathers(weathers);
            fragmentMainAdaptor.notifyDataSetChanged();
        }
    }

}

