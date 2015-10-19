package com.weather.tianle;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    TextView tv_temperature;
    ImageView iv_current_weather;
    TextView tv_current_weather;
    TextView tv_current_week;
    TextView tv_tv_temperature_range;
    TextView tv_current_date;
    TextView tv_humidity;
    TextView tv_wind;
    TextView tv_cont_msg;
    TextView tv_dress_msg;
    TextView tv_rays_msg;
    TextView tv_wash_car;
    ListView lv_weatherList;
    TextView tv_direction;
    ScrollView scrollView;
    View main_message;
    Weather weather;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(Weather weather) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putSerializable("weather",weather);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weather = getArguments() != null ? (Weather) getArguments().getSerializable("weather") : null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        main_message =  rootView.findViewById(R.id.main_message);
        tv_temperature = (TextView) rootView.findViewById(R.id.tv_temperature);
        iv_current_weather = (ImageView )rootView.findViewById(R.id.iv_current_weather);
        tv_current_weather = (TextView )rootView.findViewById(R.id.tv_current_weather);
        tv_current_week = (TextView)rootView.findViewById(R.id.tv_current_week);
        lv_weatherList = (ListView) rootView.findViewById(R.id.lv_weatherList);
        tv_tv_temperature_range =(TextView)rootView.findViewById(R.id.tv_tv_temperature_range);
        tv_current_date =(TextView)rootView.findViewById(R.id.tv_current_date);
        tv_humidity = (TextView)rootView.findViewById(R.id.tv_humidity);
        tv_direction = (TextView)rootView.findViewById(R.id.tv_direction);
        tv_wind = (TextView)rootView.findViewById(R.id.tv_wind);
        tv_cont_msg =(TextView)rootView.findViewById(R.id.tv_cont_msg);
        tv_dress_msg = (TextView)rootView.findViewById(R.id.tv_dress_msg);
        tv_rays_msg = (TextView)rootView.findViewById(R.id.tv_rays_msg);
        tv_wash_car = (TextView)rootView.findViewById(R.id.tv_wash_car);

        scrollView = (ScrollView)rootView.findViewById(R.id.scrollView);




        //getActivity().findViewById(R.id.root).setBackgroundResource(StringToImage.getBgImageFromStr(weather.getForcast_information().getCurrent_weather()));
        main_message.setBackgroundResource(StringToImage.getBgImageFromStr(weather.getForcast_information().getCurrent_weather()));  //设置背景图片
        tv_temperature.setText(String.valueOf(weather.getConditions()[0].getBody_temp1()) + "℃");
        iv_current_weather.setImageResource(StringToImage.getImageFromStr(weather.getForcast_information().getCurrent_weather()));
        tv_current_weather.setText(weather.getForcast_information().getCurrent_weather());
        tv_tv_temperature_range.setText(String.valueOf(weather.getConditions()[0].getLow()) + "℃~" + String.valueOf(weather.getConditions()[0].getHigh()));//设置温度范围
        String date =weather.getConditions()[0].getDate();
        tv_current_date.setText(date.substring(0,3)+"年"+Integer.parseInt(date.substring(4,5))+"月"+Integer.parseInt(date.substring(6,7))+"日");
        tv_current_week.setText(weather.getConditions()[0].getWeek());
        tv_humidity.setText(weather.getConditions()[0].getHumidity()+"%");
        tv_direction.setText(weather.getConditions()[0].getDirection()+"风");
        tv_wind.setText(weather.getConditions()[0].getWind());
        tv_cont_msg.setText(weather.getConditions()[0].getCont_msg());
        tv_dress_msg.setText(weather.getConditions()[0].getDress_msg());
        tv_rays_msg.setText(weather.getConditions()[0].getRays_msg());
        tv_wash_car.setText(weather.getConditions()[0].getCarwash_msg());

        ArrayList<HashMap<String, Object>> listWeatherItem = new ArrayList<HashMap<String,Object>>();/*在数组中存放数据*/
        Conditions[] conditions = weather.getConditions();
        for(int i=1;i<conditions.length;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("tv_date",conditions[i].getDate());
            map.put("tv_week",conditions[i].getWeek());
            map.put("iv_weather",StringToImage.getImageFromStr(conditions[i].getCondition()));
            map.put("tv_weatherMsg",conditions[i].getCondition());
            map.put("tv_temp",conditions[i].getLow()+"℃~"+conditions[i].getHigh()+"℃");
            listWeatherItem.add(map);
        }

        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this.getActivity(),listWeatherItem,R.layout.weather_list,
                new String[] {"tv_date","tv_week", "iv_weather","tv_weatherMsg","tv_temp"},
                new int[] {R.id.tv_date,R.id.tv_week,R.id.iv_weather,R.id.tv_weatherMsg,R.id.tv_temp});
        lv_weatherList.setAdapter(mSimpleAdapter);
        setListViewHeightBasedOnChildren(lv_weatherList);//设置listview高度
        lv_weatherList.setEnabled(false);


        return rootView;
    }

    public void installView()
    {

    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {  //获取listview高度
        if(listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
