package com.weather.tianle;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class AddCity extends Activity {

    DBManagerCity dbManagerCity = null;  //creat the database of city.db
    DBCityHelper dbCityHelper = null;   //manager of the city,db
    ListView searchList = null;   //search result
    TextView tvSearch = null; //文本输入
    String [] hotCityList = null;  //the list of the hotCity
    CityListSharePrefer cityList = null; //城市信息记录表
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        dbManagerCity = new DBManagerCity(this);  //创建city数据库
        cityList = new CityListSharePrefer(this);  //添加的城市列表
        GridView gvCity = (GridView)findViewById(R.id.gvCity);
        hotCityList = this.getResources().getStringArray(R.array.hotCityList); //获取热门城市列表
        ArrayAdapter<String> adCity = new ArrayAdapter<String>(this,R.layout.city_list,hotCityList); //获取热门城市列表
        gvCity.setAdapter(adCity);
        gvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {    //设置点击热门城市事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //添加该城市到城市列表，并跳转到主界面
                cityList.addCity(hotCityList[position]);
                Intent intent = new Intent(AddCity.this, MainActivity.class);
                intent.putExtra("position",cityList.getCityList().size()-1);  //传递数据
                startActivity(intent);
            }
        });

        //setting the lisner of the seacrchTextView
        tvSearch = (TextView)findViewById(R.id.searchContent);

        tvSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            //输入文字改变的事件
            public void onTextChanged(CharSequence scityname, int start, int before, int count) {

               // Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

                dbCityHelper = new DBCityHelper(getApplicationContext());

                SQLiteDatabase sqlCity = dbCityHelper.getReadableDatabase();

                String cityName = scityname.toString();

                String sql = "select _id,province, city from city where city like ?";

                Cursor cursor =sqlCity.rawQuery(sql,new String[]{cityName+"%"});

                if(cursor != null)
                {
                    SimpleCursorAdapter adapter = new SimpleCursorAdapter(AddCity.this,R.layout.search_city_item,cursor,new String[]{"province","city"},
                            new int[]{R.id.province,R.id.city}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

                    ListView lvSearchResult = (ListView)findViewById(R.id.searchResult);
                    lvSearchResult.setAdapter(adapter);  //显示查找到的数据
                    lvSearchResult.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()<=0)
                {
                    ListView lvSearchResult = (ListView)findViewById(R.id.searchResult);
                    lvSearchResult.setVisibility(View.GONE);
                   // Toast.makeText(getApplicationContext(),String.valueOf(s.length()), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //setting the onclick of the listview

        searchList = (ListView)findViewById(R.id.searchResult);

        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tx = (TextView)view.findViewById(R.id.city); //获取城市信息
                cityList.addCity(tx.getText().toString());
                Intent intent = new Intent(AddCity.this,MainActivity.class);
                intent.putExtra("position",cityList.getCityList().size()-1);  //传递数据
                startActivity(intent);
                finish();
               // Toast.makeText(getApplicationContext(),tx.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_city, menu);
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
}
